@file:JvmName("FileUtils")

package com.ysered.shortvideos.utils

import android.os.Environment
import com.ysered.shortvideos.BuildConfig
import java.io.File


fun generateVideoFilePath(): String {
    val basePath = "${Environment.getExternalStorageDirectory().path}/${BuildConfig.APPLICATION_ID}"
    val videosFolder = File(basePath)
    if (!videosFolder.exists())
        videosFolder.mkdir()
    val fullPath = "$basePath/${System.currentTimeMillis()}.mp4"
    info("Video file path: $fullPath")
    return fullPath
}
