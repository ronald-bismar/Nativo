package com.example.aymarswi.model.textoLecciones

open class PosicionesRandomicas (palabrasDeSeccion: List<Palabra>){

    private var palabrasDeSeccion: List<Palabra>

    init {
        this.palabrasDeSeccion = palabrasDeSeccion
    }
    fun getPosicionesAleatoriasSinRepetir(cantidadRandoms: Int, sinOraciones: Boolean): MutableList<Int> {
        val numerosAleatorios = mutableListOf<Int>()
        for (i in 0 until cantidadRandoms){
            var numeroAleatorio: Int
                do{
                    numeroAleatorio = (palabrasDeSeccion.indices).random()
                }while(sinOraciones && palabrasDeSeccion[numeroAleatorio].esOracion || numerosAleatorios.contains(numeroAleatorio))

            numerosAleatorios.add(numeroAleatorio)
        }

        return numerosAleatorios
    }
}