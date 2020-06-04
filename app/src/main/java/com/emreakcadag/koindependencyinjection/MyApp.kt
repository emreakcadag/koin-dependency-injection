package com.emreakcadag.koindependencyinjection

import android.app.Application
import com.emreakcadag.koindependencyinjection.di.appModule
import com.emreakcadag.koindependencyinjection.di.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    private val defaultCurrentActivityListener: DefaultCurrentActivityListener by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(listOf(networkModule, appModule))
        }

        registerActivityLifecycleCallbacks(defaultCurrentActivityListener)
    }
}