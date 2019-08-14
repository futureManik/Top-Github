package com.example.top_github.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top_github.R
import com.example.top_github.cache.ImagesCache
import com.example.top_github.models.User
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        if (intent.hasExtra("user")) {
            user = intent.getSerializableExtra("user") as User?
        }

        name_tv.text = user?.name
        username_tv.text = user?.username
        url_tv.text = user?.url
        repo_url_tv.text = user?.repo?.url
        description_tv.text = user?.repo?.description

        ImagesCache.getInstance().setImage(this, user?.avatar, avatar_iv)

    }
}
