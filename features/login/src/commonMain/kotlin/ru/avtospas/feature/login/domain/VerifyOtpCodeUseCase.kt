package ru.avtospas.feature.login.domain

import kotlinx.coroutines.delay

class VerifyOtpCodeUseCase {
    // Тут у нас будет вызов к api для верификации кода
    suspend operator fun invoke(otpCode: String): Boolean {
        delay(2000)
        return otpCode == "000000"
    }
}