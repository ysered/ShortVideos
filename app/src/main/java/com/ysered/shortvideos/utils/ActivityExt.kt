@file:JvmName("ActivityUtils")

package com.ysered.shortvideos.utils

import android.app.Activity
import android.view.Surface


val Activity.rotationDegrees: Int
    get() {
        return when (windowManager.defaultDisplay.rotation) {
            Surface.ROTATION_0 -> 0
            Surface.ROTATION_90 -> 90
            Surface.ROTATION_180 -> 180
            Surface.ROTATION_270 -> 270
            else -> 0
        }
    }
