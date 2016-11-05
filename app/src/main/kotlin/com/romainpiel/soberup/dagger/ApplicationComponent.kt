package com.romainpiel.soberup.dagger

import com.romainpiel.soberup.SoberupApp
import com.romainpiel.soberup.repository.DrinkRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        RepositoryModule::class
))
interface ApplicationComponent {
    fun inject(application: SoberupApp)

    fun drinkRepository(): DrinkRepository
}