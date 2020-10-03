package com.example.helloligacao

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btTeste.setOnClickListener {
            onClickTeste()
        }
    }

    private fun onClickTeste() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:987654321"))
        startActivity(intent)
    }
}