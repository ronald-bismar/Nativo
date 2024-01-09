package com.example.aymarswi.Util.dinamicas

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class escribirPalabraYVerificar : Actividad(AppCompatActivity(), AppCompatActivity(), R.id.fragmentContainerView3) {

    fun verificarPalabra(vararg palabrasCorrectas: String, palabraEscrita: EditText) {
        for (palabraCorrecta in palabrasCorrectas) {
            correcto = palabraCorrecta.equals(palabraEscrita.text.toString(), ignoreCase = true)
        }
        getInstance().respuesta()
    }
}