package com.example.bbip_clone.ui

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.bbip_clone.convertNumberToDate
import com.example.bbip_clone.model.StudyWeekData
import com.example.bbip_clone.model.TeamMember
import com.example.bbip_clone.ui.theme.Gray2
import com.example.bbip_clone.ui.theme.Gray3
import com.example.bbip_clone.ui.theme.Gray5
import com.example.bbip_clone.ui.theme.Gray6
import com.example.bbip_clone.ui.theme.Gray7
import com.example.bbip_clone.ui.theme.Gray8
import com.example.bbip_clone.ui.theme.MainBlack
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.PrimaryDark
import com.example.bbip_clone.ui.theme.addIcon
import com.example.bbip_clone.ui.theme.archive
import com.example.bbip_clone.ui.theme.body1_sb16
import com.example.bbip_clone.ui.theme.body2_m14
import com.example.bbip_clone.ui.theme.button2_m16
import com.example.bbip_clone.ui.theme.caption2_m12
import com.example.bbip_clone.ui.theme.certification
import com.example.bbip_clone.ui.theme.emptyContent
import com.example.bbip_clone.ui.theme.invite
import com.example.bbip_clone.ui.theme.place

@Composable
fun RoundedBackgroundText(
    thisWeek: String,
    textStyle: TextStyle,
    textColor: Color,
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .background(backgroundColor, CircleShape)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = thisWeek,
            style = textStyle,
            color = textColor,
        )
    }
}

@Composable
fun WeekInfo(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.size(16.dp),
            tint = Gray6
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            style = caption2_m12,
            color = Gray2
        )
    }
}

@Composable
fun StudyOptions(icon: Int, optionText: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(bounded = false, radius = 50.dp)
        ) {
            when (optionText) {
                certification -> Log.d("testt", certification)
                place -> Log.d("testt", place)
                archive -> Log.d("testt", archive)
            }
        }
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = optionText,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = optionText,
            style = button2_m16
        )
    }
}

@Composable
fun WeekActivityCard(activity: StudyWeekData, thisWeekRound: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MainWhite, RoundedCornerShape(12.dp))
            .padding(start = 18.dp, top = 15.dp, end = 18.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(if (activity.round == thisWeekRound) PrimaryDark else Gray3),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = activity.round,
                style = body1_sb16,
                color = if (activity.round == thisWeekRound) MainWhite else MainBlack,
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = activity.content.ifEmpty { emptyContent },
                style = body1_sb16,
                color = if (activity.content.isEmpty()) Gray5 else MainBlack,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = convertNumberToDate(activity.date),
                style = caption2_m12,
                color = Gray6
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
fun TeamMemberCard(member: TeamMember) {
    Column(
        modifier = Modifier
            .size(90.dp, 100.dp)
            .shadow(16.dp, RoundedCornerShape(12.dp), spotColor = Gray2)
            .background(MainWhite, RoundedCornerShape(12.dp))
            .clickable { },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = member.imageRes),
            contentDescription = member.name,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = member.name,
            style = body2_m14,
            color = MainBlack
        )
        Spacer(Modifier.height(3.dp))
        Text(
            text = member.role,
            style = caption2_m12,
            color = Gray6
        )
    }
    Spacer(Modifier.width(8.dp))
}

@Composable
fun InviteButton() {
    Column(
        modifier = Modifier
            .size(90.dp, 100.dp)
            .shadow(16.dp, RoundedCornerShape(12.dp), spotColor = Gray2)
            .background(Gray3, RoundedCornerShape(12.dp))
            .clickable { },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Gray6),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = addIcon,
                contentDescription = invite,
                tint = MainWhite
            )
        }
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = invite,
            style = body2_m14,
            color = Gray7
        )
    }
}


@Composable
fun NoticeBar(
    noticeText: String,
    noticeCheck: Boolean,
    contentColor: Color = Gray8,
    backgroundColor: Color = Gray2
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(vertical = 22.dp)
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = "공지",
                style = body1_sb16,
                color = PrimaryDark,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.5.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(
                            bounded = false,
                            radius = 14.dp,
                            color = PrimaryDark
                        ),
                        onClick = {}
                    )
            )

            if (noticeCheck) {
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .background(PrimaryDark, CircleShape)
                        .align(Alignment.TopEnd)
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = noticeText,
            style = body2_m14,
            color = contentColor
        )
    }
}
@Composable
fun TimeRing(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
    ) {
        val outCircleRadius = size.width / 2
        val inCircleRadius = outCircleRadius * 0.83f
        val strokeWidth = outCircleRadius * 0.08f
        val center = Offset(size.width / 2, size.height / 2)

        drawCircle(
            color = Gray8,
            center = center,
            radius = outCircleRadius
        )

        drawCircle(
            color = Gray5,
            center = center,
            radius = inCircleRadius,
            style = Stroke(width = strokeWidth)
        )
    }
}