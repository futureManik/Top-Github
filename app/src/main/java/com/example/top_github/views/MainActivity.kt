package com.example.top_github.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.top_github.R
import com.example.top_github.models.User
import com.example.top_github.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val LANG = "java"
    private val SINCE = "weekly"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userDataService = RetrofitInstance.service
        val getGitUsers = userDataService.getGitUser(LANG,SINCE)

        getGitUsers.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                val users = response.body()

                if (users != null) {
                    for (user in users) {
                        Log.i("User Name", user.name)
                    }
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })

    }
}
