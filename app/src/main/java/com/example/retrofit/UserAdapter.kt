package com.example.retrofit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.databinding.ItemUserBinding
import com.example.retrofit.model.Data
import com.example.retrofit.ui.DetailActivity

class UserAdapter(private val context: Context, private val userList: List<Data>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // Berfungsi membuat objek user
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    // Mengisi data objek ke dalam UserViewHolder
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvName.text = "${user.first_name} ${user.last_name}"
        holder.tvEmail.text = user.email

        // Utk mengubah dari string path atau url menjadi gambar
        Glide.with(context)
            .load(user.avatar)
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.ivAvatar)

        // Menangani klik pada item
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)

            // Mengirimkan data ke DetailActivity
            intent.putExtra("USER_ID", user.id)
            intent.putExtra("USER_NAME", "${user.first_name} ${user.last_name}")
            intent.putExtra("USER_EMAIL", user.email)
            intent.putExtra("USER_AVATAR", user.avatar)
            context.startActivity(intent)
        }
    }

    // Mengembalikan jumlah item yang ada di dalam userList
    override fun getItemCount(): Int = userList.size


    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvEmail: TextView = view.findViewById(R.id.tvEmail)
    }
}
