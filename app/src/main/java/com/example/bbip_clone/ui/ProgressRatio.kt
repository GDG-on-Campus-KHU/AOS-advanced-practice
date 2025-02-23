package com.example.bbip_clone.ui

import android.util.Log
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun calculateProgressRatio(startTime: String, endTime: String): Float {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")

    val start = LocalTime.parse(startTime, formatter)
    val end = LocalTime.parse(endTime, formatter)
    val now = LocalTime.now()

    val startHour = start.hour
    val startMinute = start.minute
    val startSecond = start.second
    val endHour = end.hour
    val endMinute = end.minute
    val endSecond = end.second
    val nowHour = now.hour
    val nowMinute = now.minute
    val nowSecond = now.second

    return if (now.isBefore(start)) {
        0f
    } else if (now.isAfter(end)) {
        100f
    } else {
        val elapsedTime = (nowHour * 3600 + nowMinute * 60 + nowSecond) - (startHour * 3600 + startMinute * 60 + startSecond)
        val totalTime = (endHour * 3600 + endMinute * 60 + endSecond) - (startHour * 3600 + startMinute * 60 + startSecond)
        val result = 100 - (elapsedTime.toFloat() / totalTime.toFloat()) * 100f
        Log.d("TimeDebug", "Now: $now, StartTime: $start, EndTime: $end, result: $result")

        result
    }
}
