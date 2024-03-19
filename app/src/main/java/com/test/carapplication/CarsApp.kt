package com.test.carapplication

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CarsApp : Application() {
    init {
        application = this
    }

    companion object {
        private lateinit var application: CarsApp
        fun getContext(): Context = application.applicationContext
    }
}