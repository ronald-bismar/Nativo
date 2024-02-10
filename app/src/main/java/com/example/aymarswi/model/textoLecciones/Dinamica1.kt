package com.example.aymarswi.model.textoLecciones

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica1 constructor(fragment: Fragment) {

    private var fragment: Fragment
    private var title: TextView
    private var opciones = mutableListOf<LinearLayout>()

    private lateinit var posicionesRandomicas: List<PosicionParaAñadirALaVista>
    private var posicionRespuestaCorrecta: Int = 0

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitle1)
    }

    fun configurar() {

        obtenerVistasOpciones()

        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        posicionesRandomicas = PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(opciones.size, sinOraciones = true)

        asignarRespuestaCorrecta()
        colocarDatosEnLaVista()
    }

    private fun obtenerVistasOpciones() {
        val viewLayoutOpciones =
            (fragment.requireView().findViewById(R.id.llContenedorOpciones1) as LinearLayout)

        for (i in 0 until viewLayoutOpciones.childCount) {
            if (viewLayoutOpciones.getChildAt(i) is LinearLayout)
                opciones.add(viewLayoutOpciones.getChildAt(i) as LinearLayout)
        }
    }

    private fun asignarRespuestaCorrecta() {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first().numero
        LeccionesJSON.palabras[posicionRespuestaCorrecta].palabraCorrecta = true
    }

    private fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en aymara que servirá de guia para el usuario para traducirla al español
        title.text =
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (opcion in opciones) {
            var opcionRandom: PosicionParaAñadirALaVista
            do {
                opcionRandom = posicionesRandomicas[(posicionesRandomicas.indices).random()]
            } while (opcionRandom.fueAñadido)

            //Colocamos la imagen de la opcion
            Glide.with(Actividad.getInstanceActividad().context)
                .load(LeccionesJSON.palabras[opcionRandom.numero].imagen)
                .into(opcion.getChildAt(0) as ImageView)

            //Colocamos el texto de la opcion
            (opcion.getChildAt(1) as TextView).text =
                LeccionesJSON.palabras[opcionRandom.numero].enEspanol[0]

            opcionRandom.fueAñadido = true
        }
        iniciarDinamica()
    }

    private fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdaderaLL(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0], opciones
        )
    }
}