package com.example.aymarswi.model.textoLecciones

import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica2 constructor(fragment: Fragment){
    private var fragment: Fragment
    private var title: TextView
    private var imagen: ImageView
    private var opciones = mutableListOf<Button>()

    private lateinit var posicionesRandomicas: List<PosicionParaAñadirALaVista>
    private var posicionRespuestaCorrecta: Int = 0

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitle2)
        this.imagen = fragment.requireView().findViewById(R.id.imagen)
    }

    fun configurar() {

        obtenerVistasOpciones()

        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        posicionesRandomicas = PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(opciones.size, sinOraciones = true)

        asignarRespuestaCorrecta()
        colocarDatosEnLaVista()
    }

    private fun obtenerVistasOpciones() {
        val ViewLayoutOpciones =
            (fragment.requireView().findViewById(R.id.llContenedorOpciones2) as LinearLayout)

        for (i in 0 until ViewLayoutOpciones.childCount) {
            if (ViewLayoutOpciones.getChildAt(i) is Button)
                opciones.add(ViewLayoutOpciones.getChildAt(i) as Button)
        }
    }

    private fun asignarRespuestaCorrecta() {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first().numero
        LeccionesJSON.palabras[posicionRespuestaCorrecta].palabraCorrecta = true
    }

    private fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en español que servirá de guia para el usuario para traducirla al español
        title.text =
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (opcion in opciones) {
            var opcionRandom: PosicionParaAñadirALaVista
            do {
                opcionRandom = posicionesRandomicas[(posicionesRandomicas.indices).random()]
            } while (opcionRandom.fueAñadido)

            //Colocamos la imagen de la opcion
            Glide.with(Actividad.getInstanceActividad().context)
                .load(LeccionesJSON.palabras[opcionRandom.numero].imagen)
                .into(imagen)

            //Colocamos el texto de la opcion
            opcion.text =
                LeccionesJSON.palabras[opcionRandom.numero].enAymara[0]

            opcionRandom.fueAñadido = true
        }
        iniciarDinamica()

    }

    private fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0], opciones
        )
    }
}