package com.example.interviewproject.viewmodels.homescreenvm

sealed class HomeScreenEvent {
    data class Search (val searchString: String) : HomeScreenEvent()
}