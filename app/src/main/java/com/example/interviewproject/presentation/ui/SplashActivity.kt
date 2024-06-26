package com.example.interviewproject.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.interviewproject.TestScreenViewModel
import com.example.interviewproject.presentation.theme.InterviewProjectTheme
import com.example.interviewproject.presentation.theme.TestScreen
import com.example.interviewproject.presentation.theme.rememberWindowSizeClass
import com.example.interviewproject.presentation.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val window = rememberWindowSizeClass()
            InterviewProjectTheme(window) {
            Navigation()
            //TestScreen(viewModel = TestScreenViewModel(client = OkHttpClient()))
            }
        }
    }
}