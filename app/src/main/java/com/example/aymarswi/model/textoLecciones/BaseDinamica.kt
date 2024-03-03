package com.example.aymarswi.model.textoLecciones

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

abstract class BaseDinamica(fragment: Fragment) {
    protected var fragment: Fragment
    protected var title: TextView? = null
    protected var imagen: ImageView? = null
    protected lateinit var contenedorOpciones: ViewGroup
    protected lateinit var btnComprobar: Button

    protected lateinit var posicionesAleatorias: MutableList<Int>
    protected var posicionRespuestaCorrecta: Int = 0

    init {
        this.fragment = fragment
    }

    protected abstract fun colocarDatosEnLaVista()
    protected abstract fun iniciarDinamica()

    fun configurar(sinOraciones: Boolean) {
        generatePosicionesAleatorias(sinOraciones)
        asignarRespuestaCorrecta()
        colocarDatosEnLaVista()
        iniciarDinamica()
    }

    fun generatePosicionesAleatorias(sinOraciones: Boolean) {
        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        posicionesAleatorias =
            PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(
                if (contenedorOpciones.childCount == 0) 1 else contenedorOpciones.childCount,
                sinOraciones = sinOraciones
            )
    }

    private fun asignarRespuestaCorrecta() {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesAleatorias.first()
    }

    protected inline fun <reified T : View> obtenerOpcionesComoLista(): MutableList<T> {
        val listaOpciones = mutableListOf<T>()
        for (i in 0 until contenedorOpciones.childCount) {
            val opcion = contenedorOpciones.getChildAt(i)
            if (opcion is T) {
                listaOpciones.add(opcion)
            }
        }
        return listaOpciones
    }
}