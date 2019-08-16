package com.example.top_github.models

import android.app.Activity
import androidx.lifecycle.MutableLiveData

class UserDetailRepository {

    fun getUserMutableLiveData(activity: Activity): MutableLiveData<User> {

        var mutableLiveData: MutableLiveData<User> = MutableLiveData()

        if (activity.intent.hasExtra("user"))
            mutableLiveData.value = activity.intent.getSerializableExtra("user") as User

        return mutableLiveData
    }
}