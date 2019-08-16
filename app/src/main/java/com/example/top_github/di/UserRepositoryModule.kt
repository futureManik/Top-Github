package com.example.top_github.di

import com.example.top_github.models.UserRepository
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class UserRepositoryModule {
    @Singleton
    @Provides
    fun providesUserRepository(): UserRepository {
        return UserRepository()
    }
}
