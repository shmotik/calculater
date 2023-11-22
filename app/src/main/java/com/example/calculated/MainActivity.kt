package com.example.calculated

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var input1 = 0.0
    private var input2 = 0.0
    private var output = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSolve: Button = findViewById(R.id.button_solve)
        val vizualSign: TextView = findViewById(R.id.vizual_sign)
        val operandFirst: EditText = findViewById(R.id.operand_1)
        val operandSecond: EditText = findViewById(R.id.operand_2)
        val textAnswer: TextView = findViewById(R.id.text_answer)
        val choiceGroup: RadioGroup = findViewById(R.id.radioGroup)
        val textSystem: TextView = findViewById(R.id.text_system)

        buttonSolve.setOnClickListener { view ->
            val checkedRadioButtonId = choiceGroup.checkedRadioButtonId

            textSystem.text = if (checkedRadioButtonId == -1) "Не выбрана операция" else ""

            input1 = operandFirst.getText().toString().toDouble()
            input2 = operandSecond.getText().toString().toDouble()

            when (checkedRadioButtonId) {
                R.id.button_plus -> {
                    input1 = input1 + input2
                    vizualSign.text = "+"
                }

                R.id.button_minus -> {
                    input1 = input1 - input2
                    vizualSign.text = "-"
                }

                R.id.button_division -> {
                    input1 = input1 / input2
                    vizualSign.text = "/"
                }

                R.id.button_multiplication -> {
                    input1 = input1 * input2
                    vizualSign.text = "*"
                }
            }

            textAnswer.text = input1.toString()


        }
    }
}