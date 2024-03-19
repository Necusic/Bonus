package com.example.bonus.PresentationLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bonus.DomainLayer.FormatPhoneNumberUseCase

class PhoneNumberViewModelFactory(private val formatPhoneNumberUseCase: FormatPhoneNumberUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhoneNumberViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PhoneNumberViewModel(formatPhoneNumberUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}