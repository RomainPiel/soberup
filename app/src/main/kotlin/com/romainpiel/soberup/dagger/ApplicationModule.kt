package com.romainpiel.soberup.dagger

import android.content.Context
import com.romainpiel.soberup.SoberupApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: SoberupApp) {

    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return this.application
    }
}
