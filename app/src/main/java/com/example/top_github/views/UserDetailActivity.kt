package com.example.top_github.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.top_github.R
import com.example.top_github.cache.ImagesCache
import com.example.top_github.models.User
import com.example.top_github.viewmodel.UserDetailActivityViewModel
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)


        val userDetailActivityViewModel= UserDetailActivityViewModel()

        userDetailActivityViewModel.getUserDetails(this).observe(this, Observer {user->
            name_tv.text = user?.name
            username_tv.text = user?.username
            url_tv.text = user?.url
            repo_url_tv.text = user?.repo?.url
            description_tv.text = user?.repo?.description
            ImagesCache.getInstance().setImage(
                this,
                user?.avatar,
                avatar_iv
            )

        })
    }
}
