package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.util.dinamicas.OpcionMultipleDePalabras

class Dinamica8(fragment: Fragment) : BaseDinamica(fragment) {

    private lateinit var palabraPrincipal: Palabra
    private var iconoSonido: ImageView

    init {
        title = fragment.requireView().findViewById(R.id.titleD8)
        iconoSonido = fragment.requireView().findViewById(R.id.imgSonido)
        contenedorOpciones = fragment.requireView().findViewById(R.id.contenedorOpcionesD8)
        configurar(true)
    }

    override fun colocarDatosEnLaVista() {

        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        setTitle(palabraPrincipal.enEspanol[0])

        mezclarPosicionesAleatorias()
        for (opcionIndex in 0 until contenedorOpciones.childCount) {
            //Colocamos el texto del boton que sera la opcion
            val opcion = contenedorOpciones.getChildAt(opcionIndex)
            if (opcion is Button)
                opcion.text = LeccionesJSON.palabras[posicionesAleatorias[opcionIndex]].enAymara[0]

        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            palabraPrincipal.enAymara[0],
            getOptionsAsList()
        )
    }
}