package com.example.tip

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tip.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val totalPeopleTemp = binding.tieTotalPeople.text
            val percentageTemp = binding.tiePercentage.text

            if (totalTableTemp?.isEmpty() == true ||
                totalPeopleTemp?.isEmpty() == true ||
                percentageTemp?.isEmpty() == true
                ) {
                Snackbar
                    .make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = totalPeopleTemp.toString().toInt()
                val percentage: Int = percentageTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tip = totalTemp * percentage / 100
                val totalPerPerson = totalTemp + tip

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("nPeople", nPeople)
                    putExtra("percentage", percentage)
                    putExtra("totalAmount", totalPerPerson)
                }
                clean()
                startActivity(intent)
            }
        }
        binding.btnClean.setOnClickListener {
            clean()
        }
    }
    private fun clean(){
        binding.tieTotal.setText("")
        binding.tieTotalPeople.setText("")
        binding.tiePercentage.setText("")

    }
}