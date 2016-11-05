package com.romainpiel.soberup.dagger

import com.google.firebase.database.DatabaseReference
import com.romainpiel.soberup.repository.DrinkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf(DatabaseModule::class))
class RepositoryModule {
    @Provides
    @Singleton
    fun provideDrinkRepository(drinksDatabaseReference: DatabaseReference) = DrinkRepository(drinksDatabaseReference)
}