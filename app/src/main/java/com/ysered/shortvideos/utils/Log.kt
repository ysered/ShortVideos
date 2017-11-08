package com.ysered.shortvideos.utils

import android.util.Log


fun Any.debug(text: String, t: Throwable? = null) {
    Log.d(this::class.java.simpleName, text, t)
}

fun debug(text: String, t: Throwable? = null) {
    Log.d("", text, t)
}

fun Any.info(text: String, t: Throwable? = null) {
    Log.i(this::class.java.simpleName, text, t)
}

fun info(text: String, t: Throwable? = null) {
    Log.i("", text, t)
}

fun Any.warn(text: String, t: Throwable? = null) {
    Log.w(this::class.java.simpleName, text, t)
}

fun Any.error(text: String?, t: Throwable? = null) {
    Log.e(this::class.java.simpleName, text, t)
}
