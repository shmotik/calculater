package com.example.calculated

//import AboutActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
    private var exit = 0.0

    enum class Operation( val sign: String, val calculation: (Double, Double) -> Double){
        Plus("+", {a, b -> a + b}),
        Minus("-", {a, b -> a - b}),
        Multiplay("*",{a, b -> a * b}),
        Division("/", {a, b -> a / b})
    }

    fun onClick(operation: Operation){
        input1 = binding.operand1.getText().toString().toDouble()
        input2 = binding.operand2.getText().toString().toDouble()
        binding.vizualSign.text = operation.sign
        exit = operation.calculation(input1,input2)
        binding.textAnswer.text = exit.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.plusButton.setOnClickListener{view ->
            onClick(Operation.Plus)
        }


        binding.minusButton.setOnClickListener{view ->
            onClick(Operation.Minus)
        }


        binding.multiplyButton.setOnClickListener{view ->
            onClick(Operation.Multiplay)
        }


        binding.divisionButton.setOnClickListener{view ->
            onClick(Operation.Division)
        }

        //binding.button.setOnClickListener {
           // val intent = Intent(this@MainActivity, AboutActivity::class.java)
          //  startActivity(intent)
        //}
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run{
            putString("KEY", binding.textAnswer.text.toString())
        }

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        binding.textAnswer.text = savedInstanceState.getString("KEY")
    }

}