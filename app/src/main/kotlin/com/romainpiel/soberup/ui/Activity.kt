package com.romainpiel.soberup.ui

import android.app.Activity
import com.romainpiel.soberup.SoberupApp
import com.romainpiel.soberup.dagger.ApplicationComponent

val Activity.applicationComponent: ApplicationComponent
    get() = (application as SoberupApp).component
