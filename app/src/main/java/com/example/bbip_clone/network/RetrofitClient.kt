package com.example.bbip_clone.network

import com.example.bbip_clone.model.StudyWeek
import com.example.bbip_clone.model.WeekData

fun getNotionCheck(id: Boolean): Boolean {
    return id
}

fun getStudyTitle(id: String): String {
    return "TOEIC / IELTS 스터디"
}

fun getStudyWeekData(): List<StudyWeek> {
    val studyWeekList = mutableListOf<WeekData>()

    studyWeekList.add(WeekData("1", "", "2024년 9월 24일"))
    studyWeekList.add(WeekData("2", "", "2024년 10월 29일"))
    studyWeekList.add(WeekData("3", "", "2024년 11월 29일"))
    studyWeekList.add(WeekData("4", "", "2024년 12월 29일"))
    studyWeekList.add(WeekData("5", "", "2025년 1월 3일"))
    studyWeekList.add(WeekData("6", "", "2025년 1월 10일"))
    studyWeekList.add(WeekData("7", "", "2025년 1월 17일"))
    studyWeekList.add(WeekData("8", "", "2025년 1월 24일"))
    studyWeekList.add(WeekData("9", "오늘은 공부하지 말까여..", "2025년 2월 15일"))
    studyWeekList.add(WeekData("10", "", "2025년 2월 23일"))

    return listOf(StudyWeek(studyWeekList))
}