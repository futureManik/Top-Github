package com.example.top_github.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.top_github.R
import com.example.top_github.models.User
import com.example.top_github.views.UserDetailActivity

class UserAdapter(private val context: Context, private val userList: List<User>?) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.name.text = userList?.get(position)?.name ?: "Error"
        holder.username.text = userList?.get(position)?.username ?: "Error"

    }

    override fun getItemCount(): Int {
        return userList?.size ?: 0
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatar: ImageView = itemView.findViewById(R.id.avatar_iv)
        var name: TextView = itemView.findViewById(R.id.name_tv)
        var username: TextView = itemView.findViewById(R.id.username_tv)

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, UserDetailActivity::class.java)
                intent.putExtra("user", userList?.get(adapterPosition))
                context.startActivity(intent)
            }
        }
    }
}
