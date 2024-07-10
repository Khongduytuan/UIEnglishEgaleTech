package com.eagletech.uienglishegaletech.ui.theme.screens.signUp

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.eagletech.uienglishegaletech.R
import com.eagletech.uienglishegaletech.ui.theme.Color282BA0
import com.eagletech.uienglishegaletech.ui.theme.Color4553B7
import com.eagletech.uienglishegaletech.ui.theme.Color78799C
import com.eagletech.uienglishegaletech.ui.theme.ColorFFFFFF
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme
import com.eagletech.uienglishegaletech.ui.theme.widget.OutlinedOtpTextField
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp03(
    modifier: Modifier = Modifier,
    numberPhone: String,
) {

    Scaffold(
        topBar = {
            TopAppBarItem(
                titleTopBar = "Xác thực OTP",
                isBorderBottom = true,
                onClick = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(top = 60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(80.dp)
            )
            Text(
                text = "Mã 6 số đã được gửi đến $numberPhone. Hãy điền chúng vào đây",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontFamily = FontFamily(Font(R.font.nunito_extrabold))
                ),
                modifier = modifier.padding(horizontal = 24.dp)
            )
            var valueOTP by rememberSaveable {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedOtpTextField(
                value = valueOTP,
                onValueChange = { it ->
                    valueOTP = it
                },
                requestFocus = true,
                clearFocusWhenFilled = true
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = modifier.padding(horizontal = 18.dp),
                text = "Nếu không nhận được bạn có thể yêu cầu gửi lại trong vòng : 00:59 giây",
                style = MaterialTheme
                    .typography.titleMedium.copy(
                        lineHeight = 17.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_medium))
                        ),
                color = Color78799C
            )


        }

    }

}

@Composable
fun RowRefreshItem(modifier: Modifier = Modifier) {

    Row(modifier = modifier) {
        Text(text = "Gửi lại", )
    }
    
}
@Preview(name = "TopAppBarItemPreview", showBackground = true, showSystemUi = true)
@Composable
fun TopAppBarItemPreview(modifier: Modifier = Modifier) {
    UIEnglishEgaleTechTheme {
        TopAppBarItem(titleTopBar = "Hello", isBorderBottom = true) {
        }
    }
}


@Composable
fun TopAppBarItem(
    modifier: Modifier = Modifier,
    titleTopBar: String? = null,
    isBorderBottom: Boolean = false,
    onClick: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color4553B7)
            .padding(top = 20.dp)
    ) {
        val (buttonBack, title, borderBottom) = createRefs()
        IconButton(
            onClick = { onClick },
            modifier = modifier.constrainAs(buttonBack) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.button_back),
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                contentDescription = "Button Back"
            )
        }
        titleTopBar?.let {
            Text(
                text = titleTopBar,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 18.sp,
                    lineHeight = 19.sp
                ),
                color = ColorFFFFFF,
                modifier = modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
        if (isBorderBottom)
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color282BA0)
                .constrainAs(borderBottom) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

    }

}

@Preview(name = "SignUp03Preview", showBackground = true, showSystemUi = true)
@Composable
fun SignUp03Preview(modifier: Modifier = Modifier) {
    UIEnglishEgaleTechTheme {
        SignUp03(numberPhone = "0983655632")
    }

}