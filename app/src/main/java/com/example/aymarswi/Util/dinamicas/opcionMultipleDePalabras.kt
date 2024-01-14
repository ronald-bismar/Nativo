package com.example.aymarswi.Util.dinamicas

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class opcionMultipleDePalabras :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.fragmentContainerView3) {


    fun palabraVerdadera(
        palabraCorrecta: String,
        vararg botones: Button
    ) {
        getInstance().setPalabraCorrecta(palabraCorrecta)
        for (palabraBoton in botones) {
            palabraBoton.setOnClickListener {
                getInstance().correcto = palabraBoton.text.toString() == palabraCorrecta
                Log.d("fragment2", "correcto: ${palabraBoton.text.toString() == palabraCorrecta}")
                getInstance().respuesta()
            }
        }
    }

    //Funcion para ImageButtons (se envia el primer imageButton que es verdadero y los demas son respuestas falsas
    // ya que no se puede comparar con el metodo .text.toString ya que los imageButton tienen imagen)

    fun palabraVerdadera(
        respuestaCorrecta: ImageButton,
        vararg imageButtonsIncorrectos: ImageButton
    ) {
        getInstance().setPalabraCorrecta("Papá")
        respuestaCorrecta.setOnClickListener {
            getInstance().correcto = true
            getInstance().respuesta()
        }
        for (imageButton in imageButtonsIncorrectos) {
            imageButton.setOnClickListener {
                getInstance().correcto = false
                getInstance().respuesta()
            }
        }
    }

    //Esta funcion se usa para verificar con un boton la palabra que ingreso el usuario mediante el texto del boton que se presionó

    fun palabraVerdadera(
        palabraCorrecta: String,
        palabraElegida: String,
        botonComprobar: Button
    ) {
        getInstance().setPalabraCorrecta(palabraCorrecta)
        botonComprobar.setOnClickListener {
            getInstance().correcto = palabraCorrecta.equals(palabraElegida, ignoreCase = true)
            getInstance().respuesta()
        }
    }

    fun palabraVerdadera(
        vararg palabrasCorrectas: String,
        palabraElegida: EditText,
        botonComprobar: Button
    ) {
        getInstance().setPalabraCorrecta(palabrasCorrectas[0])
        botonComprobar.setOnClickListener {
            for (palabra in palabrasCorrectas) {
                Log.d("fragment3","palabras comparadas ${palabra.trim()}, ${palabraElegida.text.toString().trim()} respuesta: ${palabra.trim().equals(palabraElegida.text.toString().trim(), ignoreCase = true)}")
                if (palabra.trim().equals(palabraElegida.text.toString().trim(), ignoreCase = true)) {
                    getInstance().correcto = true
                    break
                }else
                    getInstance().correcto = false
            }
            getInstance().respuesta()
        }
    }

    fun palabraVerdadera(
        vararg botones: Button,
        palabraCorrecta: String,
        palabraElegida: TextView,
        botonComprobar: Button
    ) {
        getInstance().setPalabraCorrecta(palabraCorrecta)
        for (boton in botones) {
            boton.setOnClickListener { palabraElegida.text = boton.text }
        }
        botonComprobar.setOnClickListener {
                getInstance().respuesta(palabraCorrecta.equals(palabraElegida.text.toString(), ignoreCase = true))
        }
    }
}

