package com.example.insy7311_prototypes

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class WellnessResources : AppCompatActivity() {
    private lateinit var textViewWellnessHeading : TextView

    private lateinit var textViewBreadHome : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wellness_resources)

        textViewWellnessHeading = findViewById(R.id.textViewWellnessHeading)
        textViewBreadHome = findViewById(R.id.textViewBreadHome)

        textViewWellnessHeading.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        textViewBreadHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}