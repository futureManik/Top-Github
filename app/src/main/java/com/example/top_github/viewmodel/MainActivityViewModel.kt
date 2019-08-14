package com.example.top_github.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.top_github.models.User
import com.example.top_github.models.UserRepository

class MainActivityViewModel: ViewModel() {

    private val userRepository: UserRepository = UserRepository()

     val allUsers: LiveData<List<User>>
        get() = userRepository.getMutableLiveData()

}
