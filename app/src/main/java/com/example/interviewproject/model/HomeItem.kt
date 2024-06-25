package com.example.interviewproject.model

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.drawscope.DrawScopeMarker

data class HomeItem(
    val title: String,
    @DrawableRes val logo:Int
)
