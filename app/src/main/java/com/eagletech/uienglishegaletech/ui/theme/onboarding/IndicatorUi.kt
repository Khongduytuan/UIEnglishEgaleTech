package com.eagletech.uienglishegaletech.ui.theme.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eagletech.uienglishegaletech.ui.theme.Color464BD5
import com.eagletech.uienglishegaletech.ui.theme.ColorB8C9D3


@Composable
fun IndicatorUi(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color464BD5,
    unselectedColor:Color = ColorB8C9D3
) {
    Row (horizontalArrangement = Arrangement.spacedBy(5.dp)){
   repeat(pageSize){

       Box(modifier = Modifier.height(8.dp).width(if (it == currentPage) 16.dp else 8.dp)
           .clip(RoundedCornerShape(16.dp)).background(color = if(it==currentPage) selectedColor else unselectedColor))
   }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorUiPreView1(modifier: Modifier = Modifier) {
    IndicatorUi(pageSize = 4, currentPage = 0)
}

@Composable
fun IndicatorUiPreView2(modifier: Modifier = Modifier) {
    IndicatorUi(pageSize = 4, currentPage = 1)
}

@Composable
fun IndicatorUiPreView3(modifier: Modifier = Modifier) {
    IndicatorUi(pageSize = 4, currentPage = 2)
}

@Composable
fun IndicatorUiPreView4(modifier: Modifier = Modifier) {
    IndicatorUi(pageSize = 4, currentPage = 3)
}
