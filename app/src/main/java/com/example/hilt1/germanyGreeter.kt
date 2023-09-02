package com.example.hilt1

import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import javax.inject.Inject


class GermanyGreeter @Inject constructor(
    val logger: Logger,
    val persianDate: PersianDateFormat
):Greet {

    override fun greet(s: String) {
        val pDate= PersianDate()
        logger.logMethod("  hail $s  ${persianDate.format(pDate)}")
    }
}