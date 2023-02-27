package com.aviral.zevon.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aviral.zevon.R
import com.aviral.zevon.Utils.FirebaseAuthProvider
import com.aviral.zevon.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToLoginPage.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            val firebaseAuthProvider = FirebaseAuthProvider(this)

            val isSuccessful = firebaseAuthProvider.registerUserWithEmailAndPassword(
                binding.emailText.text.toString(),
                binding.passswordText.text.toString()
            )

            if (isSuccessful) {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
    }
}