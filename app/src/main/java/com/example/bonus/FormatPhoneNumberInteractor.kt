package com.example.bonus

class FormatPhoneNumberInteractor {

    interface Callback {
        fun onSuccess(formattedNumber: String)
        fun onError(error: String)
    }

    fun execute(rawNumber: String, callback: Callback) {
        if (isValidNumber(rawNumber)) {
            val formattedNumber = formatNumber(rawNumber)
            callback.onSuccess(formattedNumber)
        } else {
            callback.onError("Неверный формат номера")
        }
    }

    private fun isValidNumber(number: String): Boolean {
        return number.matches(Regex("^[1-9][0-9]{9,14}$"))
    }

    private fun formatNumber(number: String): String {
        return "+7 (${number.substring(0, 3)}) ${number.substring(3, 6)} ${number.substring(6, 8)} ${number.substring(8)}"
    }
}
