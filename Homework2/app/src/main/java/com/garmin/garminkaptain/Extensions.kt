package com.garmin.garminkaptain

import java.text.SimpleDateFormat
import java.util.*

inline val <reified T> T.TAG: String
    get() = T::class.java.simpleName

fun Date.convertToString( format: String): String {
    val format = SimpleDateFormat(format)
    return format.format(this)
}