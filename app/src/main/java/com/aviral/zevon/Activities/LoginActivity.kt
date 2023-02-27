package com.aviral.zevon.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aviral.zevon.Utils.FirebaseAuthProvider
import com.aviral.zevon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToLogin.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            val firebaseAuthProvider = FirebaseAuthProvider(this)

            val isSuccessful = firebaseAuthProvider.signInUserWithEmailAndPassword(
                binding.username.text.toString(),
                binding.password.text.toString()
            )

            if (isSuccessful) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

    }
}