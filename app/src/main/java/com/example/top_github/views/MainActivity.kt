package com.example.top_github.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.top_github.R
import com.example.top_github.adapters.UserAdapter
import com.example.top_github.models.User
import com.example.top_github.service.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var gitUsers: List<User>? = null
    private val LANG = "java"
    private val SINCE = "weekly"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getGitUsers()
    }

    private fun getGitUsers() {
        val userDataService = RetrofitInstance.service
        val getGitUsers = userDataService.getGitUser(LANG, SINCE)

        getGitUsers.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>?) {

                gitUsers = response?.body()
                showListOfGitUser()

            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })
    }

    private fun showListOfGitUser() {
        val userAdapter = UserAdapter(this, gitUsers)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = userAdapter
        userAdapter.notifyDataSetChanged()
    }
}
