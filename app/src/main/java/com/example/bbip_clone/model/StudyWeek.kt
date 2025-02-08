package com.example.bbip_clone.model

data class StudyWeek(
    val studyWeek: List<WeekData>,
)

data class WeekData(
    val title: String,
    val content: String,
    val date: String
)