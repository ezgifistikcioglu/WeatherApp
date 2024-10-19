package com.ezgieren.weatherapp.di

import com.ezgieren.weatherapp.data.repository.WeatherRepositoryImpl
import com.ezgieren.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  // Uygulama genelinde Singleton olarak kullanılacak
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository  // WeatherRepository interface'ini WeatherRepositoryImpl sağlar
}