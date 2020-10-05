package com.example.hellocadastro

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.livroandroid.notas.adapter.NotaAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { onClickAddNota() }
    }

    private fun onClickAddNota() {
        startActivity(Intent(this, CadastroNotaActivity::class.java))
    }

    override fun onResume() {
        super.onResume()

        val notas = NotaService.getNotas()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = NotaAdapter(notas) {
            onClickNota(it)
        }
    }

    private fun onClickNota(nota: Nota) {
        val intent = Intent(this, CadastroNotaActivity::class.java)
        intent.putExtra("nota",nota)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_add -> {
                startActivity(Intent(this, CadastroNotaActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}