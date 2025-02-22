package com.example.bbip_clone.network

import com.example.bbip_clone.R
import com.example.bbip_clone.model.StudySummaryData
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
    studyDataList.add(StudyWeekData("8", "", "20250215"))
    studyDataList.add(StudyWeekData("9", "오늘은 공부하지 말까여..", "20250222"))
    studyDataList.add(StudyWeekData("10", "", "20250230"))

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

fun getNotice(id: String): String {
    return "다음주 스터디 하루 쉬어갑니다! 확인 해주세요...!"
}


fun getStudySummaryData(): List<StudySummaryData> {
    val studySummaryDataList = mutableListOf<StudySummaryData>()

    studySummaryDataList.add(StudySummaryData("TOEIC / IELTS", "18:00", "20:00", "예대 4층", true))
    studySummaryDataList.add(StudySummaryData("JLPT N2 대비 청해 스터디", "09:00", "11:00", "전정대 2층", false))
    studySummaryDataList.add(StudySummaryData("코틀린 스터디", "19:00", "21:00", "도서관 2층", false))
    return studySummaryDataList
}