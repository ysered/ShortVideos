package com.ysered.shortvideos

import android.media.MediaRecorder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.SurfaceHolder
import com.ysered.shortvideos.utils.error
import com.ysered.shortvideos.utils.generateVideoFilePath
import kotlinx.android.synthetic.main.activity_record_video.*
import java.lang.Exception


class RecordVideoActivity : AppCompatActivity(), SurfaceHolder.Callback {

    private lateinit var mediaRecorder: MediaRecorder
    private var isRecording = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_video)

        surfaceView.holder.addCallback(this)

        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.CAMCORDER)
            setVideoSource(MediaRecorder.VideoSource.DEFAULT)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP)
            setOutputFile(generateVideoFilePath())
            setVideoFrameRate(30)
            setMaxDuration(3_000)
            setMaxFileSize(3_000_000)
        }

        stopButton.setOnClickListener {
            stopMediaRecorder()
        }
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder?) {
        surfaceHolder?.let {
            try {
                mediaRecorder.apply {
                    setPreviewDisplay(it.surface)
                    prepare()
                    start()
                    isRecording = true
                }
            } catch (e: Exception) {
                error("Cannot start media recorder", e)
                mediaRecorder.stop()
            }
        }
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
