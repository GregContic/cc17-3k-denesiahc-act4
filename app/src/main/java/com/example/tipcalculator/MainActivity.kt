package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

	lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
		binding.calculateButton.setOnClickListener{calculateTip()}

    }

	private fun calculateTip() {
		val cost = binding.costOfService.text.toString().toDouble()
		val selectedId = binding.tipOptions.checkedRadioButtonId
		val tipPercentage = when(selectedId){
			R.id.option_ten_percent -> 0.1
			R.id.option_seven_percent -> 0.007
			else -> 0.15
		}
		var tip = cost*tipPercentage
		val roundUp = binding.roundTip.isChecked
		if (roundUp) {
			tip = ceil(tip)
		}
		binding.tipResult.text = tip.toString()
	}
}
