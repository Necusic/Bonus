package com.example.bonus.DomainLayer

class FormatPhoneNumberUseCase {
    operator fun invoke(rawNumber: String): Result<String> {
        return if (isValidNumber(rawNumber)) {
            Result.success(formatNumber(rawNumber))
        } else {
            Result.failure(IllegalArgumentException("Invalid phone number format"))
        }
    }

    private fun isValidNumber(number: String): Boolean {
        return number.matches(Regex("\\d{10}"))
    }

    private fun formatNumber(number: String): String {
        return "+7 (${number.substring(0, 3)}) ${number.substring(3, 6)}-${number.substring(6, 8)}-${number.substring(8, 10)}"
    }
}
