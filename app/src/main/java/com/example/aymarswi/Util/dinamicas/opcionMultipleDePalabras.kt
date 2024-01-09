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
        vararg botones: Button
    ) {
        for (palabraBoton in botones) {
            palabraBoton.setOnClickListener {
                correcto = palabraBoton.text.toString() == palabraCorrecta
                getInstance().respuesta()
            }
        }
    }

    //Funcion para ImageButtons (se envia el primer imageButton que es verdadero y los demas son respuestas falsas
    // ya que no se puede comparar con el metodo .text.toString ya que los imageButton tienen imagen)

    fun palabraVerdadera(
        imgButtonCorrecto: ImageButton,
        vararg imageButtonsIncorrectos: ImageButton) {
        imgButtonCorrecto.setOnClickListener {
            correcto = true
            getInstance().respuesta()
        }
        for (imageButton in imageButtonsIncorrectos) {
            imageButton.setOnClickListener {
                correcto = false
                getInstance().respuesta()
            }
        }
    }

    //Esta funcion se usa para verificar con un boton la palabra que ingreso el usuario mediante el texto de un boton que se presionó

    fun palabraVerdadera(
        palabraCorrecta: String,
        palabraElegida: String,
        botonComprobar: Button
    ) {
        botonComprobar.setOnClickListener {
            correcto = palabraCorrecta.equals(palabraElegida, ignoreCase = true)
            getInstance().respuesta()
        }
    }

    fun palabraVerdadera(
        vararg palabrasCorrectas: String,
        palabraElegida: EditText,
        botonComprobar: Button) {
        botonComprobar.setOnClickListener {
            for (palabra in palabrasCorrectas) {
                if (palabra.equals(palabraElegida.text.toString(), ignoreCase = true)) {
                    getInstance().respuesta(true)
                }
            }
            getInstance().respuesta(false)
        }
    }

    fun palabraVerdadera(
        vararg botones: Button,
        palabraCorrecta: String,
        palabraElegida: TextView,
        botonComprobar: Button) {
        for (boton in botones) {
            boton.setOnClickListener { palabraElegida.text = boton.text }
        }
        botonComprobar.setOnClickListener {
            if (palabraCorrecta.equals(palabraElegida.text.toString(), ignoreCase = true))
                getInstance().respuesta(true)
            getInstance().respuesta(false)
        }
    }
}

