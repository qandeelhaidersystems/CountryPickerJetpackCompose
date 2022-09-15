package com.example.countrynameandcodepickerjetpackcomposelib

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.countrynameandcodepickerjetpackcomposelib.data.CountryInfo
import com.example.countrynameandcodepickerjetpackcomposelib.data.GetAllCountries
import com.example.countrynameandcodepickerjetpackcomposelib.theme.ThemeColors

@Composable
fun CounterCodePickerDialog(
    modifier: Modifier,
    backgroundColor: Color,
    onDismiss: () -> Unit,
    onSelect: (CountryInfo) -> Unit
) {

    Dialog(
        onDismissRequest = {
            onDismiss.invoke()
        },

        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Surface(
            modifier = modifier.fillMaxSize(),
            shape = RoundedCornerShape(8.dp),
            color = backgroundColor
        ) {

            LazyColumn(
                modifier = modifier.fillMaxWidth().padding(top = 10.dp),
                contentPadding = PaddingValues(0.dp)
            ) {

                val countries = GetAllCountries()

                items(countries) { country ->

                    CountryCard(country){
                        onSelect.invoke(it)
                    }

                }
            }
        }
    }
}

@Composable
fun CountryCard(
    country: CountryInfo,
    onSelect: (CountryInfo) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ThemeColors.white)
            .clickable(
                onClick = {
                    onSelect.invoke(country)
                }
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        ) {

            Spacer(modifier = Modifier.padding(start = 10.dp, top = 10.dp))

            Image(painter = painterResource(id = country.flag), contentDescription = "")

            Spacer(modifier = Modifier.padding(start = 20.dp))

            BaseTextComponent(modifier = Modifier, text = country.fullName)

        }

        Spacer(modifier = Modifier.padding(top = 10.dp))

        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .height(1.dp)
                .background(ThemeColors.lightGray)
        )

    }

}

@Preview
@Composable
fun PreviewDialog() {

    CounterCodePickerDialog(
        modifier = Modifier,
        backgroundColor = ThemeColors.white,
        onDismiss = {

        },
        onSelect = {

        }
    )

}