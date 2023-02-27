package com.aviral.zevon.Utils

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.aviral.zevon.Activities.MainActivity
import com.aviral.zevon.Activities.ProfileActivity
import com.aviral.zevon.Models.Products
import com.aviral.zevon.Models.SellerForm
import com.aviral.zevon.Models.SellerUser
import com.aviral.zevon.R
import com.aviral.zevon.SellerActivities.SuccessfulActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FirebaseMethods(context: Context) {

    private val tag = "AviralKaushik"

    private var mAuth: FirebaseAuth
    private var myRef: DatabaseReference
    private var mStorageReference: StorageReference

    private lateinit var userId: String
    private var mContext: Context

    init {

        mContext = context

        mAuth = FirebaseAuth.getInstance()

        val firebaseDatabase: FirebaseDatabase =
            FirebaseDatabase.getInstance("https://zevon-3cd72-default-rtdb.asia-southeast1.firebasedatabase.app")
        myRef = firebaseDatabase.reference

        mStorageReference = FirebaseStorage.getInstance().reference

        if (mAuth.currentUser != null) {
            userId = mAuth.currentUser!!.uid
        }

    }

    fun getCurrentUserId(): String {
        return userId
    }

    fun uploadDocumentsAndAddUserToDatabase(
        aadharUrl: String,
        panUrl: String,
        gstinUrl: String,
        sellerForm: SellerForm
    ) {
        Log.d(tag, "uploadDocumentsAndAddUserToDatabase: Attempting to upload documents to storage")

        var addharStorageLocation = ""
        var panStorageLocation = ""
        var gstinStorageLocation = ""

        val aadharStorageReference = mStorageReference.child("Documents/$userId/aadhar")
        val panStorageReference = mStorageReference.child("Documents/$userId/pan")
        val gstinStorageReference = mStorageReference.child("Documents/$userId/gstin")

        val aadharBitmap = ImageManager.getBitmap(aadharUrl)
        val panBitmap = ImageManager.getBitmap(panUrl)
        val gstinBitmap = ImageManager.getBitmap(gstinUrl)

        val addharBytes: ByteArray = ImageManager.getByteFromBitmap(aadharBitmap, 100)
        val panBytes: ByteArray = ImageManager.getByteFromBitmap(panBitmap, 100)
        val gstinBytes: ByteArray = ImageManager.getByteFromBitmap(gstinBitmap, 100)

        val aadharUploadTask = aadharStorageReference.putBytes(addharBytes)
        val panUploadTask = panStorageReference.putBytes(panBytes)
        val gstinUploadTask = gstinStorageReference.putBytes(gstinBytes)

        aadharUploadTask.addOnSuccessListener {
            Toast.makeText(mContext, "Aadhar Upload Successful", Toast.LENGTH_SHORT).show()

            mStorageReference.child("Documents/$userId/aadhar").downloadUrl.addOnSuccessListener {
                addharStorageLocation = it.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(mContext, "Aadhar Upload Unsuccessful", Toast.LENGTH_SHORT).show()

            mContext.startActivity(Intent(mContext, MainActivity::class.java))
        }

        panUploadTask.addOnSuccessListener {
            Toast.makeText(mContext, "Pan Upload Successful", Toast.LENGTH_SHORT).show()

            mStorageReference.child("Documents/$userId/pan").downloadUrl.addOnSuccessListener {
                panStorageLocation = it.toString()
            }

        }.addOnFailureListener {
            Toast.makeText(mContext, "Pan Upload Unsuccessful", Toast.LENGTH_SHORT).show()

            mContext.startActivity(Intent(mContext, MainActivity::class.java))
        }

        gstinUploadTask.addOnSuccessListener {
            Toast.makeText(mContext, "GSTIN Upload Successful", Toast.LENGTH_SHORT).show()

            mStorageReference.child("Documents/$userId/gstin").downloadUrl.addOnSuccessListener {
                gstinStorageLocation = it.toString()
            }

            val sellerUser = SellerUser(
                userId,
                mAuth.currentUser!!.email,
                sellerForm.name,
                sellerForm.comapny,
                sellerForm.country,
                sellerForm.number,
                sellerForm.pan,
                sellerForm.gstin,
                sellerForm.aadhar,
                addharStorageLocation,
                panStorageLocation,
                gstinStorageLocation
            )

            addSellerUserToFirebase(sellerUser)

        }.addOnFailureListener {
            Toast.makeText(mContext, "GSTIN Upload Unsuccessful", Toast.LENGTH_SHORT).show()

            mContext.startActivity(Intent(mContext, MainActivity::class.java))
        }

    }

    private fun addSellerUserToFirebase(sellerUser: SellerUser) {

        myRef.child(mContext.getString(R.string.sellers))
            .child(userId)
            .setValue(sellerUser)

        mContext.startActivity(Intent(mContext, ProfileActivity::class.java))
        Toast.makeText(
            mContext,
            "Congratulations! You have joined zevon as seller successfully",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun generateNewProductId(): String {
        return myRef.push().key.toString()
    }

    fun addNewProductToDatabaseAndStorage(product: Products, isProductForUpdate: Boolean) {


        CoroutineScope(Dispatchers.Default).launch {

            val productStorageReference =
                mStorageReference.child("Products/${product.sellerUserId}/${product.productId}")

            val productImageDownloadUrlsArrayList: ArrayList<String> = ArrayList()

            product.productImages?.forEachIndexed { index, productImage ->

                val individualProductImage = product.productImages!!.get(index)

                val individualProductImageBitmap = ImageManager.getBitmap(individualProductImage)

                val individualProductImageByte: ByteArray =
                    ImageManager.getByteFromBitmap(individualProductImageBitmap, 100)

                val finalProductImageStorageReference =
                    productStorageReference.child("Images$index")

                val individualImageProductUploadTask =
                    finalProductImageStorageReference.putBytes(individualProductImageByte)

                individualImageProductUploadTask.addOnSuccessListener {

                    Toast.makeText(mContext, "Product Image upload Successful", Toast.LENGTH_SHORT)
                        .show()
                    Log.d(tag, "addNewProductToDatabaseAndStorage: Product Image Upload Successful")

                    finalProductImageStorageReference.downloadUrl.addOnSuccessListener {

                        productImageDownloadUrlsArrayList.add(it.toString())

                        if (productImageDownloadUrlsArrayList.size == product.productImages!!.size) {
                            addProductInformationToDatabase(
                                product,
                                productImageDownloadUrlsArrayList,
                                isProductForUpdate
                            )
                        }

                    }.addOnFailureListener {

                        Toast.makeText(
                            mContext,
                            "Product Image upload Unsuccessful",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.d(
                            tag,
                            "addNewProductToDatabaseAndStorage: Product Image Upload Unsuccessful: ${it.message}"
                        )

                        mContext.startActivity(Intent(mContext, MainActivity::class.java))
                    }

                }

            }
        }

    }

    private fun addProductInformationToDatabase(
        product: Products,
        productImageDownloadUrlsArrayList: ArrayList<String>,
        isProductForUpdate: Boolean
    ) {
        product.productImages?.forEachIndexed { index, string ->
            product.productImages!![index] = productImageDownloadUrlsArrayList[index]
        }

        myRef.child(mContext.getString(R.string.product))
            .child(product.productCategory.toString())
            .child(product.productId.toString())
            .setValue(product)

        val intent = Intent(mContext, SuccessfulActivity::class.java)

        if (isProductForUpdate) {
            Toast.makeText(mContext, "Product Updated Successfully", Toast.LENGTH_SHORT).show()

            intent.putExtra(
                mContext.getString(R.string.product_updated),
                mContext.getString(R.string.product_updated)
            )

        } else {
            Toast.makeText(mContext, "Product Uploaded Successfully", Toast.LENGTH_SHORT).show()

            intent.putExtra(
                mContext.getString(R.string.product_uploaded),
                mContext.getString(R.string.product_uploaded)
            )

        }

        intent.putExtra(mContext.getString(R.string.product), product)
        mContext.startActivity(intent)

    }

}
