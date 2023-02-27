package com.aviral.zevon.Utils

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.aviral.zevon.Activities.MainActivity
import com.aviral.zevon.R
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthProvider(val context: Context) {

    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registerUserWithEmailAndPassword(email: String, password: String): Boolean {

        var isSuccessful: Boolean = false

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    Toast.makeText(context, "Registration Failed! Please try again", Toast.LENGTH_SHORT).show()

                    Log.d("FAP Aviral", "registerUserWithEmailAndPassword: Auth failed: " + it.exception)

                    isSuccessful = false

                } else if (it.isSuccessful)  {

                    Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show();

                    isSuccessful = true

                }
            }

        return isSuccessful

    }

    fun signInUserWithEmailAndPassword(email: String, password: String): Boolean {

        var isSuccessful = true

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    Toast.makeText(context, " Invalid email or password", Toast.LENGTH_SHORT).show()

                    Log.d("FAP Aviral", "registerUserWithEmailAndPassword: Login failed: " + it.exception)

                    isSuccessful = false

                }

            }

        return isSuccessful

    }

    fun signOutUser() {
        mAuth.signOut()
        context.startActivity(Intent(context, MainActivity::class.java))
        Toast.makeText(context, "Sign Out Successful", Toast.LENGTH_SHORT).show()
    }

}