package com.example.tip

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tip.databinding.ActivityMainBinding
import com.example.tip.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val nPeople = intent.getIntExtra("nPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)

        binding.tvTotalTable.text = totalTable.toString()
        binding.tvTotalPeople.text = nPeople.toString()
        binding.tvPercentage.text = percentage.toString()
        binding.tvTotalAmount.text = totalAmount.toString()

        binding.btnRedo.setOnClickListener {
            finish()
        }

    }
}