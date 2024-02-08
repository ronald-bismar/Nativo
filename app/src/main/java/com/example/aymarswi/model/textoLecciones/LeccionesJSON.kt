package com.example.aymarswi.model.textoLecciones

import com.example.aymarswi.Util.Actividad
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

        palabras = Gson().fromJson(jsonString, Array<Palabra>::class.java).toList()
    }



    //Talvez la aplicacion se congela por que no sale rapidamente una oracion
    //(Nota: Añadir mas oraciones)
    fun getOracionPrincipal(): Palabra{
        var palabra: Palabra
        do{
            palabra = palabras[(palabras.indices).random()]
        }while (!palabra.esOracion)
        return palabra
    }
}