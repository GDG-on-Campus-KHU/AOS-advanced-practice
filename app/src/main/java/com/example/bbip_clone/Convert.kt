package com.example.bbip_clone

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun convertTodayDate(): String {
    return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
}

fun convertDateFormat(dateString: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val outputFormatter = DateTimeFormatter.ofPattern("M월 d일 (E)", Locale.KOREAN)
    val date = LocalDate.parse(dateString, inputFormatter)

    return date.format(outputFormatter)
}

fun convertDateToNumber(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일")
    val outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val date = LocalDate.parse(dateString, formatter)

    return date.format(outputFormatter)
}

fun convertNumberToDate(dateNumber: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val outputFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일")
    val date = LocalDate.parse(dateNumber, formatter)

    return date.format(outputFormatter)
}