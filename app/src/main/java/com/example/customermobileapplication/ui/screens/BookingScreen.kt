package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel

@Composable
fun BookingScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
){
    Surface(modifier = Modifier.fillMaxSize()
        .background(color = Color.Red)) {

    }
}

@Preview
@Composable
fun BookingScreenPreview(){
    BookingScreen()
}