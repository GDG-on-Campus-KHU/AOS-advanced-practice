package com.example.bbip_clone.network

import com.example.bbip_clone.R
import com.example.bbip_clone.model.StudyWeekData
import com.example.bbip_clone.model.TeamMember
import com.example.bbip_clone.model.WeekDate

// 네트워크 예시 데이터

fun getNotionCheck(id: Boolean): Boolean {
    return id
}

fun getStudyTitle(id: String): String {
    return "TOEIC / IELTS 스터디"
}

fun getWeekData(thisWeek: String): WeekDate {
    return WeekDate("12:00", "18:00", "2차 과제 제출 및 피드백 확인", "스타벅스 강남역")
}

fun getStudyWeekData(id: String): List<StudyWeekData> {
    val studyDataList = mutableListOf<StudyWeekData>()

    studyDataList.add(StudyWeekData("1", "", "20240924"))
    studyDataList.add(StudyWeekData("2", "", "20241029"))
    studyDataList.add(StudyWeekData("3", "", "20241129"))
    studyDataList.add(StudyWeekData("4", "", "20241229"))
    studyDataList.add(StudyWeekData("5", "", "20250103"))
    studyDataList.add(StudyWeekData("6", "", "20250110"))
    studyDataList.add(StudyWeekData("7", "", "20250117"))
    studyDataList.add(StudyWeekData("8", "", "20250124"))
    studyDataList.add(StudyWeekData("9", "", "20250215"))
    studyDataList.add(StudyWeekData("10", "오늘은 공부하지 말까여..", "20250223"))

    return studyDataList
}

fun getTeamMember(id: String): List<TeamMember> {
    val teamMembers = listOf(
        TeamMember("Andy", "팀장", R.drawable.ic_launcher_background),
        TeamMember("Andy", "팀원", R.drawable.ic_launcher_background),
        TeamMember("Andy", "팀원", R.drawable.ic_launcher_background)
    )

    return teamMembers
}