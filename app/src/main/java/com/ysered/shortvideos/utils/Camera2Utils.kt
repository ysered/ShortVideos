package com.ysered.shortvideos.utils

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity


val AppCompatActivity.cameraManager: CameraManager
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getSystemService(Context.CAMERA_SERVICE) as CameraManager

val AppCompatActivity.frontCameraId: String?
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getCameraId(cameraManager, CameraCharacteristics.LENS_FACING_FRONT)

val AppCompatActivity.backCameraId: String?
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = getCameraId(cameraManager, CameraCharacteristics.LENS_FACING_BACK)

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
private fun getCameraId(cameraManager: CameraManager, lensFacing: Int): String? {
    for (cameraId in cameraManager.cameraIdList) {
        val specs = cameraManager.getCameraCharacteristics(cameraId)
        val orientation = specs.get(CameraCharacteristics.LENS_FACING)
        if (orientation == lensFacing)
            return cameraId
    }
    return null
}
