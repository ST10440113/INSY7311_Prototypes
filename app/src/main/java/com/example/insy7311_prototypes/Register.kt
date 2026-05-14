package com.example.insy7311_prototypes

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent

class Register : AppCompatActivity() {
    private lateinit var appName: TextView
    private lateinit var buttonRegister:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        appName = findViewById(R.id.appName)
        buttonRegister = findViewById(R.id.buttonRegister)
        //for gradient heading
        val width = appName.width.toFloat()
        val textShader: Shader = LinearGradient(
            2f, 0f, width, appName.textSize,
            intArrayOf("#7ed597".toColorInt(), "#0097b2".toColorInt()),
            null, Shader.TileMode.CLAMP
        )

        appName.paint.shader = textShader

        buttonRegister.setOnClickListener {
            startActivity(Intent(this, Questions::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}