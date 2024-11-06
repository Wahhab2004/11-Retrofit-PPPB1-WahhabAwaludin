package com.example.retrofit.network

import com.example.retrofit.model.Users
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {

    @GET("users?page=2")
    fun getAllUsers(): Call<Users>

    companion object {
        private const val BASE_URL = "https://reqres.in/api/"

        // Singleton instance
        private var retrofit: Retrofit? = null

        fun getInstance(): ApiClient {

            if (retrofit == null) {

                // Jika retrofit belum diinisialisasi, buat instansi baru
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL) // utk mengirimkan permintaan serta menerima data dari url  tersebut
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().build())
                    .build()
            }
            return retrofit!!.create(ApiClient::class.java)
        }
    }
}
