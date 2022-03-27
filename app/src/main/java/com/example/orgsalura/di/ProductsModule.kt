package com.example.orgsalura.di

import com.example.orgsalura.feature_products.data.repository.ProductsRepositoryImpl
import com.example.orgsalura.feature_products.domain.repository.ProductsRepository
import com.example.orgsalura.feature_products.domain.useCase.AddProductUseCase
import com.example.orgsalura.feature_products.domain.useCase.GetProductByIdUseCase
import com.example.orgsalura.feature_products.domain.useCase.GetProductsUseCase
import com.example.orgsalura.feature_products.domain.useCase.ProductsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsModule {

    @Singleton
    @Provides
    fun provideProductsRepository(): ProductsRepository =
        ProductsRepositoryImpl(products = ArrayList())

    @Singleton
    @Provides
    fun provideProductsUseCases(repository: ProductsRepository): ProductsUseCases =
        ProductsUseCases(
            addProduct = AddProductUseCase(repository),
            getProducts = GetProductsUseCase(repository),
            getProductById = GetProductByIdUseCase(repository)
        )
}