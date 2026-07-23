package subrota.shuvro.newsapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import subrota.shuvro.newsapp.data.manager.LocalUserManagerImpl
import subrota.shuvro.newsapp.domain.manager.LocalUserManager
import subrota.shuvro.newsapp.domain.usecases.AppEntryUseCases
import subrota.shuvro.newsapp.domain.usecases.ReadAppEntry
import subrota.shuvro.newsapp.domain.usecases.SaveAppEntry
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}
