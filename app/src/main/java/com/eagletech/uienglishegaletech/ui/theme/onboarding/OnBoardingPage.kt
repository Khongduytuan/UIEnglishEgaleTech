package com.eagletech.uienglishegaletech.ui.theme.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eagletech.uienglishegaletech.ui.theme.ColorF2564D
import kotlinx.coroutines.launch


data class OnBoardingPage(
    val imageBroad: String,
    val nameBoard: String,
    val contentBoard: String
)

val onBoardingPages = listOf(
    OnBoardingPage(
        imageBroad = "illus",
        nameBoard = "Học tiếng Anh\n"
                + "dễ dàng và thú vị",
        contentBoard = "Ups mang đến cho bạn những trò chơi giáo dục bổ ích và thú vị, giúp bạn học tiếng Anh dễ dàng hơn."
    ),
    OnBoardingPage(
        imageBroad = "illus2",
        nameBoard = "Luyện tập từ ngữ \n"
                + "& ngữ pháp",
        contentBoard = "Không chỉ có những trò chơi bổ ích, Ups còn cho bạn học vững chắc ngữ pháp & bổ sung vốn từ vựng."
    ),
    OnBoardingPage(
        imageBroad = "illus3",
        nameBoard = "Thi Tiếng Anh \n"
                + "online",
        contentBoard = "Làm bài thi và nhận chứng chỉ online cho những bài thi tiếng Anh của mình qua Ups."
    ),
    OnBoardingPage(
        imageBroad = "illus4",
        nameBoard = "Tham gia chơi &\n"
                + " học cùng bạn bè",
        contentBoard = "Ups mang đến cho bạn những trò chơi giáo dục bổ ích và thú vị, giúp bạn học tiếng Anh dễ dàng hơn."
    )
)


@SuppressLint("UnsafeOptInUsageError", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable

fun ListOnBoardScreen(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = {
        onBoardingPages.size
    })

    val textState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("BỎ QUA", "TIẾP")
                1 -> listOf("BỎ QUA", "TIẾP")
                2 -> listOf("BỎ QUA", "TIẾP")
                3 -> listOf("", "BẮT ĐẦU")
                else -> listOf("", "")
            }
        }
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (textState.value[0].isNotEmpty()) {
                        TextUi(
                            text = textState.value[0],
                            backgroundColor = Color.Transparent,
                            textColor = ColorF2564D
                        ) {
                            scope.launch {
                                if (pagerState.currentPage > 0) {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    IndicatorUi(
                        pageSize = onBoardingPages.size,
                        currentPage = pagerState.currentPage
                    )
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    TextUi(
                        text = textState.value[1],
                        backgroundColor = MaterialTheme.colorScheme.primary,
                        textColor = ColorF2564D
                    ) {
                        scope.launch {
                            if (pagerState.currentPage < onBoardingPages.size - 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            } else {
//                                onFinished()
                            }
                        }
                    }
                }
            }
        }
    ) {
        HorizontalPager(state = pagerState) { page ->
            val currentPage = onBoardingPages[page]
            OnBoardingView(
                imageBroad = currentPage.imageBroad,
                nameBoard = currentPage.nameBoard,
                contentBoard = currentPage.contentBoard
            )
        }
    }


}



