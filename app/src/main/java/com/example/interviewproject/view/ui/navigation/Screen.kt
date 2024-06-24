package com.example.interviewproject.view.ui.navigation

sealed class Screen (val route:String) {
    object SplashScreen:Screen("splash_screen")
    object OnBoardingScreen:Screen("onboarding_screen")
    object HomeScreen:Screen("home_screen")
    object ItemScreen:Screen("item_screen")
}