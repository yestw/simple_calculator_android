package com.example.simple_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.simple_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener(this)
        binding.buttonSub.setOnClickListener(this)
        binding.buttonMul.setOnClickListener(this)
        binding.buttonDiv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        try {
            val number1 = binding.editTextNumber1.text.toString().toDouble();
            val number2 = binding.editTextNumber2.text.toString().toDouble();
            var result = 0.0

            if(v?.id==R.id.buttonAdd)
                result=(number1 + number2)
            else if(v?.id==R.id.buttonSub)
                result=(number1 - number2)
            else if(v?.id==R.id.buttonMul)
                result=(number1 * number2)
            else if(v?.id==R.id.buttonDiv && number2 != 0.0)
                result=(number1 / number2)

            if(v?.id==R.id.buttonDiv)
                binding.textViewResult.text=result.toString()
            else binding.textViewResult.text=result.toInt().toString()
        } catch (e:NumberFormatException) {
            return
        }
    }
}