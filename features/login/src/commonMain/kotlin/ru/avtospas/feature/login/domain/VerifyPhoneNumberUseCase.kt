package ru.avtospas.feature.login.domain

import kotlinx.coroutines.delay

class VerifyPhoneNumberUseCase {
    // Тут у нас будет вызов к api для верификации номера
    suspend operator fun invoke(phoneNumber: String): Boolean {
        delay(1000)
        return true
    }
}