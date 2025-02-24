package com.example.bbip_clone.ui

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.network.getBulletinBoardData
import com.example.bbip_clone.network.getNotice
import com.example.bbip_clone.network.getNotionCheck
import com.example.bbip_clone.network.getStudySummaryData
import com.example.bbip_clone.network.getStudyWeekData
import com.example.bbip_clone.ui.theme.Gray1
import com.example.bbip_clone.ui.theme.Gray2
import com.example.bbip_clone.ui.theme.Gray3
import com.example.bbip_clone.ui.theme.Gray5
import com.example.bbip_clone.ui.theme.Gray7
import com.example.bbip_clone.ui.theme.Gray8
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.PrimaryDark
import com.example.bbip_clone.ui.theme.allView
import com.example.bbip_clone.ui.theme.arrowRightIcon
import com.example.bbip_clone.ui.theme.attendanceCertification
import com.example.bbip_clone.ui.theme.board
import com.example.bbip_clone.ui.theme.body1_b16
import com.example.bbip_clone.ui.theme.body1_sb16
import com.example.bbip_clone.ui.theme.body2_m14
import com.example.bbip_clone.ui.theme.caption2_m12
import com.example.bbip_clone.ui.theme.title4_sb24
import com.example.bbip_clone.ui.theme.weekStudy
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserHomeScreen(navController: NavController) {
    var noticeCheck by remember { mutableStateOf(false) }
    var noticeText by remember { mutableStateOf("") }
    var isAttendanceCheck by remember { mutableStateOf(false) }
    var progressRatio by remember { mutableStateOf(0f) }

    val studySummaryDataList by remember { mutableStateOf(getStudySummaryData()) }
    val todayStudy = studySummaryDataList.firstOrNull { it.isToday }
    val bulletinList = getBulletinBoardData()

    LaunchedEffect(Unit) {
        noticeCheck = getNotionCheck(true)
        noticeText = getNotice("id")
    }

    LaunchedEffect(todayStudy) {
        while (true) {
            todayStudy?.let { study ->
                progressRatio = calculateProgressRatio(study.startTime, study.endTime)
            }
            delay(1000L)
        }
    }

    Scaffold(
        topBar = { AppBar("UserHome", noticeCheck, "") }
    ) {
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Gray1)
                .padding(bottom = 200.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                HorizontalDivider()
                NoticeBar(
                    noticeText = noticeText,
                    noticeCheck = noticeCheck
                )
                Spacer(modifier = Modifier.height(13.dp))

                val isInStudyTime = progressRatio in 0.001f..99.999f
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TimeRing(
                        modifier = Modifier.fillMaxWidth(),
                        progressRatio = progressRatio
                    )

                    todayStudy?.let { study ->
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(Gray2, shape = RoundedCornerShape(10.dp))
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Text(
                                    text = "TODAY",
                                    color = Gray8,
                                    style = caption2_m12,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = study.title,
                                style = title4_sb24,
                                color = MainWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.fillMaxWidth(0.55f)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "${study.startTime} - ${study.endTime}",
                                style = body2_m14,
                                color = Gray5
                            )

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = study.location,
                                style = body2_m14,
                                color = Gray5
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .size(width = 131.dp, height = 43.dp)
                        .background(
                            if (isInStudyTime && !isAttendanceCheck) PrimaryDark else Gray3,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .align(Alignment.CenterHorizontally)
                        .clickable(enabled = isInStudyTime && !isAttendanceCheck) {
                            isAttendanceCheck = true
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = attendanceCertification,
                        style = body1_sb16,
                        color = if (isInStudyTime && !isAttendanceCheck) MainWhite else Gray5
                    )
                }
                Spacer(Modifier.height(23.dp))
                Row(
                    modifier = Modifier.padding(start = 28.dp, end = 18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = board,
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
                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(bulletinList) { item ->
                        BulletinCard(item, true)
                    }
                }
                Spacer(modifier = Modifier.height(23.dp))
                Text(
                    text = weekStudy,
                    style = body1_b16,
                    color = Gray8,
                    modifier = Modifier.padding(start = 28.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))

                val studyWeekData = getStudyWeekData()
                studyWeekData.forEach { study ->
                    ThisWeekStudyCard(study)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserHomePreview() {
    UserHomeScreen(rememberNavController())
}


