package com.example.top_github.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.top_github.models.UserRepository
import com.example.top_github.viewmodel.MainActivityViewModel

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainActivityViewModelFactory @Inject
constructor(private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        return MainActivityViewModel(userRepository) as T
    }
}
