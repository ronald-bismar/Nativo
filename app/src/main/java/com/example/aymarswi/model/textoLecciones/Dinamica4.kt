package com.example.aymarswi.model.textoLecciones

import android.annotation.SuppressLint
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica4(fragment: Fragment) {
    private var fragment: Fragment
    private var oracion: TextView
    private var imagen: ImageView
    private var respuesta: EditText
    private var btnComprobar: Button

    private lateinit var posicionesRandomicas: List<Int>
    private var posicionRespuestaCorrecta: Int = 0

    init {
        this.fragment = fragment
        this.imagen = fragment.requireView().findViewById(R.id.imagen4)
        this.oracion = fragment.requireView().findViewById(R.id.txtOracion4)
        this.respuesta = fragment.requireView().findViewById(R.id.txtRespuesta4)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar4)
    }

    fun configurar() {

        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        posicionesRandomicas =
            PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(1, false)

        asignarRespuestaCorrecta()
        colocarDatosEnLaVista()
        iniciarDinamica()
    }

    private fun asignarRespuestaCorrecta() {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first()
        LeccionesJSON.palabras[posicionRespuestaCorrecta].palabraCorrecta = true
    }

    private fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en aymara que servirá de guia para el usuario para traducirla al español
        oracion.text = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]
    }

    private fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol,
            palabraElegida = respuesta,
            botonComprobar = btnComprobar,
        )
    }
}