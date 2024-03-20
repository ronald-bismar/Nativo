package com.example.aymarswi.util.dinamicas

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.util.Actividad

class EscribirPalabraYVerificar : Actividad(AppCompatActivity(), AppCompatActivity(), R.id.contenedorDeFragments) {

    fun verificarPalabra(vararg palabrasCorrectas: String, palabraEscrita: EditText) {
        for (palabraCorrecta in palabrasCorrectas) {
            getInstanceActividad().correcto = palabraCorrecta.equals(palabraEscrita.text.toString(), ignoreCase = true)
        }
        getInstanceActividad().respuesta()
    }
}