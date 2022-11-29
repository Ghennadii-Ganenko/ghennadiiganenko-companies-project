package com.ghennadiiganenko.android.companies.app

import android.app.Application
import com.ghennadiiganenko.android.companies.di.appModule
import com.ghennadiiganenko.android.companies.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }

    }
}