package com.app.exploradorfilmes

import android.app.Application
import com.app.exploradorfilmes.di.apiModule
import com.app.exploradorfilmes.di.retrofitModule
import com.app.exploradorfilmes.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                retrofitModule,
                apiModule,
                viewModelModule
            )
        }
    }
}