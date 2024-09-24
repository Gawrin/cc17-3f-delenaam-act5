package com.example.artspaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var artworkImage: ImageView
    private lateinit var artworkTitle: TextView
    private lateinit var artworkArtist: TextView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button

    private var currentArtworkIndex = 0
    private val artworks = listOf(
        Artwork(R.drawable.artwork1, R.string.artwork1_title, R.string.artwork1_artist),
        Artwork(R.drawable.artwork2, R.string.artwork2_title, R.string.artwork2_artist),
        Artwork(R.drawable.artwork3, R.string.artwork3_title, R.string.artwork3_artist),
        Artwork(R.drawable.artwork4, R.string.artwork4_title, R.string.artwork4_artist),
        Artwork(R.drawable.artwork5, R.string.artwork5_title, R.string.artwork5_artist)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artworkImage = findViewById(R.id.artworkImageView)
        artworkTitle = findViewById(R.id.titleTextView)
        artworkArtist = findViewById(R.id.artistTextView)
        previousButton = findViewById(R.id.prevButton)
        nextButton = findViewById(R.id.nextButton)

        updateArtwork()

        previousButton.setOnClickListener {
            currentArtworkIndex = (currentArtworkIndex - 1 + artworks.size) % artworks.size
            updateArtwork()
        }

        nextButton.setOnClickListener {
            currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
            updateArtwork()
        }
    }

    private fun updateArtwork() {
        val artwork = artworks[currentArtworkIndex]
        artworkImage.setImageResource(artwork.imageResId)
        artworkTitle.setText(artwork.titleResId)
        artworkArtist.setText(artwork.artistResId)
    }
}

data class Artwork(
    val imageResId: Int,
    val titleResId: Int,
    val artistResId: Int
)
//God help me with this activity di ko na kaya
