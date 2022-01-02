package com.example.orgsalura.feature_main.presentation.util.extensions

import java.text.NumberFormat
import java.util.*

fun Double.brazilianCurrencyFormat(): String =
    NumberFormat.getCurrencyInstance(Locale("pt", "br")).format(this)