package com.example.helloandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.helloandroid.domain.LoginRepository
import com.example.helloandroid.extensions.alert

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun onClickLogin() {
        // Encontra as views
        val tLogin = findViewById<TextView>(R.id.tLogin)
        val tSenha = findViewById<TextView>(R.id.tSenha)
        // Lê os textos
        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()
        // Valida o login
        val loginRep = LoginRepository()
        val user = loginRep.login(login,senha)
        if(user != null) {
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
