package com.example.countrynameandcodepickerjetpackcomposelib.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.countrynameandcodepickerjetpackcomposelib.data.CountryInfo
import com.example.countrynameandcodepickerjetpackcomposelib.theme.ThemeColors

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