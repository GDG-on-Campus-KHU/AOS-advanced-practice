package com.example.bbip_clone.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bbip_clone.ui.theme.dateRangeIcon
import com.example.bbip_clone.ui.theme.homeIcon

sealed class Screen(val route: String, val icon: ImageVector) {
    data object Home : Screen("home", homeIcon)
    data object Study : Screen("study", dateRangeIcon)
}