package com.example.bobkov_vv.my_first_kotlin_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var btnToast: Button
    private lateinit var btnCount: Button
    private lateinit var btnRandom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toInitializeView(savedInstanceState)
        setOnClicLlistenersOnTheView()
    }

    private fun setOnClicLlistenersOnTheView() {

        btnToast.setOnClickListener {
            Toast.makeText(this, tvResult.text, Toast.LENGTH_SHORT).show()
        }
        btnCount.setOnClickListener {
            var count: Double = (tvResult.text).toString().toDouble()
            tvResult.text = (++count).toString()
        }
        btnRandom.setOnClickListener {
            var random: Double = Math.random()
            tvResult.text = random.toString()
        }
    }

    private fun toInitializeView(savedInstanceState: Bundle?) {
        tvResult = findViewById<TextView>(R.id.tvResult)
        tvResult.text = if (savedInstanceState != null)
            savedInstanceState.getString(getString(R.string.key), "0") else "0"
        btnToast = findViewById<Button>(R.id.btnToast)
        btnCount = findViewById<Button>(R.id.btnCount)
        btnRandom = findViewById<Button>(R.id.btnRandom)
    }
}
