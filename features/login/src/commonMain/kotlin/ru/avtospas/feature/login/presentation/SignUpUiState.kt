package ru.avtospas.feature.login.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class SignUpUiState(
    val phoneNumber: String = "",
    val formattedPhoneNumber: String = "",
    val isContinueToCodeAvailable: Boolean = false,
    val otpCode: String = "",
    val name: String = "",
    val surname: String = "",
    val isContinueToPersonalInfoAvailable: Boolean = false,
    val isContinueToMainAvailable: Boolean = false,
) {
    companion object {
        val Empty = SignUpUiState()
    }
}

@Immutable
sealed class SignUpUiEvent {
    data object OnNavigateToStartScreen : SignUpUiEvent()
    data object OnNavigateToPhoneScreen : SignUpUiEvent()
    data object OnNavigateToMainScreen : SignUpUiEvent()
    data object OnVerifyPhoneNumber : SignUpUiEvent()
    data object OnVerifyOtpCode : SignUpUiEvent()
    data object OnSurnameAndNameChanged : SignUpUiEvent()

    data class OnPhoneNumberChange(val newValue: String) : SignUpUiEvent()
    data class OnOtpCodeChange(val newValue: String) : SignUpUiEvent()
    data class OnNameChange(val newValue: String) : SignUpUiEvent()
    data class OnSurnameChange(val newValue: String) : SignUpUiEvent()
}

@Immutable
sealed class SignUpUiEffect {
    data object NavigateToStartScreen : SignUpUiEffect()
    data object NavigateToPhoneScreen : SignUpUiEffect()
    data object NavigateToCodeScreen : SignUpUiEffect()
    data object NavigateToPersonalInfoScreen : SignUpUiEffect()
    data object NavigateToMainScreen : SignUpUiEffect()
}
