package com.example.aymarswi.model.textoLecciones

open class PosicionesRandomicas (palabrasDeSeccion: List<Palabra>){

    private var palabrasDeSeccion: List<Palabra>

    init {
        this.palabrasDeSeccion = palabrasDeSeccion
    }

    /*Usamos un hashset para que los numeros no se repitan, y un boolean
   para verificar que la misma posicion no se añada dos veces a la UI*/

    fun getPosicionesRandomicasSinRepetir(cantidadRandoms: Int, sinOraciones: Boolean): List<PosicionParaAñadirALaVista> {
        val numerosRandomicos = HashSet<PosicionParaAñadirALaVista>()
        for (i in 0 until cantidadRandoms){
            var numRandom: Int
                do{
                    numRandom = (palabrasDeSeccion.indices).random()
                }while(sinOraciones && palabrasDeSeccion[numRandom].esOracion)

            numerosRandomicos.add(
                PosicionParaAñadirALaVista(numRandom, false
                )
            )
        }

        return numerosRandomicos.toList()
    }
}