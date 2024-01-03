package com.example.aymarswi.Util.dinamicas

import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class opcionMultipleDePalabras : Actividad(AppCompatActivity(), AppCompatActivity(), R.id.fragmentContainerView3) {


    fun palabraVerdadera(
        palabraCorrecta: String,
        vararg botones: Button,
        activity: AppCompatActivity
    ) {
        for (palabraBoton in botones) {
            palabraBoton.setOnClickListener {
                correcto = palabraBoton.text.toString() == palabraCorrecta
                respuesta(activity)
            }
        }
    }

    //Funcion para ImageButtons (se envia el primer imageButton que es verdadero y los demas son respuestas falsas
    // ya que no se puede comparar con el metodo .text.toString ya que los imageButton tienen imagen)

    fun palabraVerdadera(
        imgButtonCorrecto: ImageButton,
        vararg imageButtonsIncorrectos: ImageButton, activity: AppCompatActivity
    ) {
        imgButtonCorrecto.setOnClickListener {
            correcto = true
            respuesta(activity)
        }
        for (imageButton in imageButtonsIncorrectos) {
            imageButton.setOnClickListener {
                correcto = false
                respuesta(activity)
            }
        }
    }

    //Esta funcion se usa para verificar con un boton la palabra que ingreso el usuario mediante el texto de un boton que se presionó

    fun palabraVerdadera(
        palabraCorrecta: String,
        palabraElegida: String,
        botonComprobar: Button,
        activity: AppCompatActivity
    ) {
        botonComprobar.setOnClickListener {
            correcto = palabraCorrecta.equals(palabraElegida, ignoreCase = true)
            respuesta(activity)
        }
    }

    fun palabraVerdadera(
        vararg palabrasCorrectas: String,
        palabraElegida: EditText,
        botonComprobar: Button,
        activity: AppCompatActivity
    ) {
        botonComprobar.setOnClickListener {
            for (palabra in palabrasCorrectas) {
                if (palabra.equals(palabraElegida.text.toString(), ignoreCase = true)) {
                    respuesta(true, activity)
                }
            }
            respuesta(false, activity)
        }
    }

    fun palabraVerdadera(
        vararg botones: Button,
        palabraCorrecta: String,
        palabraElegida: TextView,
        botonComprobar: Button,
        activity: AppCompatActivity
    ) {
        for (boton in botones) {
            boton.setOnClickListener { palabraElegida.text = boton.text }
        }
        botonComprobar.setOnClickListener {
            if (palabraCorrecta.equals(palabraElegida.text.toString(), ignoreCase = true))
                respuesta(true, activity)
            respuesta(false, activity)
        }
    }
}

