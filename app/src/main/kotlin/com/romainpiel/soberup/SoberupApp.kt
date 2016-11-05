package com.romainpiel.soberup

import android.app.Activity
import android.app.Application
import com.romainpiel.soberup.dagger.ApplicationComponent
import com.romainpiel.soberup.dagger.ApplicationModule
import com.romainpiel.soberup.dagger.DaggerApplicationComponent

class SoberupApp : Application() {

    lateinit var component: ApplicationComponent
        get

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    val Activity.applicationComponent: ApplicationComponent
        get() = (application as SoberupApp).component
}