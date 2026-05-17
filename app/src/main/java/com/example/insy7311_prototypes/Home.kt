package com.example.insy7311_prototypes

import android.content.Intent
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {

    private lateinit var appName: TextView

    private lateinit var textViewWellness: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        appName = findViewById(R.id.appName)

        //for gradient heading
        val width = appName.width.toFloat()
        val textShader: Shader = LinearGradient(
            2f, 0f, width, appName.textSize,
            intArrayOf("#7ed597".toColorInt(), "#0097b2".toColorInt()),
            null, Shader.TileMode.CLAMP
        )

        appName.paint.shader = textShader

        textViewWellness = findViewById(R.id.textViewWellness)

        textViewWellness.setOnClickListener {
            startActivity(Intent(this, WellnessResources::class.java))
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}