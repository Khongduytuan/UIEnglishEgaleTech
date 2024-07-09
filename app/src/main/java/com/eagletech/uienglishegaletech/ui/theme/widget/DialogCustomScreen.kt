package com.eagletech.uienglishegaletech.ui.theme.widget


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.eagletech.uienglishegaletech.R
import com.eagletech.uienglishegaletech.ui.theme.Color111245
import com.eagletech.uienglishegaletech.ui.theme.Color9E3332
import com.eagletech.uienglishegaletech.ui.theme.ColorD54646
import com.eagletech.uienglishegaletech.ui.theme.ColorF2564D
import com.eagletech.uienglishegaletech.ui.theme.ColorFF9064
import com.eagletech.uienglishegaletech.ui.theme.ColorFFFFFF
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme
import com.eagletech.uienglishegaletech.ui.theme.onboarding.TextUi
import com.eagletech.uienglishegaletech.ui.theme.screens.ButtonItem
import kotlinx.coroutines.launch

/*

This example demonstrates how to make custom dialog in android jetpack compose in android.

*  Button        : https://www.boltuix.com/2021/12/button_25.html
*  Clip Modifier : https://www.boltuix.com/2021/12/clip-modifier_24.html
*  Alert Dialog  : https://www.boltuix.com/2021/12/alert-dialog_25.html
*  Column        : https://www.boltuix.com/2021/12/column-layout_25.html
*  Box           : https://www.boltuix.com/2021/12/box-layout_25.html
*  Type.kt       : https://www.boltuix.com/2021/12/typography_27.html
*  Color.kt      : https://www.boltuix.com/2022/05/google-material-design-color.html
* */

@Composable
fun InfoDialog(
    title: String?="Message",
    desc: String?="Your Message",
    onDismiss: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Dialog(
        onDismissRequest = onDismiss
    ) {

        Box(
            modifier = Modifier
                .height(screenHeight / 2)
                .padding(5.dp)
        ) {

            Column(
                modifier = Modifier
            ) {
                Spacer(modifier = Modifier.height(screenHeight/6))
                Box(
                    modifier = Modifier.padding(10.dp,0.dp,10.dp,0.dp)
                        .height((screenHeight*3)/5)
                        .background(

                            color = ColorFFFFFF,
                            shape = RoundedCornerShape(25.dp, 25.dp, 25.dp, 25.dp)
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .align(alignment = Alignment.TopEnd)
                            .offset(x = 25.dp, y = -25.dp)

                    ) {
                        HeaderImage(modifier = Modifier.fillMaxSize())
                    }
                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Có lỗi",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.displayMedium
                            ,   color = Color111245,
                        )
                        Spacer(modifier = Modifier.height(8.dp))


                        Text(
                            text = "Thông tin đăng nhập của bạn \n  không đúng. Vui lòng kiểm tra số \n điện thoại / mật khẩu và thử lại.",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp, start = 0.dp, end = 0.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color111245,
                        )
                        Spacer(modifier = Modifier.height(24.dp))

                        val gradientButtonLogin = Brush.horizontalGradient(
                            colors = listOf(
                                ColorD54646,
                                ColorFF9064
                            )
                        )
                        ButtonItem(
                            nameButton = "Thử lại",
                            textColor = Color.White,
                            gradient = gradientButtonLogin,
                            shadowColor = Color9E3332,
                            shadowBottomOffset = 8f,
                            onClick = {}
                        )



                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }

            }

        }
    }
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.exit),
        contentDescription = "Back",
        modifier = modifier
    )
}

@Preview
@Composable
fun ViewDialog(){
    UIEnglishEgaleTechTheme {
        InfoDialog {

        }
    }
}
