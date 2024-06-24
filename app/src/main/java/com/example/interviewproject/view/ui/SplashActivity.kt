package com.example.interviewproject.view.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.interviewproject.view.theme.InterviewProjectTheme
import com.example.interviewproject.view.ui.navigation.Navigation

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterviewProjectTheme {
                Navigation()
            }
        }
    }
}