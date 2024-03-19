package com.example.bonus.PresentationLayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bonus.DomainLayer.FormatPhoneNumberUseCase
import com.example.bonus.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PhoneNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = PhoneNumberViewModelFactory(FormatPhoneNumberUseCase())
        viewModel = ViewModelProvider(this, factory)[PhoneNumberViewModel::class.java]
        val phoneNumberInput = findViewById<EditText>(R.id.phoneNumberInput)
        val formatButton = findViewById<Button>(R.id.formatButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        formatButton.setOnClickListener {
            viewModel.formatPhoneNumber(phoneNumberInput.text.toString())
        }

        viewModel.formattedNumber.observe(this, Observer { formattedNumber ->
            resultText.text = formattedNumber
        })

        viewModel.error.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
    }
}
