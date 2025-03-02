package ru.avtospas.feature.login.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.avtospas.feature.login.presentation.SignInViewModel
import ru.avtospas.feature.login.presentation.SignUpViewModel

val loginViewModelModule = module {
    viewModel { SignUpViewModel() }
    viewModel { SignInViewModel() }
}