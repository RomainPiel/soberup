package com.romainpiel.soberup.dagger

import android.app.Activity
import dagger.Component

@PerActivity
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun provideActivity() : Activity
}