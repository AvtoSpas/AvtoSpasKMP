package ru.avtospas.feature.login.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpViewModel : ViewModel() {
    private val _state = MutableStateFlow(SignUpUiState.Empty)
}