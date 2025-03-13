package ru.avtospas.feature.main.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class MainUiState(
    val address : String = ""
){
    companion object {
        val Empty = MainUiState()
    }
}

