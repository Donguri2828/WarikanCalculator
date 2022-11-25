package com.example.warikancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.String.join

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcButton: Button = findViewById(R.id.button)
        calcButton.setOnClickListener {
            calcWarikan()
        }
    }

    private fun calcWarikan() {
        val editTextNumber1: EditText = findViewById(R.id.editTextNumberDecimal1)
        val editTextNumber2: EditText = findViewById(R.id.editTextNumberDecimal2)
        val editTextNumber3: EditText = findViewById(R.id.editTextNumberDecimal3)

        val amountOfMoneyList: List<Int> = listOf(
            editTextNumber1.text.toString().toIntOrNull() ?: 0,
            editTextNumber2.text.toString().toIntOrNull() ?: 0,
            editTextNumber3.text.toString().toIntOrNull() ?: 0)

        var totalAmountOfMoney = 0
        for (amountOfMoney in amountOfMoneyList) {
            totalAmountOfMoney += amountOfMoney
        }

        val textViewTotal: TextView = findViewById(R.id.textViewTotal)
        textViewTotal.text = "合計: " + totalAmountOfMoney.toString()

        val amountOfMoneyAvg = totalAmountOfMoney / 3
        val textViewDiff1: TextView = findViewById(R.id.textViewDiff1)
        val textViewDiff2: TextView = findViewById(R.id.textViewDiff2)
        val textViewDiff3: TextView = findViewById(R.id.textViewDiff3)
        textViewDiff1.text = (amountOfMoneyList[0] - amountOfMoneyAvg).toString()
        textViewDiff2.text = (amountOfMoneyList[1] - amountOfMoneyAvg).toString()
        textViewDiff3.text = (amountOfMoneyList[2] - amountOfMoneyAvg).toString()
    }
}