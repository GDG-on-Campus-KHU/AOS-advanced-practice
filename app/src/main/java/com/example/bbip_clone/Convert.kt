package com.example.bbip_clone

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun convertTodayDate(): String {
    return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
}

fun convertDateToNumber(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일")
    val date = LocalDate.parse(dateString, formatter)
    return date.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
}

fun convertNumberToDate(dateNumber: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val date = LocalDate.parse(dateNumber, formatter)
    return date.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"))
}