package com.example.orgsalura.feature_main.domain.useCase

import com.example.orgsalura.feature_main.domain.model.InvalidProductException
import com.example.orgsalura.feature_main.domain.model.Product
import com.example.orgsalura.feature_main.domain.repository.ProductsRepository

class AddProductUseCase(private val repository: ProductsRepository) {

    @Throws(InvalidProductException::class)
    operator fun invoke(product: Product) = product.let {
        if (product.name.isBlank())
            throw InvalidProductException("O nome do produto não pode ser vazio.")
        if (product.description.isBlank())
            throw InvalidProductException("A descrição não pode ser vazia.")

        repository.addProduct(product = product)
    }
}