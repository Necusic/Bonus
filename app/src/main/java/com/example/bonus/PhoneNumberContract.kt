package com.example.bonus

interface PhoneNumberContract {
    interface View {
        fun showFormattedNumber(formattedNumber: String)
        fun showError(error: String)
    }

    interface Presenter {
        fun formatPhoneNumber(rawNumber: String)
    }
}
