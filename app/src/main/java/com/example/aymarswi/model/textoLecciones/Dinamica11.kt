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

        if (imagen != null) {
            Glide.with(Actividad.getInstanceActividad().context)
                .load(palabraPrincipal.imagen)
                .into(imagen!!)
        }

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        contenedorOpciones.children.filterIsInstance<LinearLayout>().forEach { view ->
            val opcionConTextoEnAymara: View = view.getChildAt(0)
            val opcionConTextoEnEspanol: View = view.getChildAt(1)
            if (opcionConTextoEnAymara is TextView && opcionConTextoEnEspanol is TextView) {
                val indexRandom = (0 until posicionesAleatorias.size).random()

                opcionConTextoEnAymara.text =
                    LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enAymara[0]
                opcionConTextoEnEspanol.text =
                    LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enEspanol[0]
                posicionesAleatorias.removeAt(indexRandom)
            }
        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdaderaLL(
            palabraPrincipal.enEspanol[0],
            obtenerOpcionesComoLista()
        )
    }
}