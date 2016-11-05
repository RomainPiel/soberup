package com.romainpiel.soberup.dagger

import com.romainpiel.soberup.repository.DrinkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun drinkRepository() = DrinkRepository()
}