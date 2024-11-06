package com.example.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.UserAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.model.Users
import com.example.retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val client = ApiClient.getInstance() // menginisialisasi library retrofit
        val response = client.getAllUsers()  // memanggil serta menjalankan fungsi @GET

        // Memuat data ke dalam RecyclerView
        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    val users = response.body()!!.data // utk nge get data dari json
                    val adapter = UserAdapter(this@MainActivity, users)
                    binding.recyclerView.adapter = adapter
                }
            }
            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error", Toast.LENGTH_LONG).show()
            }
        })
    }
}
