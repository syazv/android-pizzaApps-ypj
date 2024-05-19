package com.syazv.pizzaapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.syazv.pizzaapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.placeOrderBtn.setOnClickListener {
            var pizzaSizaPrice = 0.0
            var toppingsTotal = 0.0

            when {
                binding.smallRadioBtn.isChecked -> pizzaSizaPrice = 5.0
                binding.mediumRadioBtn.isChecked -> pizzaSizaPrice = 7.0
                binding.largeRadioBtn.isChecked -> pizzaSizaPrice = 9.0
            }

            if (binding.onionBox.isChecked){
                toppingsTotal += 1
            }
            if (binding.olivesBox.isChecked){
                toppingsTotal += 2
            }
            if (binding.tomatoesBox.isChecked){
                toppingsTotal += 3
            }

            binding.totalTextView.text = "Total Order Price = RM ${pizzaSizaPrice + toppingsTotal}"
        }

    }
}