package com.example.orgsalura.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.orgsalura.R

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment_main)?.findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navController?.navigate(R.id.home_fragment)
    }
}