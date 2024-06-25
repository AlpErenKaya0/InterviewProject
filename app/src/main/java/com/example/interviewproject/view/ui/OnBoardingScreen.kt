package com.example.interviewproject.view.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.interviewproject.R
import com.example.interviewproject.view.theme.AppTheme
import com.example.interviewproject.view.ui.navigation.Screen

@Composable
fun OnBoardingScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LinearGradient(navController)
    }
}
@Composable
fun LinearGradient(navController: NavController) {
    val gradient = Brush.linearGradient(
        0.0f to Color.Magenta,
        500.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient) ,
            contentAlignment= Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.inohom_plus_text),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(vertical = AppTheme.dimens.small)
            )
            Text(
                text = stringResource(id = R.string.version_text),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Thin,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(vertical = AppTheme.dimens.large)
            )
            Button(onClick = { navController.navigate(Screen.HomeScreen.route) }, modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = AppTheme.dimens.huge, vertical = AppTheme.dimens.small)
            ) {
                Text(text = stringResource(id = R.string.onboarding_button_text),
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
        }
    }
}
