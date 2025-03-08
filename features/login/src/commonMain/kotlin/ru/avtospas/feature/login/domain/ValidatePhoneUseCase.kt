package ru.avtospas.feature.login.domain

class ValidatePhoneUseCase {
    operator fun invoke(phoneNumber: String): Boolean {
        // TODO: implement correct check
        return phoneNumber.length == 10
    }
}