package com.example.top_github.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://github-trending-api.now.sh/"

    val service: UserDataService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(UserDataService::class.java)
        }
}

