package com.example.bbip_clone.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun StudyHomeScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Text("StudyHomeScreen")
    }
}

@Preview(showBackground = true)
@Composable
fun StudyHomePreview(){
    StudyHomeScreen(rememberNavController())
}