package com.aviral.zevon.Activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.aviral.zevon.R


class DeveloperProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer_profile)

        val websiteCard: CardView = findViewById(R.id.website_card)
        val websiteLink: TextView = findViewById(R.id.aviral_website_link)
        val avichalMail: TextView = findViewById(R.id.avichal_email)
        val aviralMail: TextView = findViewById(R.id.aviral_email)

        websiteCard.setOnClickListener { launchAviralWebsite() }
        websiteLink.setOnClickListener { launchAviralWebsite() }

        avichalMail.setOnClickListener { openEmail("avichalkaushik0007@gmail.com") }
        aviralMail.setOnClickListener { openEmail("aviralkaushik0007@gmail.com") }

    }

    private fun launchAviralWebsite() {
        val websiteIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://aviralkaushik.epizy.com")
        )

        startActivity(websiteIntent)
    }

    private fun openEmail(email: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email))
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Cannot open mail at this moment", Toast.LENGTH_SHORT).show()
        }
    }

}