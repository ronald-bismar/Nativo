package com.example.aymarswi.model.textoLecciones

import android.annotation.SuppressLint
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica3(fragment: Fragment) {
    private var fragment: Fragment
    private var title: TextView
    private var imagen: ImageView
    private var respuesta: EditText
    private var btnComprobar: Button

    private lateinit var posicionesRandomicas: List<PosicionParaAñadirALaVista>
    private var posicionRespuestaCorrecta: Int = 0

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitle3)
        this.imagen = fragment.requireView().findViewById(R.id.imagen3)
        this.respuesta = fragment.requireView().findViewById(R.id.txtRespuesta3)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar3)
    }

    fun configurar() {

        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        posicionesRandomicas =
            PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(1, sinOraciones = false)

        asignarRespuestaCorrecta()
        colocarDatosEnLaVista()
    }

    private fun asignarRespuestaCorrecta() {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first().numero
        LeccionesJSON.palabras[posicionRespuestaCorrecta].palabraCorrecta = true
    }

    @SuppressLint("SetTextI18n")
    private fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en español que servirá de guia para el usuario para traducirla al español
        title.text =
            "COMO SE ESCRIBE ${LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0].uppercase()}?"

        //Colocamos la imagen de la opcion
        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)


        iniciarDinamica()

    }

    private fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara,
            palabraElegida = respuesta,
            botonComprobar = btnComprobar,
        )
    }
}