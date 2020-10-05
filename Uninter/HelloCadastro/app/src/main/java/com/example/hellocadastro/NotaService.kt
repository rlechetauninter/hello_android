package com.example.hellocadastro

object NotaService {

    private var count = 0
    private val notas = mutableSetOf<Nota>()

    init {
        for (i in 1..3) {
            notas.add(Nota(i,"Nota $i"))
        }
    }

    fun save(nota: Nota) {
        if(nota.id == 0) {
            nota.id = ++count
            notas.add(nota)
        }
    }

    fun remove(nota: Nota) {
        notas.remove(nota)
    }

    fun getNotas(): List<Nota> {
        return notas.toList()
    }
}