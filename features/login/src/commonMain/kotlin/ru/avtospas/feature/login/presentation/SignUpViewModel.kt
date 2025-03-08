package ru.avtospas.feature.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.avtospas.feature.login.domain.ValidateOtpCodeUseCase
import ru.avtospas.feature.login.domain.ValidatePhoneUseCase
import ru.avtospas.feature.login.domain.VerifyOtpCodeUseCase
import ru.avtospas.feature.login.domain.VerifyPhoneNumberUseCase

class SignUpViewModel(
    private val validatePhoneUseCase: ValidatePhoneUseCase,
    private val validateOtpCodeUseCase: ValidateOtpCodeUseCase,
    private val verifyOtpCodeUseCase: VerifyOtpCodeUseCase,
    private val verifyPhoneNumberUseCase: VerifyPhoneNumberUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(SignUpUiState.Empty)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<SignUpUiEffect>()
    val effect = _effect.asSharedFlow()

    fun sendEvent(event: SignUpUiEvent) {
        when (event) {
            is SignUpUiEvent.OnPhoneNumberChange -> {
                handlePhoneNumberChange(event.newValue)
            }

            is SignUpUiEvent.OnOtpCodeChange -> {
                handleCodeChange(event.newValue)
            }

            is SignUpUiEvent.OnNameChange -> {
                handleNameChange(event.newValue)
            }

            is SignUpUiEvent.OnSurnameChange -> {
                handleSurnameChange(event.newValue)
            }

            is SignUpUiEvent.OnNavigateToStartScreen -> {
                viewModelScope.launch { _effect.emit(SignUpUiEffect.NavigateToStartScreen) }
            }

            is SignUpUiEvent.OnNavigateToPhoneScreen -> {
                viewModelScope.launch { _effect.emit(SignUpUiEffect.NavigateToPhoneScreen) }
            }

            is SignUpUiEvent.OnVerifyPhoneNumber -> {
                viewModelScope.launch { verifyPhoneNumber() }
            }

            is SignUpUiEvent.OnVerifyOtpCode -> {
                viewModelScope.launch { verifyOtpCode() }
            }


        }
    }

    private suspend fun verifyPhoneNumber() {
        _state.update { it.copy(isContinueToCodeAvailable = false) }

        val isVerificationSuccess = verifyPhoneNumberUseCase(_state.value.phoneNumber)

        _state.update { it.copy(isContinueToCodeAvailable = true) }

        if (isVerificationSuccess) {
            _effect.emit(SignUpUiEffect.NavigateToCodeScreen)
        }
    }

    private suspend fun verifyOtpCode() {
        _state.update { it.copy(isContinueToPersonalInfoAvailable = false) }

        val isVerificationSuccess = verifyOtpCodeUseCase(_state.value.otpCode)

        _state.update { it.copy(isContinueToPersonalInfoAvailable = true) }

        if (isVerificationSuccess) {
            _effect.emit(SignUpUiEffect.NavigateToPersonalInfoScreen)
        }
    }

    private fun handlePhoneNumberChange(newPhoneNumber: String) {
        if (newPhoneNumber.length > 10) {
            return
        }

        val isContinueAvailable = validatePhoneUseCase(newPhoneNumber)
        _state.update {
            it.copy(
                phoneNumber = newPhoneNumber,
                isContinueToCodeAvailable = isContinueAvailable,
                formattedPhoneNumber = if (isContinueAvailable)
                    formatPhoneNumber(newPhoneNumber)
                else it.formattedPhoneNumber
            )
        }
    }

    private fun handleCodeChange(newCode: String) {
        if (newCode.length > 6) {
            return
        }

        val isContinueAvailable = validateOtpCodeUseCase(newCode)
        _state.update {
            it.copy(
                otpCode = newCode,
                isContinueToPersonalInfoAvailable = isContinueAvailable
            )
        }
    }

    private fun handleNameChange(newName: String) {
        _state.update { it.copy(name = newName) }
    }

    private fun handleSurnameChange(newSurname: String) {
        _state.update { it.copy(surname = newSurname) }
    }

    private fun formatPhoneNumber(digits: String): String {
        if (digits.isEmpty()) return "+7 "
        val builder = StringBuilder("+7 (")
        for (i in digits.indices) {
            when (i) {
                3 -> builder.append(") ")
                6 -> builder.append("-")
                8 -> builder.append("-")
            }
            builder.append(digits[i])
        }
        return builder.toString()
    }
}