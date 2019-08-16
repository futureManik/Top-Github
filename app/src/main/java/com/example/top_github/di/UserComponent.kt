package com.example.top_github.di

import com.example.top_github.views.MainActivity
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, UserRepositoryModule::class])
interface UserComponent {

    fun inject(mainActivity: MainActivity)
}
