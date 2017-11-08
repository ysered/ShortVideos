package com.ysered.shortvideos

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.hardware.camera2.CameraDevice
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.SurfaceHolder
import com.ysered.shortvideos.utils.backCameraId
import com.ysered.shortvideos.utils.cameraManager
import kotlinx.android.synthetic.main.activity_record_video.*


@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@SuppressLint("MissingPermission")
class RecordVideoActivityLollipop : BaseRecordVideoActivity(), SurfaceHolder.Callback {

    private var isRecording = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_video)

        surfaceView.holder.addCallback(this)

        stopButton.setOnClickListener {
            stopMediaRecorder()
        }
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder?) {
        cameraManager.openCamera(backCameraId, object: CameraDevice.StateCallback() {
            override fun onOpened(cameraDevice: CameraDevice?) {

            }

            override fun onDisconnected(cameraDevice: CameraDevice?) {

            }

            override fun onError(cameraDevice: CameraDevice?, error: Int) {

            }
        }, Handler(Looper.getMainLooper()))
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder?, format: Int, width: Int, height: Int) = Unit

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder?) {
        stopMediaRecorder()
    }

    private fun stopMediaRecorder() {
        if (isRecording) {
            mediaRecorder.stop()
            isRecording = false
            mediaRecorder.release()
        }
        finish()
    }
}
