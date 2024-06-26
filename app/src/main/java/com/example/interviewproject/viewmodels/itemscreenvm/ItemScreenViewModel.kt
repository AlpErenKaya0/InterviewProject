package com.example.interviewproject.viewmodels.itemscreenvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewproject.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject

@HiltViewModel
class ItemScreenViewModel  @Inject constructor(
    private val client: OkHttpClient
) : ViewModel() {
    fun sendWebSocketRequest() {
        val json = """
            {
                "is_request": true,
                "id": 84,
                "params": [
                    {
                        "id": "a2830d60-ddff-4ad-8f3d-dfca0ded2462",
                        "value": 1
                    }
                ],
                "method": "UpdateControlValue"
            }
        """.trimIndent()

        val request = Request.Builder()
            .url("ws://${Constants.IP}:${Constants.PORT}")
            .build()

        client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                webSocket.send(json)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response) }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
            }
        })
    }
}