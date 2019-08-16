package com.example.top_github.di

import android.app.Activity
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class ActivityModule(internal var activity: Activity) {

    @Singleton
    @Provides
    fun providesActivity(): Activity {
        return activity
    }
}
