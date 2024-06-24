package com.example.interviewproject.view.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.interviewproject.view.ui.HomeScreen
import com.example.interviewproject.view.ui.ItemScreen
import com.example.interviewproject.view.ui.OnBoardingScreen
import com.example.interviewproject.view.ui.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(route = Screen.SplashScreen.route ){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screen.ItemScreen.route) {
            ItemScreen(navController = navController)
        }
    }
}