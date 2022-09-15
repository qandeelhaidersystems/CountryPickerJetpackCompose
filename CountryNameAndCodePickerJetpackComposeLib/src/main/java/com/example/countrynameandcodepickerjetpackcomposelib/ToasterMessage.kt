package com.example.countrynameandcodepickerjetpackcomposelib

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ToasterMessage {

    companion object {
        @Composable
        fun CountryCodeDialog() {

            Column {


            }

        }

        @Composable
        fun BaseButton(
            modifier: Modifier,
            text: String,
            enable: Boolean,
//            fontFamily: FontFamily,
            backgroundColor : Color = Color.Black,
            textColor: Color = Color.White,
            clicked : () -> Unit
        ) {

            Button(
                modifier = modifier,
                shape = RoundedCornerShape(10.dp),
                enabled = enable,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = backgroundColor,
                ),
                onClick = {
                    clicked.invoke()
                }) {

                Text(
                    text = text,
                    color = textColor,
                    fontSize = 14.sp,
//                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                )
            }

        }
    }
}