package com.aviral.zevon.Models

import android.os.Parcel
import android.os.Parcelable

data class Products(
    var sellerUserId: String?,
    var productId: String?,
    var productTitle: String?,
    var productPrice: String?,
    var productImages: ArrayList<String>?,
    var productDescription: String?,
    var productRatings: ArrayList<Rating>?,
    var productAverageRating: Double,
    var productStock: Int,
    var productCategory: String?) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.createTypedArrayList(Rating.CREATOR),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(sellerUserId)
        parcel.writeString(productId)
        parcel.writeString(productTitle)
        parcel.writeString(productPrice)
        parcel.writeString(productDescription)
        parcel.writeStringList(productImages)
        parcel.writeArray(arrayOf(productRatings))
        parcel.writeDouble(productAverageRating)
        parcel.writeInt(productStock)
        parcel.writeString(productCategory)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Products> {
        override fun createFromParcel(parcel: Parcel): Products {
            return Products(parcel)
        }

        override fun newArray(size: Int): Array<Products?> {
            return arrayOfNulls(size)
        }
    }

}