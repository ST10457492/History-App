package com.example.st10457492

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val historicalFigures = listOf(
        "Albert Einstein" to 76,
        "Leonardo da Vinci" to 67,
        "William Shakespeare" to 52,
        "Cleopatra" to 39,
        "Martin Luther King Jr." to 39,
        "Nelson Mandela" to 95,
        "Michael Jackson" to 50
    )

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageInput = findViewById<EditText>(R.id.ageInput)
        val button1 = findViewById<Button>(R.id.button1)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val clearText = findViewById<Button>(R.id.clearText)

            clearText.setOnClickListener {}
            button1.setOnClickListener {
            val userAge = ageInput.text.toString().toIntOrNull()
            if (userAge != null) {
                val matchedFigures = findMatchedFigures(userAge)
                if (matchedFigures.isNotEmpty()) {
                    resultTextView.text = "THE HISTORY APP says The following Historical Figures passed away at around $userAge:\n\n"
                    for ((name, age) in matchedFigures) {
                        resultTextView.append("$name at age $age\n")
                    }
                } else {
                    resultTextView.text = "No historical figures passed away at the entered age."
                }
            } else {
                resultTextView.text = "Please enter a valid age."
            }
        }
    }

    private fun findMatchedFigures(userAge: Int): List<Pair<String, Int>> {
        val matchedFigures = mutableListOf<Pair<String, Int>>()
        for ((name, age) in historicalFigures) {
            if (userAge in (age - 5)..(age + 5)) {
                matchedFigures.add(name to age)
            }
        }
        return matchedFigures
    }
}

