package ru.avtospas.feature.login.presentation

import androidx.compose.runtime.Immutable

@Immutable
internal data class SignUpUiState(
    val phoneNumber: String = "",
    val isContinueToCodeAvailable: Boolean = false,
    val otpCode: String = "",
    val isContinueToPersonalInfoAvailable: Boolean = false,
    val isContinueToMainAvailable: Boolean = false,
) {
    companion object {
        val Empty = SignUpUiState()
    }
}

@Immutable
internal sealed class SignUpUiEvent {
    data object OnContinueToCodeScreen : SignUpUiEvent()
    data object OnContinueToPersonalInfo : SignUpUiEvent()

    data object OnPhoneNumberCheck : SignUpUiEvent()
    data object OnPhoneCodeCheck : SignUpUiEvent()
}

@Immutable
internal sealed class SignUpUiEffect {
    data object ContinueToCodeScreen : SignUpUiEffect()
    data object ContinueToPersonalInfo : SignUpUiEffect()
}
