package com.example.scannertester

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvResultValue: TextView

    companion object {
        private const val SCAN_REQUEST_CODE = 42
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResultValue = findViewById(R.id.tvResultValue)
        val btnOpenScanner = findViewById<Button>(R.id.btnOpenScanner)

        btnOpenScanner.setOnClickListener {
            val intent = Intent("com.example.handyscanner.SCAN")
            try {
                startActivityForResult(intent, SCAN_REQUEST_CODE)
            } catch (e: Exception) {
                tvResultValue.text = "Error: Handy Scanner app not found!"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SCAN_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("SCAN_RESULT")
                val format = data?.getStringExtra("SCAN_FORMAT")
                tvResultValue.text = "Result: $result\nFormat: $format"
            } else {
                tvResultValue.text = "Scan cancelled"
            }
        }
    }
}
