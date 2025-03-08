package ru.avtospas.feature.login.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onNavigateToStartScreen: () -> Unit,
    viewModel: SignUpViewModel = koinViewModel(),
) {
    val uiState by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 3 })

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is SignUpUiEffect.NavigateToStartScreen -> {
                    onNavigateToStartScreen()
                }

                is SignUpUiEffect.NavigateToPhoneScreen -> {
                    pagerState.animateScrollToPage(0)
                }

                is SignUpUiEffect.NavigateToCodeScreen -> {
                    pagerState.animateScrollToPage(1)
                }

                is SignUpUiEffect.NavigateToPersonalInfoScreen -> {
                    pagerState.animateScrollToPage(2)
                }
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        userScrollEnabled = false,
        modifier = modifier.fillMaxSize()
    ) { page ->
        when (page) {
            0 -> {
                PhoneScreen(
                    modifier = Modifier.fillMaxSize(),
                    phoneNumber = uiState.phoneNumber,
                    isContinueButtonEnabled = uiState.isContinueToCodeAvailable,
                    onPhoneNumberChange = { phoneNumber ->
                        viewModel.sendEvent(
                            SignUpUiEvent.OnPhoneNumberChange(
                                phoneNumber
                            )
                        )
                    },
                    onContinueClick = { viewModel.sendEvent(SignUpUiEvent.OnVerifyPhoneNumber) },
                    onBack = { viewModel.sendEvent(SignUpUiEvent.OnNavigateToStartScreen) }
                )
            }

            1 -> {
                CodeScreen(
                    modifier = Modifier.fillMaxSize(),
                    phoneNumber = uiState.formattedPhoneNumber,
                    otpCode = uiState.otpCode,
                    isContinueEnabled = uiState.isContinueToPersonalInfoAvailable,
                    onCodeChange = { otpCode ->
                        viewModel.sendEvent(
                            SignUpUiEvent.OnOtpCodeChange(
                                otpCode
                            )
                        )
                    },
                    onContinueClick = { viewModel.sendEvent(SignUpUiEvent.OnNavigateToPhoneScreen) },
                    onBack = { viewModel.sendEvent(SignUpUiEvent.OnVerifyOtpCode) }
                )
            }

            2 -> {
                FirstRegScreen(
                    modifier = Modifier.fillMaxSize(),
                    name = uiState.name,
                    surname = uiState.surname,
                    onNameChange = { name -> viewModel.sendEvent(SignUpUiEvent.OnNameChange(name)) },
                    onSurnameChange = { surname ->
                        viewModel.sendEvent(
                            SignUpUiEvent.OnSurnameChange(
                                surname
                            )
                        )
                    },
                    isContinueAvailable = false,
                    onBack = { viewModel.sendEvent(SignUpUiEvent.OnNavigateToPhoneScreen) }
                )
            }
        }
    }
}