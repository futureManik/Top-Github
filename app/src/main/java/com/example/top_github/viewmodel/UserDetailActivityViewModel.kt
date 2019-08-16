package com.example.top_github.viewmodel

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.top_github.models.User
import com.example.top_github.models.UserDetailRepository

class UserDetailActivityViewModel : ViewModel() {
    private val userDetailRepository = UserDetailRepository()

    fun getUserDetails(activity: Activity): LiveData<User> {
        return userDetailRepository.getUserMutableLiveData(activity)
    }
}
