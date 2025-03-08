package ru.avtospas.feature.login.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.avtospas.feature.login.domain.ValidateOtpCodeUseCase
import ru.avtospas.feature.login.domain.ValidatePhoneUseCase
import ru.avtospas.feature.login.domain.VerifyOtpCodeUseCase
import ru.avtospas.feature.login.domain.VerifyPhoneNumberUseCase
import ru.avtospas.feature.login.presentation.SignInViewModel
import ru.avtospas.feature.login.presentation.SignUpViewModel

val loginViewModelModule = module {
    factory { ValidatePhoneUseCase() }
    factory { ValidateOtpCodeUseCase() }
    factory { VerifyPhoneNumberUseCase() }
    factory { VerifyOtpCodeUseCase() }

    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)

}