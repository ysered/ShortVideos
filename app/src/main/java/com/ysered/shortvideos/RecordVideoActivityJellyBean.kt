@file:Suppress("DEPRECATION")

package com.ysered.shortvideos

import android.hardware.Camera
import android.os.Bundle
import android.view.SurfaceHolder
import com.ysered.shortvideos.utils.getBackCameraId
import kotlinx.android.synthetic.main.activity_record_video.*


class RecordVideoActivityJellyBean : BaseRecordVideoActivity(), SurfaceHolder.Callback {

    private var camera: Camera? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        surfaceView.holder.apply {
            addCallback(this@RecordVideoActivityJellyBean)
            setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
        }

        camera = Camera.open(getBackCameraId())
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder?) {
        camera?.apply {
            setPreviewDisplay(surfaceHolder)
            startPreview()
        }
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder?, format: Int, width: Int, height: Int) = Unit

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder?) {
        camera?.apply {
            stopPreview()
            release()
        }
    }
}
