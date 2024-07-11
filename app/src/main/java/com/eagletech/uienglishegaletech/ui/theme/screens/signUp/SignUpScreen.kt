package com.eagletech.uienglishegaletech.ui.theme.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.eagletech.uienglishegaletech.R
import com.eagletech.uienglishegaletech.ui.theme.Color111245
import com.eagletech.uienglishegaletech.ui.theme.Color4553B7
import com.eagletech.uienglishegaletech.ui.theme.Color9E3332
import com.eagletech.uienglishegaletech.ui.theme.ColorCFD0E4
import com.eagletech.uienglishegaletech.ui.theme.ColorD54646
import com.eagletech.uienglishegaletech.ui.theme.ColorFF9064
import com.eagletech.uienglishegaletech.ui.theme.ColorFFFFFF
import com.eagletech.uienglishegaletech.ui.theme.screens.ButtonItem
import com.eagletech.uienglishegaletech.ui.theme.widget.InputOutlineText
import com.eagletech.uienglishegaletech.ui.theme.widget.TopAppBarItem
import com.eagletech.uienglishegaletech.utitilListener.rememberImeState


@Composable
fun SignUpScreen(modifier: Modifier = Modifier,navController: NavController) {
    val isImeVisible by rememberImeState()
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val (buttonBack, titleSignup, desSdt, takeNote,buttonNext) = createRefs()
        val guideline = createGuidelineFromTop(0.5f)
        var isButtonVisible by remember { mutableStateOf(false) }
        Box(modifier = modifier
            .constrainAs(buttonBack) {
                top.linkTo(parent.top)
                bottom.linkTo(titleSignup.top)
                start.linkTo(parent.start)


            }
            .fillMaxWidth()
            .fillMaxHeight(if (isImeVisible) 0.0f else 0.15f)){

            TopAppBarItem(
                titleTopBar = "",
                isBorderBottom = false,
                isShowButtonBack = true,
                isShowButtonNext = false,
                onClick = {navController.navigate("screen1")},
                onClickNextButton = {}

            )
        }


        Text(
            modifier = modifier
                .constrainAs(titleSignup) {
                    top.linkTo(buttonBack.bottom, margin = 200.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    width = Dimension.fillToConstraints
                }, textAlign = TextAlign.Center,
            text = "Để đăng ký, hãy điền số điện thoại của bạn.",
            style = MaterialTheme.typography.displayMedium.copy(fontSize = 30.sp), color = ColorFFFFFF,
            maxLines = 2
        )
        var value by remember {
            mutableStateOf("")
        }
        InputOutlineText(value = value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            isCentered = true,
            hintText = " Số điện thoại",
            cursorColor = Color111245,
            textAlign = TextAlign.Center,

            modifier = modifier.constrainAs(desSdt) {
                top.linkTo(titleSignup.bottom, margin = 20.dp)
                start.linkTo(parent.start, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
                width = Dimension.fillToConstraints

            }, onValueChange = {
                value = it
                isButtonVisible = it.isNotBlank()

            })

        Text(
            modifier = modifier
                .padding(20.dp)
                .constrainAs(takeNote) {
                    top.linkTo(desSdt.bottom, margin = 16.dp)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start, margin = 16.dp)

                }, textAlign = TextAlign.Center,
            text = "Nhớ rằng - không bao giờ đăng ký bằng số điện thoại của người khác.",
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 15.sp), color = ColorCFD0E4,
            maxLines = 2
        )
        val gradientButtonLogin = Brush.horizontalGradient(
            colors = listOf(
                ColorD54646,
                ColorFF9064
            )
        )
        if(isButtonVisible){
            ButtonItem(
                nameButton = "Tiếp tục",
                textColor = Color.White,
                gradient = gradientButtonLogin,
                shadowColor = Color9E3332,
                shadowBottomOffset = 8f,

                modifier = Modifier.constrainAs(buttonNext) {
                    top.linkTo(takeNote.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }, onClick = {}
            )
        }

    }
}
