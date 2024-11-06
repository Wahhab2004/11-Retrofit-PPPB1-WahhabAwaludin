package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class Data(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
