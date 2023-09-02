package com.example.hilt1

import android.util.Log
import javax.inject.Inject

class Logger @Inject constructor() {
    fun logMethod(string:String){
        Log.d("Logger", string)
    }
}