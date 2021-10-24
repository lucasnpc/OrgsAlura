package com.example.orgsalura.di

import com.example.orgsalura.data.ProductsRepository
import com.example.orgsalura.data.model.Product
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsRepositoryModule {
    @Singleton
    @Provides
    fun provideProductsRepository() =
        ProductsRepository(products = ArrayList())
}