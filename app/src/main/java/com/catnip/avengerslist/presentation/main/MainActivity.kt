package com.catnip.avengerslist.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.catnip.avengerslist.R
import com.catnip.avengerslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}