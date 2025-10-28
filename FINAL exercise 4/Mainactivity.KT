package com.example.myapplication



import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnStandard = findViewById< Button>(R.id.btnStandard)
        val btnImage = findViewById< ImageButton>(R.id.btnImage)
        val btnToggle = findViewById<ToggleButton>(R.id.btnToggle)

        // 🔹 Step 2: Add Toast messages for button clicks
        btnStandard.setOnClickListener {
            Toast.makeText(this, "Standard Button Clicked!", Toast.LENGTH_SHORT).show()
        }

        btnImage.setOnClickListener {
            Toast.makeText(this, "Image Button Clicked!", Toast.LENGTH_SHORT).show()
        }

        btnToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Toggle is ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Toggle is OFF", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
