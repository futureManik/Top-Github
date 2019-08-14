package com.example.top_github.service

import com.example.top_github.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserDataService {

    @GET("/developers")
    fun getGitUser(
        @Query("language") language: String,
        @Query("since") since: String
    ): Call<List<User>>

}
