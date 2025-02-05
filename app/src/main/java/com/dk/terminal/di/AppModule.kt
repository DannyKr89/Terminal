package com.dk.terminal.di

import com.dk.terminal.data.TerminalRepositoryImpl
import com.dk.terminal.data.retofit.ApiService
import com.dk.terminal.domain.LoadBarsUseCase
import com.dk.terminal.domain.TerminalRepository
import com.dk.terminal.utils.Consts.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): TerminalRepository {
        return TerminalRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideLoadBarsUseCase(repositoryImpl: TerminalRepository): LoadBarsUseCase {
        return LoadBarsUseCase(repositoryImpl)
    }

}