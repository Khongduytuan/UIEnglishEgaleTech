package com.eagletech.uienglishegaletech.ui.theme.widget

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eagletech.uienglishegaletech.ui.theme.UIEnglishEgaleTechTheme

@Composable
fun OutlineTextFieldWidgetItem(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(value = value, onValueChange = onValueChange)
}

@Composable
fun OutlineTextFieldWidgetItem(
    modifier: Modifier = Modifier,
    icon: Int? = null
) {

    var value by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(value = value, onValueChange = {
        value = it
    }, modifier = Modifier.height(50.dp).fillMaxWidth())

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OutlineTextFieldWidgetItemPreview(modifier: Modifier = Modifier) {
    UIEnglishEgaleTechTheme {
       OutlineTextFieldWidgetItem()
    }
}