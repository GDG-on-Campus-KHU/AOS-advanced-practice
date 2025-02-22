package com.example.bbip_clone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.network.getNotice
import com.example.bbip_clone.network.getNotionCheck
import com.example.bbip_clone.network.getStudySummaryData
import com.example.bbip_clone.ui.theme.Gray1
import com.example.bbip_clone.ui.theme.Gray2
import com.example.bbip_clone.ui.theme.Gray5
import com.example.bbip_clone.ui.theme.Gray6
import com.example.bbip_clone.ui.theme.Gray8
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.PrimaryDark
import com.example.bbip_clone.ui.theme.body1_sb16
import com.example.bbip_clone.ui.theme.body2_m14
import com.example.bbip_clone.ui.theme.caption2_m12
import com.example.bbip_clone.ui.theme.notice
import com.example.bbip_clone.ui.theme.title4_sb24

@Composable
fun UserHomeScreen(navController: NavController) {
    var noticeCheck by remember { mutableStateOf(false) }
    var noticeText by remember { mutableStateOf("") }

    val studySummaryDataList = remember { getStudySummaryData() }
    val todayStudy = studySummaryDataList.firstOrNull { it.isToday }

    LaunchedEffect(Unit) {
        noticeCheck = getNotionCheck(true)
        noticeText = getNotice("id")
    }

    Scaffold(
        topBar = { AppBar("UserHome", noticeCheck, "") }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Gray1)
        ) {
            HorizontalDivider()
            NoticeBar(
                noticeText = noticeText,
                noticeCheck = noticeCheck
            )
            Spacer(modifier = Modifier.height(13.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TimeRing(
                    modifier = Modifier.fillMaxWidth()
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
                            modifier = Modifier.fillMaxWidth(0.55f) // 더 좋은 대안?
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserHomePreview() {
    UserHomeScreen(rememberNavController())
}


