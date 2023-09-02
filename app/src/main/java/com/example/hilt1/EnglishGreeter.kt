package com.example.hilt1

import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import javax.inject.Inject

class EnglishGreeter @Inject constructor(
    val logger: Logger,
    val persianDate: PersianDateFormat
) {

    fun greet(s: String) {
        val pDate= PersianDate()
        logger.logMethod("  Hi $s  ${persianDate.format(pDate)}")
    }
}