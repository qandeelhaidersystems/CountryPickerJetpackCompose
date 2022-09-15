package com.example.countrynameandcodepickerjetpackcomposelib.data

import android.graphics.drawable.Drawable
import com.example.countrynameandcodepickerjetpackcomposelib.R

data class CountryInfo(
    var hint : String = "pk",
    var phoneCode : String = "+92",
    var fullName : String = "Pakistan",
    var flag : Int = R.drawable.pk
)