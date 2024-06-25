package com.example.interviewproject.view.ui.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(route =Screen.HomeScreen.route ){
            HomeScreen(navController = navController)
        }
        composable(route = "item_screen/{clickedHome}/{clickedHomeLogo}", arguments = listOf(
                navArgument("clickedHome"){
                    //actually, arguments type safety but i want to use it like that
                    type = NavType.StringType
                },
            navArgument("clickedHomeLogo") {
                type = NavType.IntType
            }
        )) {
            val clickedHome = remember {
                it.arguments?.getString("clickedHome")
            }
            val clickedHomeLogo = remember {
                it.arguments?.getInt("clickedHomeLogo")
            }
            ItemScreen(clickedHome = clickedHome?:""
                ,clickedHomeLogo = (clickedHomeLogo?:"") as Int
                ,navController = navController)
        }
    }
}