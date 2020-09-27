package com.example.helloandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.helloandroid.extensions.alert

class CMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btLogin).setOnClickListener {
            onClickLogin()
        }

        findViewById<TextView>(R.id.btEsqueciSenha).setOnClickListener {
            onClickEsqueciSenha()
        }

        findViewById<TextView>(R.id.btCadastrar).setOnClickListener {
            onClickCadastrar()
        }
    }

    private fun onClickLogin() {
        // Encontra as views
        val tLogin = findViewById<TextView>(R.id.tLogin)
        val tSenha = findViewById<TextView>(R.id.tSenha)
        // Lê os textos
        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()
        if(login == "ricardo" && senha == "123") {
            // OK
            startActivity(Intent(this,HomeActivity::class.java))
        } else {
            // Erro
            alert("Login incorreto, digite os dados novamente")
        }
    }

    private fun onClickCadastrar() {
        startActivity(Intent(this,CadastroActivity::class.java))
    }

    private fun onClickEsqueciSenha() {
        startActivity(Intent(this,EsqueciSenhaActivity::class.java))
    }
}
