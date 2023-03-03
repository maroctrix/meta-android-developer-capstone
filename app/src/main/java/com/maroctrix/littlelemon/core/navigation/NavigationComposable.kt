package com.maroctrix.littlelemon.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.maroctrix.littlelemon.Constants.ITEM_ID
import com.maroctrix.littlelemon.presentation.dishDetail.DishDetail
import com.maroctrix.littlelemon.presentation.home.Home
import com.maroctrix.littlelemon.presentation.profile.Profile
import com.maroctrix.littlelemon.presentation.register.OnBoarding

@Composable
fun NavigationComposable(navController: NavHostController, isRegistered: Boolean) {

    val startDestinationRoute = if (isRegistered) HomeScreen.route else OnBoardingScreen.route

    NavHost(navController = navController, startDestination = startDestinationRoute) {
        composable(route = OnBoardingScreen.route) {
            OnBoarding(navController)
        }
        composable(route = HomeScreen.route) {
            Home(navController, onItemPressed = {
                navController.navigate(
                    "${DishDetailScreen.route}/${it.id}"
                )
            })
        }
        composable(ProfileScreen.route) {
            Profile(navController)
        }
        composable(
            route = "${DishDetailScreen.route}/{itemId}",
            arguments = listOf(
                navArgument(ITEM_ID) { type = NavType.StringType },
            )
        ) { navStackEntry ->
            DishDetail(
                onBackButtonClicked = {
                    navController.navigate(HomeScreen.route)
                },
                navStackEntry.arguments?.getString(ITEM_ID, ""),
            )
        }
    }
}