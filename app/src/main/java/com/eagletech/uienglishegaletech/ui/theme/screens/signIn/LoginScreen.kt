package com.eagletech.uienglishegaletech.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import com.eagletech.uienglishegaletech.R
import com.eagletech.uienglishegaletech.ui.theme.Color111245
import com.eagletech.uienglishegaletech.ui.theme.Color1D2145
import com.eagletech.uienglishegaletech.ui.theme.Color20227E
import com.eagletech.uienglishegaletech.ui.theme.Color242956
import com.eagletech.uienglishegaletech.ui.theme.Color78799C
import com.eagletech.uienglishegaletech.ui.theme.Color9E3332
import com.eagletech.uienglishegaletech.ui.theme.ColorD54646
import com.eagletech.uienglishegaletech.ui.theme.ColorE8E9F5
import com.eagletech.uienglishegaletech.ui.theme.ColorF2564D
import com.eagletech.uienglishegaletech.ui.theme.ColorFF9064
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme
import com.eagletech.uienglishegaletech.ui.theme.widget.InputOutlineText
import com.eagletech.uienglishegaletech.utitilListener.rememberImeState

@Composable
fun LoginScreen(modifier: Modifier = Modifier,navController: NavController) {
    val density = LocalDensity.current
    val view = LocalView.current
    val configuration = LocalConfiguration.current
    val screenHeightPx = configuration.screenHeightDp.dp
    val screenHeightDp = with(density) { screenHeightPx.toPx() }
    var imeHeight by remember { mutableStateOf(0.dp) }
    var isImeVisible by remember { mutableStateOf(false) }
    DisposableEffect(view) {
        val listener = ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val ime = insets.getInsets(WindowInsetsCompat.Type.ime())
            imeHeight = with(density) { ime.bottom.toDp() }
            isImeVisible = ime.bottom > 0
            insets
        }

        onDispose {
            ViewCompat.setOnApplyWindowInsetsListener(view, null)
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val (logoLogin,
            inputNumberPhone,
            inputPassword,
            buttonLogin,
            textRowActionApp,
            buttonNewAcc,
            textRowInfo
        ) = createRefs()
        // size logo
        val sizeLogo = LocalConfiguration.current.screenWidthDp * 0.6
        // Guideline
        val topGuideline = createGuidelineFromTop(if (isImeVisible) 0f else 0.2f)
        val bottomGuideline = createGuidelineFromTop(if (isImeVisible) (screenHeightPx - imeHeight) else screenHeightPx)
        Box(modifier = modifier
            .constrainAs(logoLogin) {

                top.linkTo(topGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(inputNumberPhone.top)

            }
            .fillMaxWidth()
            .height(if (isImeVisible) 0.dp else (sizeLogo / 2).dp), contentAlignment = Alignment.Center){
            Image(
                painterResource(id = R.drawable.logo),
                contentDescription = "Logo app",

                modifier = Modifier
                    .size(height = (sizeLogo / 2).dp, width = sizeLogo.dp)
            )
        }


        var numberPhone by rememberSaveable {
            mutableStateOf("")
        }
        var password by rememberSaveable {
            mutableStateOf("")
        }

        InputOutlineText(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 4.dp)
                .constrainAs(inputNumberPhone) {
                    top.linkTo(logoLogin.bottom,  margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(inputPassword.top)
                    width = Dimension.fillToConstraints
                },
            hintText = "Số điện thoại tài khoản",
            value = numberPhone,
            icon = Icons.Default.Call,
            cursorColor = ColorF2564D,
            isCentered = false,
            textAlign = TextAlign.Start,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onValueChange = {
                numberPhone = it
            }
        )
        InputOutlineText(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 4.dp)
                .constrainAs(inputPassword) {
                    top.linkTo(inputNumberPhone.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(buttonLogin.top)
                    width = Dimension.fillToConstraints
                },
            hintText = "Mật khẩu",
            icon = Icons.Default.Lock,
            value = password,
            cursorColor = ColorF2564D,
            isCentered = false,

            textAlign = TextAlign.Start,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                password = it
            }
        )

        val gradientButtonLogin = Brush.horizontalGradient(
            colors = listOf(
                ColorD54646,
                ColorFF9064
            )
        )
        val gradientButtonNewAcc = Brush.horizontalGradient(
            colors = listOf(
                Color242956,
                Color242956
            )
        )

        ButtonItem(
            nameButton = "Đăng nhập",
            textColor = Color.White,
            gradient = gradientButtonLogin,
            shadowColor = Color9E3332,
            shadowBottomOffset = 8f,
            modifier = Modifier.constrainAs(buttonLogin) {
                top.linkTo(inputPassword.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }, onClick = {}
        )

        RowTextAction(
            modifier = Modifier.constrainAs(textRowActionApp) {
                top.linkTo(buttonLogin.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            textForgetPass = "Quên mật khẩu?",
            textSearchResult = "Tra cứu kết quả >",
            lineText2 = 1,
            lineText1 = 1,
            onClickTextForgetPass = {},
            onClickTextSearchResult = {},
            textStyle = MaterialTheme
                .typography
                .displaySmall
                .copy(color = Color.White)
        )

        ButtonItem(
            nameButton = "Tài khoản mới",
            textColor = Color.White,
            gradient = gradientButtonNewAcc,
            shadowColor = Color1D2145,
            shadowBottomOffset = 8f,
            onClick = { navController.navigate("screen1")},
            modifier = Modifier.constrainAs(buttonNewAcc) {

                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(textRowInfo.top)

            }
        )

        // text info app
        RowTextInfo(
            textForgetPass = "Hotline liên hệ: 098611263",
            textSearchResult = "Website: ups.edu.vn",
            lineText2 = 1,
            lineText1 = 2,
            textStyle = MaterialTheme.typography.labelSmall.copy(color = Color.White.copy(0.8f)),
            onClickTextForgetPass = {},
            onClickTextSearchResult = {},
            modifier = Modifier.constrainAs(textRowInfo) {
                bottom.linkTo(bottomGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )


    }
}

//@Composable
//fun LoginScreen2(modifier: Modifier = Modifier, scrollState: ScrollState) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .verticalScroll(scrollState)
//            .paint(
//                painterResource(id = R.drawable.background),
//                contentScale = ContentScale.FillBounds
//            )
//            .padding(top = 200.dp)
//    ) {
//        // size logo
//        val sizeLogo = LocalConfiguration.current.screenWidthDp * 0.6
//
//        Image(
//            painterResource(id = R.drawable.logo),
//            contentDescription = "Logo app",
//            modifier = Modifier
//                .size(height = (sizeLogo / 2).dp, width = sizeLogo.dp)
//        )
//
//        var numberPhone by rememberSaveable {
//            mutableStateOf("")
//        }
//        var password by rememberSaveable {
//            mutableStateOf("")
//        }
//        InputOutlineText(
//            modifier = Modifier
//                .padding(horizontal = 24.dp, vertical = 4.dp),
//
//            hintText = "Số điện thoại tài khoản",
//            value = numberPhone,
//            icon = Icons.Default.Call,
//            cursorColor =ColorF2564D,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        ) {
//            numberPhone = it
//        }
//
//        InputOutlineText(
//            modifier = Modifier
//                .padding(horizontal = 24.dp, vertical = 4.dp),
//            hintText = "Mật khẩu",
//            icon = Icons.Default.Lock,
//            value = password,
//            cursorColor = ColorF2564D,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
//        ) {
//            password = it
//        }
//
//        val gradientButtonLogin = Brush.horizontalGradient(
//            colors = listOf(
//                ColorD54646,
//                ColorFF9064
//            )
//        )
//        val gradientButtonNewAcc = Brush.horizontalGradient(
//            colors = listOf(
//                Color242956,
//                Color242956
//            )
//        )
//
//        ButtonItem(
//            nameButton = "Đăng nhập",
//            textColor = Color.White,
//            gradient = gradientButtonLogin,
//            shadowColor = Color9E3332,
//            shadowBottomOffset = 8f,
//            onClick = {}
//        )
//
//        RowTextAction(
//            textForgetPass = "Quên mật khẩu?",
//            textSearchResult = "Tra cứu kết quả >",
//            lineText2 = 1,
//            lineText1 = 1,
//            onClickTextForgetPass = {},
//            onClickTextSearchResult = {},
//            textStyle = MaterialTheme
//                .typography
//                .displaySmall
//                .copy(color = Color.White)
//        )
//
//        ButtonItem(
//            nameButton = "Tài khoản mới",
//            textColor = Color.White,
//            gradient = gradientButtonNewAcc,
//            shadowColor = Color1D2145,
//            shadowBottomOffset = 8f,
//            onClick = {},
//        )
//        // text info app
//        RowTextInfo(
//            textForgetPass = "Hotline liên hệ: 098611263",
//            textSearchResult = "Website: ups.edu.vn",
//            lineText2 = 1,
//            lineText1 = 2,
//            textStyle = MaterialTheme.typography.labelSmall.copy(color = Color.White.copy(0.8f)),
//            onClickTextForgetPass = {},
//            onClickTextSearchResult = {},
//        )
//
//
//    }

//}

@Composable
fun RowTextAction(
    modifier: Modifier = Modifier,
    textForgetPass: String,
    textSearchResult: String,
    lineText1: Int,
    lineText2: Int,
    textStyle: TextStyle,
    onClickTextForgetPass: () -> Unit,
    onClickTextSearchResult: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        TextButton(onClick = { onClickTextForgetPass() }) {
            Text(
                text = textForgetPass,
                style = textStyle,
                maxLines = lineText1
            )
        }
        TextButton(onClick = { onClickTextSearchResult() }) {
            Text(
                text = textSearchResult,
                style = textStyle,
                maxLines = lineText2
            )
        }

    }
}

@Composable
fun RowTextInfo(
    modifier: Modifier = Modifier,
    textForgetPass: String,
    textSearchResult: String,
    lineText1: Int,
    lineText2: Int,
    textStyle: TextStyle,
    onClickTextForgetPass: () -> Unit,
    onClickTextSearchResult: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        TextButton(onClick = { onClickTextForgetPass() }) {
            Text(
                text = textForgetPass,
                style = textStyle,
                maxLines = lineText1,
                modifier = Modifier.width(120.dp)
            )
        }
        TextButton(onClick = { onClickTextSearchResult() }) {
            Text(
                text = textSearchResult,
                style = textStyle,
                maxLines = lineText2
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RowTextActionPreview(modifier: Modifier = Modifier) {
    UIEnglishEgaleTechTheme {
        RowTextAction(
            textForgetPass = "Hotline liên hệ: 098611263",
            textSearchResult = "Website: ups.edu.vn",
            lineText1 = 2,
            lineText2 = 1,
            textStyle = MaterialTheme.typography.titleSmall.copy(color = Color.Black),
            onClickTextForgetPass = {},
            onClickTextSearchResult = {}
        )
    }
}


@Composable
fun ButtonItem(
    modifier: Modifier = Modifier,
    nameButton: String,
    textColor: Color,
    gradient: Brush,
    shadowColor: Color,
    shadowBottomOffset: Float,
    buttonHeight: Float = 50f,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .background(color = shadowColor, shape = shape)
            .fillMaxWidth()
            .height(buttonHeight.dp + shadowBottomOffset.dp)
            .clickable {
                onClick()
            }
    ) {
        // Button
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = textColor
            ),
            modifier = modifier
                .padding(top = 1.dp, start = 1.dp, end = 1.dp)
                .background(gradient, shape = shape)
                .fillMaxWidth()
                .padding(top = 2.dp, start = 2.dp, end = 2.dp)
                .height(buttonHeight.dp)
        ) {
            Text(
                text = nameButton,
                style = MaterialTheme.typography.displayMedium.copy(
                    color = Color.White
                )
            )
        }


    }

}

@Composable
fun ButtonShadowOnlyBottom(
    modifier: Modifier = Modifier,
    nameButton: String,
    textColor: Color,
    gradient: Brush,
    shadowColor: Color,
    shadowBottomOffset: Float,
    buttonHeight: Float = 50f,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .height(buttonHeight.dp + shadowBottomOffset.dp)
    ) {
        // Shadow
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(
                    buttonHeight.dp + shadowBottomOffset.dp
                ),
            color = shadowColor,
            shape = shape
        ) {}

        // Button
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = textColor
            ),
            modifier = modifier
                .padding(top = 1.dp, start = 1.dp, end = 1.dp)
                .background(gradient, shape = shape)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 2.dp, start = 2.dp, end = 2.dp)
                .height(buttonHeight.dp)
        ) {
            Text(
                text = nameButton,
                style = MaterialTheme.typography.displayMedium.copy(
                    color = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonItemPreview(modifier: Modifier = Modifier) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            ColorD54646,
            ColorFF9064
        )
    )
    ButtonItem(
        nameButton = "Login",
        textColor = Color.White,
        gradient = gradient,
        shadowColor = Color9E3332,
        shadowBottomOffset = 8f,
        onClick = { }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewButtonLoginWithShadow2() {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            ColorD54646,
            ColorFF9064
        )
    )
    ButtonShadowOnlyBottom(
        nameButton = "Login",
        textColor = Color.White,
        gradient = gradient,
        shadowColor = Color9E3332,
        shadowBottomOffset = 8f,
        onClick = { }
    )
}




