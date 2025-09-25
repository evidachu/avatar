package com.example.project1androidui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Profile : Screen("profile")
    object Avatar : Screen("avatar")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Screen.Profile.route) },
                onNavigateToRegister = { navController.navigate(Screen.Register.route) }
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate(Screen.Login.route) },
                onNavigateToLogin = { navController.navigate(Screen.Login.route) }
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                onLogout = { navController.navigate(Screen.Login.route) },
                onNavigateToAvatar = { navController.navigate(Screen.Avatar.route) }
            )
        }
        composable(Screen.Avatar.route) {
            AvatarScreen(
                onNavigateToProfile = { navController.navigate(Screen.Profile.route) }
            )
        }
    }
}