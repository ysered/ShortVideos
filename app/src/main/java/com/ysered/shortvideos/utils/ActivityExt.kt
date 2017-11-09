@file:JvmName("ActivityUtils")

package com.ysered.shortvideos.utils

import android.app.Activity
import android.view.Surface


val Activity.rotationDegrees: Int
    get() {
        val rotation = windowManager.defaultDisplay.rotation
        return when (rotation) {
            Surface.ROTATION_0 -> 0
            Surface.ROTATION_90 -> 90
            Surface.ROTATION_180 -> 180
            Surface.ROTATION_270 -> 270
            else -> throw RuntimeException("rotation should be one of: 0, 90, 180 or 270, but actually was: $rotation")
        }
    }
