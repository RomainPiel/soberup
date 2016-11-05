package com.romainpiel.soberup.ui.main

import com.romainpiel.soberup.dagger.ActivityComponent
import com.romainpiel.soberup.dagger.ActivityModule
import com.romainpiel.soberup.dagger.ApplicationComponent
import com.romainpiel.soberup.dagger.PerActivity
import dagger.Component

@PerActivity
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class))
interface MainActivityComponent : ActivityComponent {
    fun inject(activity: MainActivity)
}
