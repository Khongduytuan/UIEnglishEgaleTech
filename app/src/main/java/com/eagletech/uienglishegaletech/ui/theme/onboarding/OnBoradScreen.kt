package com.eagletech.uienglishegaletech.ui.theme.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.eagletech.uienglishegaletech.ui.theme.Color111245
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme



@Composable
fun OnBoardingView(
    modifier: Modifier = Modifier,
    imageBroad: String,
    nameBoard: String,
    contentBoard: String,
) {
    val context = LocalContext.current

    // Chuyển đổi imageBroad thành resource id
    val imageResourceId = context.resources.getIdentifier(imageBroad, "drawable", context.packageName)

    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(0.dp, 30.dp, 0.dp, 30.dp),

    ) {
        val (imageBoardId, nameBoardId, contentBoardId) = createRefs()
        val guideline =  createGuidelineFromTop(0.5f)
        // Image
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = "imageBoardView",
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .aspectRatio(1f)
                .clip(shape = CircleShape)
                .border(width = 2.dp, color = Color.White)
                .constrainAs(imageBoardId) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    bottom.linkTo(nameBoardId.top, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    width = Dimension.wrapContent // Đảm bảo chiều rộng phù hợp với nội dung
                    height = Dimension.wrapContent
                }
        )


        // Name Board Text
        Text(
            modifier = Modifier
                .constrainAs(nameBoardId) {
                    top.linkTo(guideline, margin = 16.dp)
                    bottom.linkTo(contentBoardId.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
            text = nameBoard,
            style = MaterialTheme.typography.displayLarge, color = Color111245,
            maxLines = 2
        )

        // Content Board Text
        Text(
            modifier = Modifier
                .constrainAs(contentBoardId) {
                    top.linkTo(nameBoardId.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 30.dp)
                    end.linkTo(parent.end, margin = 30.dp)
                }
                .padding(30.dp, 15.dp, 30.dp, 20.dp),
            text = contentBoard,
            style = MaterialTheme.typography.bodyLarge,  color = Color111245,
            maxLines = 3
        )





    }
}

@Preview
@Composable
fun PreviewOnBoardingView() {
    UIEnglishEgaleTechTheme {
        OnBoardingView(
            imageBroad = "illus",
            nameBoard = "Học tiếng Anh\n dễ dàng và thú vị",
            contentBoard = "Ups mang đến cho bạn những trò chơi giáo dục bổ ích và thú vị, giúp bạn học tiếng Anh dễ dàng hơn."
        )
    }
}


