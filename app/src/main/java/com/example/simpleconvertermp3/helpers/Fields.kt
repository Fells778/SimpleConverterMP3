package com.example.simpleconvertermp3.helpers

import android.content.Context
import android.widget.EditText
import com.example.simpleconvertermp3.R
import java.net.URL

class Fields {

    fun emptyField(editText: EditText, context: Context): Boolean {
        return if (editText.text!!.isEmpty()) {
            editText.error = context.getString(R.string.empty_field_url)
            editText.requestFocus()
            false
        } else {
            true
        }
    }

    fun isYoutubeUrl(editText: EditText, context: Context): Boolean{
        return try {
            val url = URL(editText.text.toString())
            val host = url.host
            host.endsWith("youtube.com") || host.endsWith("youtube.be")
        }catch (exception: Exception){
            editText.error = context.getString(R.string.is_valid_url)
            editText.requestFocus()
            println("=== $exception ====")
            false
        }
    }
}