package com.example.helloligacao

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // (1): Esse método valida se permissão já foi concedida.
        // Caso o usuário já tenha aceitado, ele retorna true.
        // Caso contrário, retorna false e mostra o alerta ao usuário.
        val ok = PermissionUtils.request(this, arrayOf(Manifest.permission.CALL_PHONE))

        if(ok) {
            btTeste.setOnClickListener {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:987654321"))
                startActivity(intent)
            }
        } else {
            // Se o usuário ainda não aceitou a permissão ou se ele foi negada..
            // Deixa o botão Invisível
            btTeste.visibility = View.INVISIBLE
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val ok = PermissionUtils.validate(this, permissions)
        if(ok) {
            // Deixa o botão visível se o usuário aceitou a permissão
            btTeste.visibility = View.VISIBLE
        }
    }
}