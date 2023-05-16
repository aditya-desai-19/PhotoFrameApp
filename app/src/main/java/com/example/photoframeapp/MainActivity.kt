package com.example.photoframeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.photoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var currentImage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val names = arrayOf("Naruto", "L", "Ippo", "Gon")

        binding.prevbtn.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            //convert string id to integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            val image = findViewById<ImageView>(idCurrentImageInt)
            val titlename = findViewById<TextView>(R.id.title)
            image.alpha = 0f

            currentImage -= 1
            if(currentImage == 0) { currentImage = 4 }

            val idNextImageString = "pic$currentImage"
            val idNextImageInt = this.resources.getIdentifier(idNextImageString, "id", packageName)
            val nextImage = findViewById<ImageView>(idNextImageInt)
            titlename.text = names[currentImage - 1]
            nextImage .alpha = 1f

        }

        binding.nextbtn.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            //convert string id to integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            val image = findViewById<ImageView>(idCurrentImageInt)
            val titlename = findViewById<TextView>(R.id.title)
            image.alpha = 0f

            currentImage += 1
            if(currentImage == 5) { currentImage = 1 }

            val idNextImageString = "pic$currentImage"
            val idNextImageInt = this.resources.getIdentifier(idNextImageString, "id", packageName)
            val nextImage = findViewById<ImageView>(idNextImageInt)
            titlename.text = names[currentImage - 1]
            nextImage .alpha = 1f

        }

    }
}