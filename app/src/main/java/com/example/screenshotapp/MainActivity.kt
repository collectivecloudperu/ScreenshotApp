package com.example.screenshotapp

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var view: View
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById(R.id.home)
        imageView = findViewById(R.id.micaptura)
        val miboton: Button = findViewById(R.id.miboton)

        miboton.setOnClickListener {
            val mb: Bitmap = Screenshot.hacerScreeshotView(imageView)
            imageView.setImageBitmap(mb)
            view.setBackgroundColor(Color.parseColor("#888888"))
        }

    }

    companion object Screenshot {

        private fun hacerScreenshot(view: View): Bitmap {
            view.isDrawingCacheEnabled = true
            view.buildDrawingCache(true)
            val b = Bitmap.createBitmap(view.drawingCache)
            view.isDrawingCacheEnabled = false
            return b
        }

        fun hacerScreeshotView(v: View): Bitmap {
            return hacerScreenshot(v.rootView)
        }

    }

}