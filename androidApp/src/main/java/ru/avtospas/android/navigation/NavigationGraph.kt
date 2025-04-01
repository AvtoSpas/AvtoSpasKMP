package ru.avtospas.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.avtospas.feature.edit_profile.presentation.EditProfileScreen
import ru.avtospas.feature.login.presentation.SignUpScreen
import ru.avtospas.feature.login.presentation.StartScreen
import ru.avtospas.feature.main.presentation.MainScreen
import ru.avtospas.feature.orders.presentation.OrderScreen
import ru.avtospas.feature.settings.presentation.SettingsScreen
import ru.avtospas.feature.support.presentation.SupportScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.StartScreen
    ) {
        composable<Screen.StartScreen> {
            StartScreen(
                onNavigateToPhoneScreen = {
                    navController.navigate(Screen.SignUpScreen)
                },
                onNavigateToMainScreen = {navController.navigate(Screen.MainScreen)}
            )
        }

        composable<Screen.SignUpScreen> {
            SignUpScreen(
                onNavigateToStartScreen = { navController.navigate(Screen.StartScreen) },
                onNavigateToMainScreen = {navController.navigate(Screen.MainScreen)}
            )
        }

        composable<Screen.MainScreen> {
            MainScreen(
                onNavigateToStartScreen = { navController.navigate(Screen.StartScreen) },
                onNavigateToEditProfileScreen = {navController.navigate(Screen.EditProfileScreen)},
                onNavigationToOrdersScreen = {navController.navigate(Screen.OrderScreens)},
                onNavigationToSettingsScreen = {navController.navigate(Screen.SettingsScreen)},
                onNavigationToSupportScreen = {navController.navigate(Screen.SupportScreen)}
            )
        }

        composable<Screen.EditProfileScreen> {
            EditProfileScreen()
        }

        composable<Screen.OrderScreens> {
            OrderScreen()
        }

        composable<Screen.SettingsScreen> {
            SettingsScreen()
        }

        composable<Screen.SupportScreen> {
            SupportScreen()
        }

//        // TODO: remove excessive screens
//        // To be fair, there shouldn't be any navigation, IMO.
//        // Because that would require either having different viewmodel
//        // for each of the screens or reusing the same one which we
//        // would need to receive from some di scope
//        composable<Screen.PhoneScreen> {
//            ru.avtospas.feature.login.presentation.PhoneScreen(
//                onNavigateToCodeScreen = { wtf ->
//                    navController.navigate(Screen.CodeScreen(wtf))
//                },
//                onNavigateToStartScreen = {
//                    navController.navigate(Screen.StartScreen) {
//                        popUpTo<Screen.StartScreen> { inclusive = false }
//                    }
//                }
//            )
//        }
//
//        composable<Screen.CodeScreen> { backStackEntry ->
//            val code = backStackEntry.toRoute<Screen.CodeScreen>()
//            ru.avtospas.feature.login.presentation.CodeScreen(
//                phoneNumber = code.phoneNumberFrom,
//                onNavigateToPhoneScreen = {
//                    navController.navigate(Screen.PhoneScreen) {
//                        popUpTo<Screen.CodeScreen> { inclusive = false }
//                    }
//                },
//                onNavigateToFirstRegScreen = {
//                    navController.navigate(Screen.FirstRegScreen)
//                },
//            )
//        }
//
//        composable<Screen.FirstRegScreen> {
//            ru.avtospas.feature.login.presentation.FirstRegScreen(
//                // What's the point in navigating back to code screen?
//                // We need to navigate back to phone number screen with
//                // saved state (which not possible with current implementation)
//                onNavigateToCodeScreen = {
//                    navController.navigate(Screen.PhoneScreen) {
//                        popUpTo<Screen.PhoneScreen> { inclusive = false }
//                    }
//                }
//            )
//        }
    }
}