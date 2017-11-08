package com.ysered.shortvideos.utils

import android.hardware.Camera


fun getFrontCameraId(): Int =
        getCameraId(Camera.CameraInfo.CAMERA_FACING_FRONT)

fun getBackCameraId(): Int =
        getCameraId(Camera.CameraInfo.CAMERA_FACING_BACK)

private fun getCameraId(lensFacing: Int): Int {
    var cameraId = 0
    val cameraInfo = Camera.CameraInfo()
    for (index in 0 until Camera.getNumberOfCameras()) {
        Camera.getCameraInfo(index, cameraInfo)
        if (cameraInfo.facing == lensFacing) {
            cameraId = index
            break
        }
    }
    return cameraId
}
