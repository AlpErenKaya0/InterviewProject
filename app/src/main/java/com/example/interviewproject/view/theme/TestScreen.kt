package com.example.interviewproject.view.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

@Composable
fun TestScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LinearGradient()
    }
}
@Composable
fun LinearGradient() {
    val gradient = Brush.linearGradient(
        0.0f to Color.Magenta,
        500.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient))
}


@Composable
fun HorizontalGradient() {
    val gradient = Brush.horizontalGradient(
        0.0f to Color.Magenta,
        1.0f to Color.Cyan,
        startX = 0.0f,
        endX = 1000.0f
    )
    Box(modifier = Modifier.background(gradient))
}

@Composable
fun VerticalGradient() {
    val gradient = Brush.verticalGradient(
        0.0f to Color.Magenta,
        1.0f to Color.Cyan,
        startY = 0.0f,
        endY = 1500.0f
    )
    Box(modifier = Modifier.background(gradient))
}


@Composable
fun RadialGradient() {
    val gradient = Brush.radialGradient(
        0.0f to Color.Magenta,
        1.0f to Color.Cyan,
        radius = 1500.0f,
        tileMode = TileMode.Repeated
    )
    Box(modifier = Modifier.background(gradient))
}
/*
   val transition =  rememberInfiniteTransition()

    val color by transition.animateColor(initialValue = Color.hsl(1.0f,0.2f, 0.3f,0.4f,),
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(15000),
            repeatMode = RepeatMode.Reverse
        ) )
    Box(modifier = Modifier.size(200.dp).background(color))

    */
