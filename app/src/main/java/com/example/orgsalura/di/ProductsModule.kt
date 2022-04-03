package com.example.orgsalura.di

import android.app.Application
import androidx.room.Room
import com.example.orgsalura.feature_products.data.repository.ProductsRepositoryImpl
import com.example.orgsalura.feature_products.data.repository.local.AppDatabase
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

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideProductsRepository(db: AppDatabase): ProductsRepository =
        ProductsRepositoryImpl(db = db.productDao)

    @Singleton
    @Provides
    fun provideProductsUseCases(repository: ProductsRepository): ProductsUseCases =
        ProductsUseCases(
            addProduct = AddProductUseCase(repository),
            getProducts = GetProductsUseCase(repository),
            getProductById = GetProductByIdUseCase(repository)
        )
}