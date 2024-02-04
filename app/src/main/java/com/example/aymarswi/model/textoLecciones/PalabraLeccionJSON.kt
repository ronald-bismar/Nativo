package com.example.aymarswi.model.textoLecciones

import com.example.aymarswi.Util.Actividad
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class PalabraLeccionJSON {
    private lateinit var inputStream: InputStream
    private lateinit var reader: BufferedReader

    fun getSeccion(nombreSeccion: String): List<Palabra> {

        // Deserializar el JSON a una lista de objetos PalabraFamilia
        inputStream = Actividad.getInstanceActividad().context.assets.open("$nombreSeccion.JSON")

        reader = BufferedReader(InputStreamReader(inputStream))

        val jsonString = reader.readText()
        reader.close()

        return Gson().fromJson(jsonString, Array<Palabra>::class.java).toList()
    }
}