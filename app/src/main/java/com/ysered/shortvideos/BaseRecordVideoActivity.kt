package com.ysered.shortvideos

import android.media.MediaRecorder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ysered.shortvideos.utils.generateVideoFilePath


open class BaseRecordVideoActivity : AppCompatActivity() {

    protected val mediaRecorder: MediaRecorder by lazy {
        MediaRecorder().apply {
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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_video)
    }
}
