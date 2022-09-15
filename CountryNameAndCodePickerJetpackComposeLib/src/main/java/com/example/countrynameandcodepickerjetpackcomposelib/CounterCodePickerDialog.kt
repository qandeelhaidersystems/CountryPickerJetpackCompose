package com.example.countrynameandcodepickerjetpackcomposelib

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.countrynameandcodepickerjetpackcomposelib.component.CountryCard
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