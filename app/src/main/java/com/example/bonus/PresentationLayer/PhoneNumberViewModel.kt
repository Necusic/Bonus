package com.example.bonus.PresentationLayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bonus.DomainLayer.FormatPhoneNumberUseCase

class PhoneNumberViewModel(private val formatPhoneNumberUseCase: FormatPhoneNumberUseCase) : ViewModel() {
    private val _formattedNumber = MutableLiveData<String>()
    val formattedNumber: LiveData<String> = _formattedNumber

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun formatPhoneNumber(rawNumber: String) {
        val result = formatPhoneNumberUseCase(rawNumber)
        result.onSuccess { formatted ->
            _formattedNumber.value = formatted
        }.onFailure { error ->
            _error.value = error.message
        }
    }
}