package com.example.bbip_clone.ui

import android.annotation.SuppressLint
import android.graphics.BlurMaskFilter
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.R
import com.example.bbip_clone.navigation.TabScreen
import com.example.bbip_clone.ui.theme.Gray4
import com.example.bbip_clone.ui.theme.MainBlack

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun TabBarScreen(navController: NavController, screens: List<TabScreen>, currentRoute: String) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(R.drawable.tabbar_center),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 60.dp)
                .shadow(8.dp, RoundedCornerShape(100)),
            contentScale = ContentScale.FillBounds
        )
        CustomTabBar()
        TabRow(
            selectedTabIndex = screens.indexOfFirst { it.route == currentRoute },
            containerColor = Color.Transparent,
            indicator = {},
            divider = {}
        ) {
            screens.forEachIndexed { index, screen ->
                val isSelected = screen.route == currentRoute
                Tab(
                    modifier = Modifier.height(89.dp),
                    selected = isSelected,
                    onClick = { navController.navigate(screen.route) },
                    enabled = false,
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) { navController.navigate(screen.route) },
                            imageVector = screen.icon,
                            contentDescription = null,
                            tint = if (isSelected) MainBlack else Gray4
                        )
                    }
                )
                if (index < screens.size - 1) {
                    Spacer(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun CustomTabBar() {
    val firstDpToFloat = dpToFloat(70.dp)
    val secondDpToFloat = dpToFloat(40.dp)

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(89.dp)
    ) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width * 0.5f - firstDpToFloat, 0f)
            lineTo(0f, 0f)
            lineTo(0f, height)
            lineTo(width, height)
            lineTo(width, 0f)
            lineTo(width * 0.5f + firstDpToFloat, 0f)

            cubicTo(
                width * 0.5f + secondDpToFloat, height * 0f,
                width * 0.5f + secondDpToFloat, height * 0.4f,
                width * 0.5f, height * 0.4f
            )
            cubicTo(
                width * 0.5f - secondDpToFloat, height * 0.4f,
                width * 0.5f - secondDpToFloat, height * 0f,
                width * 0.5f - firstDpToFloat, height * 0
            )
            close()
        }

        drawIntoCanvas { canvas ->
            val paint = android.graphics.Paint().apply {
                color = 0x40000000
                isAntiAlias = true
                maskFilter = BlurMaskFilter(15f, BlurMaskFilter.Blur.NORMAL)
            }
            canvas.nativeCanvas.drawPath(path.asAndroidPath(), paint)
        }

        drawPath(
            path = path,
            color = Color.White
        )
    }
}

@Composable
fun dpToFloat(value: Dp): Float {
    val density = LocalDensity.current
    return with(density) { value.toPx() }
}

@Preview(showBackground = true)
@Composable
fun TabPreview() {
    TabBarScreen(
        rememberNavController(),
        listOf(TabScreen.Home, TabScreen.Study),
        TabScreen.Home.route
    )
}