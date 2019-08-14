package com.example.top_github.models

import androidx.lifecycle.MutableLiveData
import com.example.top_github.service.RetrofitInstance
import com.example.top_github.service.UserDataService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    private val LANG = "java"
    private val SINCE = "weekly"

    private val mutableLiveData = MutableLiveData<List<User>>()

    fun getMutableLiveData(): MutableLiveData<List<User>> {

        val userDataService = RetrofitInstance.service
        val getGitUsers = userDataService.getGitUser(LANG, SINCE)

        getGitUsers.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>?) {

                mutableLiveData.value=response?.body()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })

        return mutableLiveData
    }
}
