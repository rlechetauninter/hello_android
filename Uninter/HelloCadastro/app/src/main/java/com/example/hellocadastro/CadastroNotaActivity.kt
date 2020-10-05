package com.example.hellocadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_cadastro_nota.*

class CadastroNotaActivity : AppCompatActivity() {

    private var nota: Nota? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_nota)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nota = intent.getSerializableExtra("nota") as Nota?
        initNota(nota)

        btSalvar.setOnClickListener { onClickSalvar() }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initNota(nota: Nota?) {
        if(nota != null) {
            tTitulo.setText(nota.titulo)
        }
    }

    private fun onClickSalvar() {
        val nota = getNota()

        NotaService.save(nota)

        finish()
    }

    private fun getNota(): Nota {
        val n = this.nota?: Nota()
        n.titulo = tTitulo.text.toString()
        return n
    }
}