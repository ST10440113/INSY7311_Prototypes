package com.example.insy7311_prototypes

import android.graphics.Shader
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import androidx.core.graphics.toColorInt
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var appName :TextView

    private lateinit var textViewRegisterRedirect :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textViewRegisterRedirect = findViewById(R.id.textViewRegisterRedirect)
        appName = findViewById(R.id.appName)

        //for gradient heading
         val width = appName.width.toFloat()
         val textShader: Shader = LinearGradient(
                2f, 0f, width, appName.textSize,
                intArrayOf("#7ed597".toColorInt(), "#0097b2".toColorInt()),
                null, Shader.TileMode.CLAMP
            )

            appName.paint.shader = textShader

        //for underlined link
        textViewRegisterRedirect.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        textViewRegisterRedirect.setOnClickListener {
          startActivity(Intent(this, Register::class.java))
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}