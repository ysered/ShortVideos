@file:Suppress("DEPRECATION")

package com.ysered.shortvideos

import android.hardware.Camera
import android.os.Bundle
import android.view.SurfaceHolder
import com.ysered.shortvideos.utils.rotationDegrees
import com.ysered.shortvideos.utils.setDisplayOrientation
import kotlinx.android.synthetic.main.activity_record_video.*


class RecordVideoActivityJellyBean : BaseRecordVideoActivity(), SurfaceHolder.Callback {

    private var camera: Camera? = null
    private var currentCameraId = Camera.CameraInfo.CAMERA_FACING_BACK
    private var isPreviewing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        surfaceView.holder.apply {
            addCallback(this@RecordVideoActivityJellyBean)
            setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
        }

        switchCameraButton.setOnClickListener {
            restartPreview(isSwitch = true)
            showPreview(surfaceView.holder)
        }

        restartPreview()
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder?) {
        showPreview(surfaceHolder)
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder?, format: Int, width: Int, height: Int) = Unit

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder?) {
        camera?.apply {
            stopPreview()
            release()
        }
    }

    private fun showPreview(surfaceHolder: SurfaceHolder?) {
        camera?.apply {
            setPreviewDisplay(surfaceHolder)
            startPreview()
            isPreviewing = true
        }
    }

    private fun restartPreview(isSwitch: Boolean = false) {
        if (isSwitch) {
            currentCameraId = if (currentCameraId == Camera.CameraInfo.CAMERA_FACING_BACK)
                Camera.CameraInfo.CAMERA_FACING_FRONT
            else
                Camera.CameraInfo.CAMERA_FACING_BACK
        }
        camera?.apply {
            if (isPreviewing)
                stopPreview()
            release()
        }
        camera = Camera.open(currentCameraId).apply {
            setDisplayOrientation(currentCameraId, rotationDegrees)
        }
    }

    private fun switchCameraId() {

    }
}
