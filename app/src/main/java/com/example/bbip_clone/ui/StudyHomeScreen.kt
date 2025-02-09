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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
import com.example.bbip_clone.ui.theme.Gray9
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.PrimaryDark
import com.example.bbip_clone.ui.theme.archive
import com.example.bbip_clone.ui.theme.body2_m14
import com.example.bbip_clone.ui.theme.caption2_m12
import com.example.bbip_clone.ui.theme.certification
import com.example.bbip_clone.ui.theme.dateRangeIcon
import com.example.bbip_clone.ui.theme.homeIcon
import com.example.bbip_clone.ui.theme.place

@Composable
fun StudyHomeScreen(navController: NavController) {
    var studyTitle by remember { mutableStateOf("") }
    var studyWeek by remember { mutableStateOf(emptyList<StudyWeekData>()) }
    var thisWeek by remember { mutableStateOf("") }
    var weekNotice by remember { mutableStateOf("") }
    var weekDate by remember { mutableStateOf("") }
    var weekDateFormatted by remember { mutableStateOf("") }
    var weekLocation by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        studyTitle = getStudyTitle("id")
        studyWeek = getStudyWeekData()
        studyWeek.firstOrNull { it.date > convertTodayDate() }?.let {
            weekDate = it.date
            thisWeek = it.title
            weekNotice = it.content
        }
        getWeekData(thisWeek).let {
            weekDateFormatted = "${convertDateFormat(weekDate)} / ${it.startTime} ~ ${it.endTime}"
            weekLocation = it.location
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

            Column(modifier = Modifier.padding(it)) {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 200.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RoundedBackgroundText("${thisWeek}R", caption2_m12, MainWhite, PrimaryDark)
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = weekNotice,
                            style = body2_m14,
                            color = MainWhite,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(Modifier.height(10.dp))

                    WeekInfo(homeIcon, weekDateFormatted)
                    Spacer(Modifier.height(4.dp))
                    WeekInfo(dateRangeIcon, weekLocation)
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