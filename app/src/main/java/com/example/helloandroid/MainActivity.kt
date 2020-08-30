package com.example.helloandroid

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloandroid.extensions.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btEnviar = findViewById<Button>(R.id.btEnviar)
        btEnviar.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val msg = tMensagem.text.toString()

        tMensagemFinal.text = "Olá $msg"
    }
}