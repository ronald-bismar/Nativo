package com.example.aymarswi.model.textoLecciones

import com.example.aymarswi.util.Actividad
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object LeccionesJSON {
    private lateinit var inputStream: InputStream
    private lateinit var reader: BufferedReader
    lateinit var palabras: List<Palabra>
    fun seccion(nombreSeccion: String) {

        // Deserializar el JSON a una lista de objetos PalabraFamilia
        inputStream = Actividad.getInstanceActividad().context.assets.open("$nombreSeccion.JSON")

        reader = BufferedReader(InputStreamReader(inputStream))

        val jsonString = reader.readText()
        reader.close()

        palabras = get10PalabrasLeccion(
            Gson().fromJson(jsonString, Array<Palabra>::class.java).toMutableList()
        )
    }

    //Solo obtenemos 10 palabras para que la aplicacion no sea pesada al cargar la imagen que se guardara en bits
    private fun get10PalabrasLeccion(listaCompletaPalabras: MutableList<Palabra>): List<Palabra> {
        val palabrasAleatorias = mutableListOf<Palabra>()
        for (i in 0 until 10) {
            val indexRandom = (listaCompletaPalabras.indices).random()

            palabrasAleatorias.add(listaCompletaPalabras[indexRandom])
            listaCompletaPalabras.removeAt(indexRandom)
        }
        return palabrasAleatorias
    }

    //Obtenemos una oracion si la dinamica seleccionada requiere si o si una oracion
    fun getUnaOracion(): Palabra? {
        val oracionesEncontradas = palabras.filter { it.esOracion }
        return if (oracionesEncontradas.isNotEmpty())
            oracionesEncontradas.random()
        else
            null
    }
}