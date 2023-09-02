package com.example.hilt1

import javax.inject.Inject

class PersianGreeter @Inject constructor(
    val logger: Logger
) {
    fun greet(s: String) {
        logger.logMethod(s)
    }
}