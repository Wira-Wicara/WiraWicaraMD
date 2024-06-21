package com.example.wirawicara

import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.wirawicara.R
import com.example.wirawicara.databinding.ActivityTrainBinding

class TrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrainBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadReferenceAudio()
        setClickListener()
    }

    private fun loadReferenceAudio() {
        mediaPlayer = MediaPlayer.create(this, R.raw.mobil_clear)
    }

    private fun playReferenceAudio() {
        mediaPlayer.start()
    }

    private fun setClickListener() {
        binding.btnPlay.setOnClickListener {
            playReferenceAudio()
        }
    }
}
