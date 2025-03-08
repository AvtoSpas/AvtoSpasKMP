package ru.avtospas.feature.login.domain

class ValidateOtpCodeUseCase {
    operator fun invoke(otpCode: String): Boolean {
        return otpCode.length == 6
    }
}