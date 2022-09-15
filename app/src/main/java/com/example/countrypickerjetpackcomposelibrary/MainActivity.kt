package com.example.countrypickerjetpackcomposelibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrynameandcodepickerjetpackcomposelib.CounterCodePickerDialog
import com.example.countrynameandcodepickerjetpackcomposelib.theme.CountryPickerJetpackComposeLibraryTheme
import com.example.countrynameandcodepickerjetpackcomposelib.theme.ThemeColors

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryPickerJetpackComposeLibraryTheme {

                val openDialog = remember { mutableStateOf(false) }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {

                    BaseButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        text = "Register",
                        enable = true,
//                        fontFamily = fontFamily,
                        backgroundColor = ThemeColors.lightOrange,
                        textColor = ThemeColors.white
                    ) {
                        openDialog.value = true
                    }



                    if (openDialog.value) {
                        CounterCodePickerDialog(
                            modifier = Modifier,
                            backgroundColor = ThemeColors.white,
                            onDismiss = {
                                openDialog.value = false
                            },
                            onSelect = {
                                openDialog.value = false
                            }
                        )
                    }

                }
            }
        }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryPickerJetpackComposeLibraryTheme {

    }
}