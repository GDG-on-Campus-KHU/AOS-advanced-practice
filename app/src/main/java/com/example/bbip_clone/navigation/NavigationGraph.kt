package com.example.bbip_clone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bbip_clone.ui.StudyHomeScreen
import com.example.bbip_clone.ui.UserHomeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { UserHomeScreen(navController) }
        composable(Screen.Study.route) { StudyHomeScreen(navController) }
    }
}