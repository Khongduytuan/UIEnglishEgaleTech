package com.eagletech.uienglishegaletech.ui.theme.screens

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.eagletech.uienglishegaletech.R
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme
import com.eagletech.uienglishegaletech.ui.theme.bolderInputColor
import com.eagletech.uienglishegaletech.ui.theme.buttonNewAccColor
import com.eagletech.uienglishegaletech.ui.theme.buttonShadowNewAccColor
import com.eagletech.uienglishegaletech.ui.theme.cursorColor
import com.eagletech.uienglishegaletech.ui.theme.firstButtonColor
import com.eagletech.uienglishegaletech.ui.theme.hintTextColor
import com.eagletech.uienglishegaletech.ui.theme.secondButtonColor
import com.eagletech.uienglishegaletech.ui.theme.shadowButtonGradientColor
import com.eagletech.uienglishegaletech.ui.theme.textInputColor
import com.eagletech.uienglishegaletech.ui.theme.tintIconColor

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
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
        val topGuideline = createGuidelineFromTop(0.2f)
        val bottomGuideline = createGuidelineFromTop(0.4f)
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "Logo app",
            modifier = Modifier
                .size(height = (sizeLogo / 2).dp, width = sizeLogo.dp)
                .constrainAs(logoLogin) {
                    top.linkTo(topGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(inputNumberPhone.top)
                })

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
                    top.linkTo(logoLogin.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(inputPassword.top)
                    width = Dimension.fillToConstraints
                },
            hintText = "Số điện thoại tài khoản",
            value = numberPhone,
            icon = Icons.Default.Call,
            cursorColor = cursorColor,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        ) {
            numberPhone = it
        }

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
            cursorColor = cursorColor,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        ) {
            password = it
        }

        val gradientButtonLogin = Brush.horizontalGradient(
            colors = listOf(
                firstButtonColor,
                secondButtonColor
            )
        )
        val gradientButtonNewAcc = Brush.horizontalGradient(
            colors = listOf(
                buttonNewAccColor,
                buttonNewAccColor
            )
        )

        ButtonItem(
            nameButton = "Đăng nhập",
            textColor = Color.White,
            gradient = gradientButtonLogin,
            shadowColor = shadowButtonGradientColor,
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
            shadowColor = buttonShadowNewAccColor,
            shadowBottomOffset = 8f,
            onClick = {},
            modifier = Modifier.constrainAs(buttonNewAcc) {
                bottom.linkTo(textRowInfo.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        )
        // text info app
        RowTextAction(
            textForgetPass = "Hotline liên hệ: 098611263",
            textSearchResult = "Website: ups.edu.vn",
            lineText2 = 1,
            lineText1 = 2,
            textStyle = MaterialTheme.typography.labelSmall.copy(color = Color.White.copy(0.8f)),
            onClickTextForgetPass = {},
            onClickTextSearchResult = {},
            modifier = Modifier.constrainAs(textRowInfo) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )


    }
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputOutlineText(
    modifier: Modifier = Modifier,
    value: String,
    keyboardOptions: KeyboardOptions,
    hintText: String,
    icon: ImageVector,
    cursorColor: Color,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .border(
                border = BorderStroke(1.dp, color = bolderInputColor.copy(0.2f)),
                shape = RoundedCornerShape(12.dp)
            ),
        textStyle = MaterialTheme.typography.titleSmall.copy(color = textInputColor),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        value = value,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            cursorColor = cursorColor
        ),
        onValueChange = onValueChange,
        shape = RoundedCornerShape(12.dp),
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = tintIconColor
            )
        },
        placeholder = {
            Text(
                text = hintText,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = hintTextColor
                )
            )
        }
    )
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
            firstButtonColor,
            secondButtonColor
        )
    )
    ButtonItem(
        nameButton = "Login",
        textColor = Color.White,
        gradient = gradient,
        shadowColor = shadowButtonGradientColor,
        shadowBottomOffset = 8f,
        onClick = { }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewButtonLoginWithShadow2() {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            firstButtonColor,
            secondButtonColor
        )
    )
    ButtonShadowOnlyBottom(
        nameButton = "Login",
        textColor = Color.White,
        gradient = gradient,
        shadowColor = shadowButtonGradientColor,
        shadowBottomOffset = 8f,
        onClick = { }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(modifier: Modifier = Modifier) {
    UIEnglishEgaleTechTheme {
        LoginScreen()
    }

}


