package com.example.githubrepoapp

import android.app.Application
import android.content.Context

class RxApp :Application() {
    companion object {
        lateinit var  INSTANCE:RxApp
    }


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}