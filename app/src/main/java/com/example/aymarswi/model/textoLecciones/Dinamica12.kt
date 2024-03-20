package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.util.dinamicas.EncontrarPares

class Dinamica12(fragment: Fragment) : BaseDinamica(fragment) {

    private var contenedorEnEspanol: LinearLayout
    private var contenedorEnAymara: LinearLayout

    init {
        this.fragment = fragment
        this.contenedorEnEspanol = fragment.requireView().findViewById(R.id.llContenedorAymara)
        this.contenedorEnAymara = fragment.requireView().findViewById(R.id.llContenedorEspanol)

        contenedorOpciones = contenedorEnAymara

        configurar(true)
    }

    override fun colocarDatosEnLaVista() {
        setOptions(contenedorEnEspanol, "Español")
        setOptions(contenedorEnAymara, "Idioma Nativo")
    }

    private fun setOptions(contenedorDeOpciones: LinearLayout, idioma: String) {
        mezclarPosicionesAleatorias()
        for (opcionIndex in 0 until contenedorDeOpciones.childCount) {
            val opcion = contenedorDeOpciones.getChildAt(opcionIndex) as Button
            if (idioma.equals("Español", ignoreCase = true))
                opcion.text = LeccionesJSON.palabras[posicionesAleatorias[opcionIndex]].enEspanol[0]
            if (idioma.equals("Idioma Nativo", ignoreCase = true))
                opcion.text = LeccionesJSON.palabras[posicionesAleatorias[opcionIndex]].enAymara[0]
            opcion.tag = LeccionesJSON.palabras[posicionesAleatorias[opcionIndex]].enAymara[0]
        }
    }

    override fun iniciarDinamica() {
        EncontrarPares().initDinamic(contenedorEnEspanol, contenedorEnAymara)
    }
}