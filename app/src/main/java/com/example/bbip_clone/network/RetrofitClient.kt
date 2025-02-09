package com.example.bbip_clone.network

import com.example.bbip_clone.model.StudyWeekData

fun getNotionCheck(id: Boolean): Boolean {
    return id
}

fun getStudyTitle(id: String): String {
    return "TOEIC / IELTS 스터디"
}

fun getStudyWeekData(): List<StudyWeekData> {
    val studyDataList = mutableListOf<StudyWeekData>()

    studyDataList.add(StudyWeekData("1", "", "20240924"))
    studyDataList.add(StudyWeekData("2", "", "20241029"))
    studyDataList.add(StudyWeekData("3", "", "20241129"))
    studyDataList.add(StudyWeekData("4", "", "20241229"))
    studyDataList.add(StudyWeekData("5", "", "20250103"))
    studyDataList.add(StudyWeekData("6", "", "20250110"))
    studyDataList.add(StudyWeekData("7", "", "20250117"))
    studyDataList.add(StudyWeekData("8", "", "20250124"))
    studyDataList.add(StudyWeekData("9", "오늘은 공부하지 말까여..", "20250215"))
    studyDataList.add(StudyWeekData("10", "", "20250223"))

    return studyDataList
}