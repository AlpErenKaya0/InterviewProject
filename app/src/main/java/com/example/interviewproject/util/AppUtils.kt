package com.example.interviewproject.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.interviewproject.view.theme.Dimensions
import com.example.interviewproject.view.theme.Orientation
import com.example.interviewproject.view.theme.smallDimensions

@Composable
fun ProvideAppUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    content: @Composable () -> Unit
) {
    val dimSet = remember{dimensions}
    val orientation = remember{orientation}
    CompositionLocalProvider(
        LocaleAppDimens provides dimSet,
        LocalOrientationMode provides orientation,

    ) {
        content()
    }
}
val LocaleAppDimens = compositionLocalOf {
    smallDimensions
}
val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait
}