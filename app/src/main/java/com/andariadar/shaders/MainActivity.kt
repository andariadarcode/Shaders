package com.andariadar.shaders

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andariadar.shaders.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bitmap = BitmapFactory.decodeResource(
                resources,
                R.drawable.photo_spring)

        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)

        binding.apply {
            val width = textSpring2.paint.measureText(textSpring2.text.toString())
            val height = textSpring2.textSize

            val linearGradientShader = LinearGradient(
                    0f, 0f, width, height,
                    intArrayOf(Color.RED, Color.GREEN, Color.BLUE),
                    null,
                    Shader.TileMode.CLAMP)

            val radialGradientShader = RadialGradient(
                    width / 2, height / 2, width / 2,
                    intArrayOf(Color.MAGENTA, Color.CYAN, Color.BLUE),
                    null,
                    Shader.TileMode.CLAMP)

            textSpring1.paint.shader = bitmapShader
            textSpring2.paint.shader = linearGradientShader
            textSpring3.paint.shader = radialGradientShader
        }
    }
}