package com.example.myapplication

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast
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

        val autoCountry = findViewById<AutoCompleteTextView>(R.id.autoCountry)
        val spinner = findViewById<Spinner>(R.id.spinnerOptions)

        // Step 2: AutoCompleteTextView suggestions
        val countries = arrayOf("Philippines", "Japan", "USA", "Canada", "Australia")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        autoCountry.setAdapter(countryAdapter)

        // Step 3: Spinner options
        val options = arrayOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)
        spinner.adapter = spinnerAdapter

        // Step 4: Spinner item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                Toast.makeText(applicationContext, "Selected: ${options[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}        }

        btnToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Toggle is ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Toggle is OFF", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
