package com.example.top_github.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.top_github.R
import com.example.top_github.adapters.UserAdapter
import com.example.top_github.models.User
import com.example.top_github.service.RetrofitInstance
import com.example.top_github.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var gitUsers: List<User>? = null
    private var mainActivityViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        getGitUsers()
    }

    private fun getGitUsers() {

        val observe = mainActivityViewModel?.allUsers?.observe(this, Observer {
            gitUsers = it
            showListOfGitUser()
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
