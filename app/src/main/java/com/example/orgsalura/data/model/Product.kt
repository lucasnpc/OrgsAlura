package com.example.orgsalura.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String = "",
    val description: String = "",
    val price: Double
) : Parcelable
