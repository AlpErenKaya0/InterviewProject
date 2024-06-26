package com.example.interviewproject.viewmodels.itemscreenvm

sealed class ItemScreenEvent {
    data class Search (val searchString: String) : ItemScreenEvent()
}