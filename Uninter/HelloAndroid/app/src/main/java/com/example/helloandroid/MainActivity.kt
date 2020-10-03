package com.example.helloandroid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.helloandroid.domain.LoginService
import com.example.helloandroid.extensions.alert
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : LogActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null) {
            // recupera o count
            Log.d("uninter","Recuperando estado")
            count = savedInstanceState.getInt("count")
        }
        Log.d("uninter","Count: $count")

        findViewById<Button>(R.id.btLogin).setOnClickListener {
            onClickLogin()
        }

        findViewById<TextView>(R.id.btEsqueciSenha).setOnClickListener {
            onClickEsqueciSenha()
        }

        findViewById<TextView>(R.id.btCadastrar).setOnClickListener {
            onClickCadastrar()
        }

        //android.net.Uri
        btTeste.setOnClickListener {
//            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:987654321"))
//            startActivity(intent)

            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:987654321"))
            startActivity(intent)

//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(intent, 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("uninter","Salvando estado")
        count++
        outState.putInt("count",count)
    }

    private fun onClickLogin() {
        // Encontra as views
        val tLogin = findViewById<TextView>(R.id.tLogin)
        val tSenha = findViewById<TextView>(R.id.tSenha)
        // Lê os textos
        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()
        // Valida o login
        val service = LoginService()
        val user = service.login(login,senha)
        if(user != null) {
            // Fecha a tela de login
            finish()
            // Abre a tela da home
            val intent = Intent(this,HomeActivity::class.java)
            val args = Bundle()
            args.putSerializable("usuario", user)
            intent.putExtras(args)
            startActivity(intent)

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