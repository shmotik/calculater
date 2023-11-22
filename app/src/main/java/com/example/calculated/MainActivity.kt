package com.example.calculated

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import com.example.calculated.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var input1 = 0.0
    private var input2 = 0.0
    private var operation = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plusButton.setOnClickListener{view ->

            binding.vizualSign.text = "+"

            operation = 1
        }


        binding.minusButton.setOnClickListener{view ->

            binding.vizualSign.text = "-"

            operation = 2
        }


        binding.multiplyButton.setOnClickListener{view ->

            binding.vizualSign.text = "*"

            operation = 3
        }


        binding.divisionButton.setOnClickListener{view ->

            binding.vizualSign.text = "/"

            operation = 4
        }

        binding.buttonSolve.setOnClickListener { view ->

            input1 = binding.operand1.getText().toString().toDouble()
            input2 = binding.operand2.getText().toString().toDouble()

            when (operation) {
                0 -> {
                    input1 = 0.0
                }

                1 -> {
                    input1 = input1 + input2
                }

                2 -> {
                    input1 = input1 - input2
                }

                3 -> {
                    input1 = input1 * input2
                }

                4 -> {
                    input1 = input1 / input2
                }
            }

            binding.textAnswer.text = input1.toString()


        }
    }
}