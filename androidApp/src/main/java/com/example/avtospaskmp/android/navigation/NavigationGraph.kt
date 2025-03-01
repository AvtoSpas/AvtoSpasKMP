package com.example.avtospaskmp.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.avtospaskmp.android.screens.CodeScreen
import com.example.avtospaskmp.android.screens.FirstRegScreen
import com.example.avtospaskmp.android.screens.PhoneScreen
import com.example.avtospaskmp.android.screens.StartScreen
import com.example.avtospaskmp.android.screens.theme.ColorScheme

@Composable
fun NavigationGraph(
    navController: NavHostController,
    colorScheme: ColorScheme
) {
    NavHost(
        navController = navController,
        startDestination = Screen.StartScreen
    ) {
        composable<Screen.StartScreen> {
            StartScreen(
                colorScheme,
                onNavigateToPhoneScreen = {
                    navController.navigate(Screen.PhoneScreen)
                }
            )
        }

        // TODO: remove excessive screens
        // To be fair, there shouldn't be any navigation, IMO.
        // Because that would require either having different viewmodel
        // for each of the screens or reusing the same one which we
        // would need to receive from some di scope
        composable<Screen.PhoneScreen> {
            PhoneScreen(
                colorScheme = colorScheme,
                onNavigateToCodeScreen = { wtf ->
                    navController.navigate(Screen.CodeScreen(wtf))
                },
                onNavigateToStartScreen = {
                    navController.navigate(Screen.StartScreen) {
                        popUpTo<Screen.StartScreen> { inclusive = false }
                    }
                }
            )
        }

        composable<Screen.CodeScreen> { backStackEntry ->
            val code = backStackEntry.toRoute<Screen.CodeScreen>()
            CodeScreen(
                colorScheme,
                phoneNumber = code.phoneNumberFrom,
                onNavigateToPhoneScreen = {
                    navController.navigate(Screen.PhoneScreen) {
                        popUpTo<Screen.CodeScreen> { inclusive = false }
                    }
                },
                onNavigateToFirstRegScreen = {
                    navController.navigate(Screen.FirstRegScreen)
                },
            )
        }

        composable<Screen.FirstRegScreen> {
            FirstRegScreen(
                colorScheme,
                // What's the point in navigating back to code screen?
                // We need to navigate back to phone number screen with
                // saved state (which not possible with current implementation)
                onNavigateToCodeScreen = {
                    navController.navigate(Screen.PhoneScreen) {
                        popUpTo<Screen.PhoneScreen> { inclusive = false }
                    }
                }
            )
        }
    }
}