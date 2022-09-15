package com.example.countrynameandcodepickerjetpackcomposelib.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.countrynameandcodepickerjetpackcomposelib.theme.ThemeColors
import com.example.countrynameandcodepickerjetpackcomposelib.theme.fontFamily

@Composable
fun BaseTextComponent(
    modifier : Modifier,
    text : String,
    fontSize : Int = 14,
    color : Color = ThemeColors.textBaseColor,
    fontWeight: FontWeight = FontWeight.Light
) {

    Text(
        text = text,
        color = color,
        fontSize = fontSize.sp,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        textAlign = TextAlign.Center,
        modifier = modifier
    )

}