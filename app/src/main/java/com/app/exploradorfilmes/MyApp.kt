package com.app.exploradorfilmes

import android.app.Application
import com.app.exploradorfilmes.di.apiModule
import com.app.exploradorfilmes.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                retrofitModule,
                apiModule
            )
        }
    }
}