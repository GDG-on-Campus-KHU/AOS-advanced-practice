package com.example.bbip_clone.network

import com.example.bbip_clone.R
import com.example.bbip_clone.model.BulletinBoardData
import com.example.bbip_clone.model.UpComingScheduleData
import com.example.bbip_clone.model.StudySummaryData
import com.example.bbip_clone.model.StudyWeekData
import com.example.bbip_clone.model.TeamMember
import com.example.bbip_clone.model.ThisWeekStudyData
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
fun getBulletinBoardData(): List<BulletinBoardData> {
    val bulletinBoardDataList = mutableListOf<BulletinBoardData>()

    bulletinBoardDataList.add(BulletinBoardData(studyTitle = "포트폴리오 스터디", content = "오늘 스터디는 강서구 카페베네에서 진행합니달라...", writeTime = "1시간 전", isNotice = true))
    bulletinBoardDataList.add(BulletinBoardData(studyTitle = "JLPT N2 청해 스터디", content = "이거 문제 어우에에ㅜㅇㅇ 못 풀겠져엉 오ㅜㅇ애...", writeTime = "1일 전", round = "7주차"))
    bulletinBoardDataList.add(BulletinBoardData(studyTitle = "JLPT N2 청해 스터디", content = "이거 문제 어우에에ㅜㅇㅇ 못 풀겠져엉 오ㅜㅇ애...", writeTime = "2일 전", round = "8주차"))

    return bulletinBoardDataList
}
fun getStudyWeekData(): List<ThisWeekStudyData> {
    val studyWeekDataList = mutableListOf<ThisWeekStudyData>()

    studyWeekDataList.add(ThisWeekStudyData(R.drawable.ic_launcher_background,"JLPT N2 청해 스터디", "6R", "어학", "단어 시험, 교재 300~320p", "8월 13일", "12:00", "15:00", "미정"))
    studyWeekDataList.add(ThisWeekStudyData(R.drawable.ic_launcher_background,"JLPT N2 청해 스터디", "8R", "어학", "2차 과제 제출 확인 및 피드백", "8월 9일", "15:00", "18:00", "비대면(디코)"))
    studyWeekDataList.add(ThisWeekStudyData(R.drawable.ic_launcher_background,"JLPT N2 청해 스터디", "3R", "어학", "단어 시험, 교재 300~320p", "8월 14일", "12:00", "18:00", "스타벅스 강남역점"))

    return studyWeekDataList
}

fun getUpcomingScheduleData(): List<UpComingScheduleData> {
    val  upComingScheduleDataList = mutableListOf<UpComingScheduleData>()

    upComingScheduleDataList.add(UpComingScheduleData("D-12", "JLPT N2 접수"))
    upComingScheduleDataList.add(UpComingScheduleData("D-20", "포트폴리오"))
    upComingScheduleDataList.add(UpComingScheduleData("D-41", "3차 모고"))

    return upComingScheduleDataList
}