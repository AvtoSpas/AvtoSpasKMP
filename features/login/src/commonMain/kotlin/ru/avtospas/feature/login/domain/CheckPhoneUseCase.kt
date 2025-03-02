package ru.avtospas.feature.login.domain

class CheckPhoneUseCase {
    operator fun invoke(phoneNumber: String): Boolean {
        // TODO: implement correct check
        return phoneNumber.length == 11
    }
}