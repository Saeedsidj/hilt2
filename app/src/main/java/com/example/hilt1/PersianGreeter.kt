package com.example.hilt1

import com.example.hilt1.DI.persianDate
import saman.zamani.persiandate.PersianDate
import javax.inject.Inject
import saman.zamani.persiandate.PersianDateFormat

class PersianGreeter @Inject constructor(
    val logger: Logger,
    val persianDate:PersianDateFormat
):Greet {

    override fun greet(s: String) {
        val pDate=PersianDate()
        logger.logMethod("  سلام $s  ${persianDate.format(pDate)}")
    }
}