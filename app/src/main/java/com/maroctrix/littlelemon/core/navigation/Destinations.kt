package com.maroctrix.littlelemon.core.navigation

import com.maroctrix.littlelemon.Constants.DISH_DETAIL_SCREEN
import com.maroctrix.littlelemon.Constants.HOME_SCREEN
import com.maroctrix.littlelemon.Constants.ON_BOARDING_SCREEN
import com.maroctrix.littlelemon.Constants.PROFILE_SCREEN

interface Destinations {
    val route: String
}

object OnBoardingScreen : Destinations {
    override val route = ON_BOARDING_SCREEN
}

object HomeScreen : Destinations {
    override val route = HOME_SCREEN
}

object ProfileScreen : Destinations {
    override val route = PROFILE_SCREEN
}

object DishDetailScreen : Destinations {
    override val route =
        "${DISH_DETAIL_SCREEN}/{itemId}"
}