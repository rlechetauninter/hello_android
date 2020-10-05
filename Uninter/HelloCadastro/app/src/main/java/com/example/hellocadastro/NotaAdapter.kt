package br.com.livroandroid.notas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hellocadastro.Nota
import com.example.hellocadastro.R
import kotlinx.android.synthetic.main.adapter_nota.view.*

// Define o construtor que recebe (notas,onClick)
class NotaAdapter(
    val notas: List<Nota>,
    val onClick: (Nota) -> Unit) :
        RecyclerView.Adapter<NotaAdapter.NotasViewHolder>() {
    // Retorna a quantidade de notas na lista
    override fun getItemCount(): Int {
        return this.notas.size
    }
    // Infla o layout do adapter e retorna o ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        // Infla a view do adapter
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_nota, parent, false)
        // Retorna o ViewHolder que contém todas as views
        val holder = NotasViewHolder(view)
        return holder
    }
    // Faz o bind para atualizar o valor das views com os dados do Nota
    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        // Recupera o objeto nota
        val nota = notas[position]
        val view = holder.itemView
        with(view) {
            // Atualiza os dados do nota
            tTitulo.text = nota.titulo
            tData.text = nota.data

            // Adiciona o evento de clique na linha
            setOnClickListener { onClick(nota) }
        }
    }
    // ViewHolder fica vazio pois usamos o import do Android Kotlin Extensions
    class NotasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
}
