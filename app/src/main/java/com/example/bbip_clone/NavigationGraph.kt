package com.example.bbip_clone

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.ui.TabScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "TabScreen") {
        composable("TabScreen") {
            TabScreen(navController)
        }
    }
}
