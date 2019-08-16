package com.example.top_github.di

class Injector private constructor() {

    val userComponent: UserComponent = DaggerUserComponent.builder().build()

    companion object {
        val instance = Injector()
    }
}
