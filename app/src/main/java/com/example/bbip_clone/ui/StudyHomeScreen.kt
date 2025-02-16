package com.example.bbip_clone.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.R
import com.example.bbip_clone.convertNumberToDate
import com.example.bbip_clone.convertTodayDate
import com.example.bbip_clone.formatNumber
import com.example.bbip_clone.model.StudyWeekData
import com.example.bbip_clone.network.getStudyTitle
import com.example.bbip_clone.network.getStudyWeekData
import com.example.bbip_clone.network.getTeamMember
import com.example.bbip_clone.network.getWeekData
import com.example.bbip_clone.ui.theme.Gray1
import com.example.bbip_clone.ui.theme.Gray2
import com.example.bbip_clone.ui.theme.Gray5
import com.example.bbip_clone.ui.theme.Gray7
import com.example.bbip_clone.ui.theme.Gray8
import com.example.bbip_clone.ui.theme.Gray9
import com.example.bbip_clone.ui.theme.MainBlack
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.PrimaryDark
import com.example.bbip_clone.ui.theme.allView
import com.example.bbip_clone.ui.theme.archive
import com.example.bbip_clone.ui.theme.arrowRightIcon
import com.example.bbip_clone.ui.theme.body1_b16
import com.example.bbip_clone.ui.theme.body2_m14
import com.example.bbip_clone.ui.theme.caption2_m12
import com.example.bbip_clone.ui.theme.certification
import com.example.bbip_clone.ui.theme.dateRangeIcon
import com.example.bbip_clone.ui.theme.homeIcon
import com.example.bbip_clone.ui.theme.place
import com.example.bbip_clone.ui.theme.progress
import com.example.bbip_clone.ui.theme.studyMembers
import com.example.bbip_clone.ui.theme.title3_sb20
import com.example.bbip_clone.ui.theme.weekActivities

@Composable
fun StudyHomeScreen(navController: NavController) {
    var studyTitle by remember { mutableStateOf("") }
    var studyData by remember { mutableStateOf(emptyList<StudyWeekData>()) }
    var studyNotice by remember { mutableStateOf("") }
    var thisWeekRound by remember { mutableStateOf("") }
    var studyLastRound by remember { mutableStateOf("") }
    var thisWeekContent by remember { mutableStateOf("") }
    var thisWeekDate by remember { mutableStateOf("") }
    var lastWeekDate by remember { mutableStateOf("") }
    var thisWeekDateFormatted by remember { mutableStateOf("") }
    var thisWeekLocation by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        studyTitle = getStudyTitle("id")
        studyData = getStudyWeekData("id")
        studyLastRound = studyData.size.toString()
        lastWeekDate = studyData.last().date
        studyData.firstOrNull { it.date > convertTodayDate() }?.let {
            thisWeekRound = it.round
            thisWeekContent = it.content
            thisWeekDate = it.date
        }
        studyLastRound = studyData.last().round
        getWeekData(thisWeekRound).let {
            thisWeekDateFormatted =
                "${convertNumberToDate(thisWeekDate)} / ${it.startTime} ~ ${it.endTime}"
            thisWeekLocation = it.location
            studyNotice = it.notice
        }
    }

    Scaffold(
        topBar = { AppBar("StudyHome", false, studyTitle) }
    ) {
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Gray1)
                .padding(bottom = 200.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Gray9)
                    .height(300.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            )

            Image(
                painter = painterResource(R.drawable.study_mask),
                contentDescription = "StudyMask",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 75.dp)
                    .size(300.dp)
            )

            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RoundedBackgroundText("${thisWeekRound}R", caption2_m12, MainWhite, PrimaryDark)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = studyNotice,
                        style = body2_m14,
                        color = MainWhite,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(Modifier.height(10.dp))
                WeekInfo(homeIcon, thisWeekDateFormatted)
                Spacer(Modifier.height(4.dp))
                WeekInfo(dateRangeIcon, thisWeekLocation)

                Spacer(Modifier.height(225.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StudyOptions(R.drawable.attendance_certification, certification)
                    StudyOptions(R.drawable.check_location, place)
                    StudyOptions(R.drawable.archive, archive)
                }

                Spacer(Modifier.height(25.dp))
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = progress,
                    style = body1_b16,
                    color = Gray8
                )
                Spacer(Modifier.height(12.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(16.dp, RoundedCornerShape(12.dp), spotColor = Gray2)
                        .background(MainWhite, RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp, end = 5.dp)
                    ) {
                        Text(
                            text = "${thisWeekRound}R / ",
                            style = title3_sb20,
                            color = MainBlack
                        )
                        Text(
                            text = "${studyLastRound}R",
                            style = title3_sb20,
                            color = Gray5
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "(${formatNumber(thisWeekDate)}~${formatNumber(lastWeekDate)})",
                            style = caption2_m12,
                            color = Gray5
                        )
                    }

                        Spacer(modifier = Modifier.height(12.dp))
                        Box(modifier = Modifier.fillMaxWidth()) {
                            val studyLastRoundFloat = studyLastRound.toFloatOrNull() ?: 1f
                            val animatedProgress by animateFloatAsState(
                                targetValue = thisWeekRoundFloat,
                                animationSpec = tween(
                                    durationMillis = if (isRefreshing) 0 else 1000,
                                    easing = FastOutSlowInEasing
                                ),
                                label = "progress"
                            )
                            LinearProgressIndicator(
                                progress = { animatedProgress / studyLastRoundFloat },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 3.dp, bottom = 3.dp)
                                    .height(7.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .align(Alignment.Center),
                                color = PrimaryDark,
                                trackColor = Gray2,
                            )
                            Row {
                                if (thisWeekRoundFloat != 0f) {
                                    Spacer(Modifier.weight(maxOf(animatedProgress, 0.0001f)))
                                    Box(
                                        modifier = Modifier
                                            .size(12.dp)
                                            .clip(CircleShape)
                                            .background(PrimaryDark)
                                    )
                                    if ((studyLastRoundFloat - thisWeekRoundFloat) != 0f)
                                        Spacer(
                                            Modifier.weight(
                                                maxOf(
                                                    studyLastRoundFloat - animatedProgress,
                                                    0.0001f
                                                )
                                            )
                                        )
                                }
                            }
                        }
                    }

                Spacer(Modifier.height(23.dp))
                Row(
                    modifier = Modifier.padding(start = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = weekActivities,
                        style = body1_b16,
                        color = Gray8
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        modifier = Modifier.clickable { },
                        text = allView,
                        style = body2_m14,
                        color = Gray7
                    )
                    Icon(
                        imageVector = arrowRightIcon,
                        contentDescription = "화살표",
                        tint = Gray7
                    )
                }
                Spacer(Modifier.height(14.dp))
                studyData.drop((thisWeekRound.toIntOrNull() ?: 1) - 1).take(2).forEach { activity ->
                    WeekActivityCard(activity, thisWeekRound)
                }

                Spacer(Modifier.height(23.dp))
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = studyMembers,
                    style = body1_b16
                )
                Spacer(modifier = Modifier.height(12.dp))
                LazyRow {
                    items(getTeamMember("id")) { member ->
                        TeamMemberCard(member)
                    }
                    item {
                        InviteButton()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudyHomePreview() {
    StudyHomeScreen(rememberNavController())
}