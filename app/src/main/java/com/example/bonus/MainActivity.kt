package com.example.bonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), PhoneNumberContract.View {

    private lateinit var presenter: PhoneNumberPresenter
    private lateinit var phoneNumberInput: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phoneNumberInput = findViewById(R.id.phoneNumberInput)
        resultText = findViewById(R.id.resultText)
        val formatButton: Button = findViewById(R.id.formatButton)

        presenter = PhoneNumberPresenter(this)

        formatButton.setOnClickListener {
            presenter.formatPhoneNumber(phoneNumberInput.text.toString())
        }
    }

    override fun showFormattedNumber(formattedNumber: String) {
        resultText.text = formattedNumber
    }

    override fun showError(error: String) {
        resultText.text = error
    }
}