package com.example.countrynameandcodepickerjetpackcomposelib

import android.content.Context
import android.widget.Toast

class ToasterMessage {

    companion object {
        fun showMessage(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

}