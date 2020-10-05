package com.example.hellocadastro

object NotaService {

    private val notas = mutableListOf<Nota>()

    init {
        for (i in 1..3) {
            notas.add(Nota("Nota $i","10/10"))
        }
    }

    fun addNota(nota: Nota) {
        notas.add(nota)
    }

    fun removeNota(nota: Nota) {
        notas.remove(nota)
    }

    fun getNotas(): MutableList<Nota> {
        return notas
    }
}