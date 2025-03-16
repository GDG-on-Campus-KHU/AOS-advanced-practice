package com.example.bbip_clone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bbip_clone.ui.StudyHomeScreen
import com.example.bbip_clone.ui.UserHomeScreen

@Composable
fun TabNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = TabScreen.Home.route
    ) {
        composable(TabScreen.Home.route) { UserHomeScreen(navController) }
        composable(TabScreen.Study.route) { StudyHomeScreen(navController) }
    }
}