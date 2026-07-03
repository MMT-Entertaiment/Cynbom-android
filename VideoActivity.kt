package net.mmt_entertaiment.cynbom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.mmt.cynbom.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get video URL from intent
        val videoUrl = intent.getStringExtra("video_url") ?: return
        val serieTitle = intent.getStringExtra("serie_title") ?: ""

        // Initialize player
        player = ExoPlayer.Builder(this).build()
        binding.playerView.player = player

        // Load video
        val mediaItem = MediaItem.fromUri(videoUrl)
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}
