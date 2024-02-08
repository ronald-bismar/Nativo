package com.example.aymarswi.Util.dinamicas

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class opcionMultipleDePalabras :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.contenedorDeFragments) {


    fun palabraVerdadera(
        palabraCorrecta: String,
        botones: List<Button>
    ) {
        getInstanceActividad().setPalabraCorrecta(palabraCorrecta)
        for (palabraBoton in botones) {
            palabraBoton.setOnClickListener {
                getInstanceActividad().correcto = palabraBoton.text.toString() == palabraCorrecta
                Log.d("fragment2", "correcto: ${palabraBoton.text.toString() == palabraCorrecta}")
                getInstanceActividad().respuesta()
            }
        }
    }

    //Funcion para ImageButtons (se envia el primer imageButton que es verdadero y los demas son respuestas falsas
    // ya que no se puede comparar con el metodo .text.toString ya que los imageButton tienen imagen)

    fun palabraVerdadera(
        respuestaCorrecta: ImageButton,
        vararg imageButtonsIncorrectos: ImageButton
    ) {
        getInstanceActividad().setPalabraCorrecta("Papá")
        respuestaCorrecta.setOnClickListener {
            getInstanceActividad().correcto = true
            getInstanceActividad().respuesta()
        }
        for (imageButton in imageButtonsIncorrectos) {
            imageButton.setOnClickListener {
                getInstanceActividad().correcto = false
                getInstanceActividad().respuesta()
            }
        }
    }

    //Esta funcion se usa para verificar con un boton la palabra que ingreso el usuario mediante el texto del boton que se presionó

    fun palabraVerdadera(
        palabraCorrecta: String,
        palabraElegida: String,
        botonComprobar: Button
    ) {
        getInstanceActividad().setPalabraCorrecta(palabraCorrecta)
        botonComprobar.setOnClickListener {
            getInstanceActividad().correcto = palabraCorrecta.equals(palabraElegida, ignoreCase = true)
            getInstanceActividad().respuesta()
        }
    }

    fun palabraVerdadera(
        palabrasCorrectas: List<String>,
        palabraElegida: EditText,
        botonComprobar: Button
    ) {
        getInstanceActividad().setPalabraCorrecta(palabrasCorrectas[0])
        botonComprobar.setOnClickListener {
            for (palabra in palabrasCorrectas) {
                Log.d(
                    "fragment3",
                    "palabras comparadas ${palabra.trim()}, ${
                        palabraElegida.text.toString().trim()
                    } respuesta: ${
                        palabra.trim()
                            .equals(palabraElegida.text.toString().trim(), ignoreCase = true)
                    }"
                )
                if (palabra.trim()
                        .equals(palabraElegida.text.toString().trim(), ignoreCase = true)
                ) {
                    getInstanceActividad().correcto = true
                    break
                } else
                    getInstanceActividad().correcto = false
            }
            getInstanceActividad().respuesta()
        }
    }

    fun palabraVerdadera(
        botones: List<Button>,
        palabraCorrecta: String,
        palabraElegida: TextView,
        botonComprobar: Button
    ) {
        getInstanceActividad().setPalabraCorrecta(palabraCorrecta)
        for (boton in botones) {
            boton.setOnClickListener { palabraElegida.text = boton.text }
        }
        botonComprobar.setOnClickListener {
            getInstanceActividad().respuesta(
                palabraCorrecta.equals(
                    palabraElegida.text.toString(),
                    ignoreCase = true
                )
            )
        }
    }
    fun palabraVerdaderaLL(
        palabraCorrecta: String,
        llbotones: List<LinearLayout>
    ) {
        getInstanceActividad().setPalabraCorrecta(palabraCorrecta)
        for (boton in llbotones) {
            boton.setOnClickListener {
                getInstanceActividad().correcto = (boton.getChildAt(1) as TextView).text.toString() == palabraCorrecta
                getInstanceActividad().respuesta()
            }
        }
    }
}

