package com.example.bbip_clone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.R
import com.example.bbip_clone.convertDateFormat
import com.example.bbip_clone.convertTodayDate
import com.example.bbip_clone.model.StudyWeekData
import com.example.bbip_clone.network.getStudyTitle
import com.example.bbip_clone.network.getStudyWeekData
import com.example.bbip_clone.network.getWeekData
import com.example.bbip_clone.ui.theme.Gray1
import com.example.bbip_clone.ui.theme.Gray2
import com.example.bbip_clone.ui.theme.Gray8
import com.example.bbip_clone.ui.theme.Gray9
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.PrimaryDark
import com.example.bbip_clone.ui.theme.archive
import com.example.bbip_clone.ui.theme.body1_b16
import com.example.bbip_clone.ui.theme.body2_m14
import com.example.bbip_clone.ui.theme.caption2_m12
import com.example.bbip_clone.ui.theme.certification
import com.example.bbip_clone.ui.theme.dateRangeIcon
import com.example.bbip_clone.ui.theme.homeIcon
import com.example.bbip_clone.ui.theme.place
import com.example.bbip_clone.ui.theme.progress

@Composable
fun StudyHomeScreen(navController: NavController) {
    var studyTitle by remember { mutableStateOf("") }
    var studyData by remember { mutableStateOf(emptyList<StudyWeekData>()) }
    var thisWeek by remember { mutableStateOf("") }
    var studyWeek by remember { mutableStateOf("") }
    var thisWeekNotice by remember { mutableStateOf("") }
    var thisWeekDate by remember { mutableStateOf("") }
    var thisWeekDateFormatted by remember { mutableStateOf("") }
    var thisWeekLocation by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        studyTitle = getStudyTitle("id")
        studyData = getStudyWeekData()
        studyWeek = studyData.size.toString()
        studyData.firstOrNull { it.date > convertTodayDate() }?.let {
            thisWeekDate = it.date
            thisWeek = it.title
            thisWeekNotice = it.content
        }
        getWeekData(thisWeek).let {
            thisWeekDateFormatted =
                "${convertDateFormat(thisWeekDate)} / ${it.startTime} ~ ${it.endTime}"
            thisWeekLocation = it.location
        }
    }

    Scaffold(
        topBar = { AppBar("StudyHome", false, studyTitle) })
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray1)
        ) {
            Box(
                modifier = Modifier
                    .background(Gray9)
                    .height(300.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            )

            Column(modifier = Modifier.align(Alignment.TopEnd)) {
                Spacer(Modifier.height(75.dp))
                Image(
                    painter = painterResource(R.drawable.study_mask),
                    contentDescription = "StudyMask",
                    modifier = Modifier.size(300.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RoundedBackgroundText("${thisWeek}R", caption2_m12, MainWhite, PrimaryDark)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = thisWeekNotice,
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudyHomePreview() {
    StudyHomeScreen(rememberNavController())
}