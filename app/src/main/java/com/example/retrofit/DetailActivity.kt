package com.example.retrofit.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofit.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val ivAvatar = findViewById<ImageView>(R.id.ivAvatar)

        // Mengambil data yang dikirimkan dari MainActivity
        val userName = intent.getStringExtra("USER_NAME")
        val userEmail = intent.getStringExtra("USER_EMAIL")
        val userAvatar = intent.getStringExtra("USER_AVATAR")

        // Menampilkan data ke tampilan
        tvName.text = userName
        tvEmail.text = userEmail

        // Memuat avatar pengguna menggunakan Glide
        Glide.with(this)
            .load(userAvatar)
            .placeholder(R.drawable.ic_placeholder)
            .into(ivAvatar)
    }
}
