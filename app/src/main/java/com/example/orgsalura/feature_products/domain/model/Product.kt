package com.example.orgsalura.feature_products.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = ""
) : Parcelable

class InvalidProductException(message: String) : Exception(message)
