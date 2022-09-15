package com.example.countrypickerjetpackcomposelibrary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.countrynameandcodepickerjetpackcomposelib.CounterCodePickerDialog
import com.example.countrynameandcodepickerjetpackcomposelib.ToasterMessage
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

                    ToasterMessage.BaseButton(
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
                                Log.i("TAGSSSS", it.fullName)
                                openDialog.value = false

                            }
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryPickerJetpackComposeLibraryTheme {

    }
}