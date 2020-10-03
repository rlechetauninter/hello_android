package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloandroid.domain.Usuario
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val args = intent.extras
        val user = args?.getSerializable("usuario") as Usuario
        tNome.text = "${user.nome} - ${user.email}"
    }
}