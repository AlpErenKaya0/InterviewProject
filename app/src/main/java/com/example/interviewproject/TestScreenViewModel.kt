package com.example.interviewproject

import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import javax.inject.Inject

class TestScreenViewModel @Inject constructor(
    private val client: OkHttpClient
) : ViewModel() {
}