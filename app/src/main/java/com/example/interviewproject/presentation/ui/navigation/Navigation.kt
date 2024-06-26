package com.example.interviewproject.presentation.ui.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.interviewproject.presentation.ui.HomeScreen
import com.example.interviewproject.presentation.ui.ItemScreen
import com.example.interviewproject.presentation.ui.OnBoardingScreen
import com.example.interviewproject.presentation.ui.SplashScreen
import com.example.interviewproject.viewmodels.OnBoardingViewModel
import com.example.interviewproject.viewmodels.homescreenvm.HomeScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(route = Screen.SplashScreen.route ){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.OnBoardingScreen.route) {
            val viewModel = viewModel<OnBoardingViewModel>()
            OnBoardingScreen(navController = navController, viewModel)
        }
        composable(route =Screen.HomeScreen.route ){
            val viewModel = viewModel<HomeScreenViewModel>()
            HomeScreen(homeScreenViewModel = viewModel, navController = navController)
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