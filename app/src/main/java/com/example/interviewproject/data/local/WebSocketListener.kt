package com.example.interviewproject.data.local

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketListener:WebSocketListener() {
    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        webSocket.send("hello")
        Log.e("Local","Connected")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        outPut("Received: $text")
        super.onMessage(webSocket, text)
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        outPut("Closing: $code / $reason")
        super.onClosing(webSocket, code, reason)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        outPut("Error:"+ t.localizedMessage)
        super.onFailure(webSocket, t, response)
    }
    private fun outPut(text:String) {
        Log.d( "WebSocket",text!!)

    }
    companion object {
        private val NORMAL_CLOSURE_STATUS = 1000
    }
}