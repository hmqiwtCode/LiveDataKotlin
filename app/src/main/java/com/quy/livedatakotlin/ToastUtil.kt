package com.quy.livedatakotlin

import android.content.Context
import android.widget.Toast

object ToastUtil {
    fun show(context: Context?, message: String) {
        if (context == null) return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}