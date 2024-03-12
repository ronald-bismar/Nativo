package com.example.aymarswi.model.textoLecciones

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras

class Dinamica11(fragment: Fragment) : BaseDinamica(fragment) {

    private lateinit var palabraPrincipal: Palabra

    init {
        this.imagen = (fragment.requireView().findViewById(R.id.imagenD11))
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.contenedorOpcionesD11)

        configurar(true)
    }

    override fun colocarDatosEnLaVista() {

        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        imagen?.let { LoadImage.loadInto(imagen!!, palabraPrincipal.imagen) }

        mezclarPosicionesAleatorias()

        val indexOpcion = 0

        contenedorOpciones.children.filterIsInstance<LinearLayout>().forEach { view ->
            val opcionConTextoEnAymara: View = view.getChildAt(0)
            val opcionConTextoEnEspanol: View = view.getChildAt(1)
            if (opcionConTextoEnAymara is TextView && opcionConTextoEnEspanol is TextView) {
                opcionConTextoEnAymara.text =
                    LeccionesJSON.palabras[posicionesAleatorias[indexOpcion]].enAymara[0]
                opcionConTextoEnEspanol.text =
                    LeccionesJSON.palabras[posicionesAleatorias[indexOpcion]].enEspanol[0]
            }
        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdaderaLL(
            palabraPrincipal.enEspanol[0], getOptionsAsList()
        )
    }
}