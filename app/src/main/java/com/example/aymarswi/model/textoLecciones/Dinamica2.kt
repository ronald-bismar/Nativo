package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica2v3
import com.example.aymarswi.util.dinamicas.OpcionMultipleDePalabras

class Dinamica2(fragment: Fragment) : BaseDinamica(fragment) {

    private lateinit var palabraPrincipal: Palabra

    init {
        this.title = fragment.requireView().findViewById(R.id.txtTitle2)
        this.imagen = (fragment.requireView().findViewById(R.id.imagen))
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones2)

        configurar(true)
    }

    override fun colocarDatosEnLaVista() {
        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        setTitle(if (fragment is FragmentDinamica2v3) palabraPrincipal.enAymara[0] else palabraPrincipal.enEspanol[0])

        imagen?.let { LoadImage.loadInto(imagen!!, palabraPrincipal.imagen) }

        mezclarPosicionesAleatorias()

        for (opcionIndex in 0 until contenedorOpciones.childCount) {
            //Colocamos el texto del boton que sera la opcion
            (contenedorOpciones.getChildAt(opcionIndex) as Button).text =
                if (fragment is FragmentDinamica2v3)
                    LeccionesJSON.palabras[posicionesAleatorias[opcionIndex]].enEspanol[0]
                else
                    LeccionesJSON.palabras[posicionesAleatorias[opcionIndex]].enAymara[0]

        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            if (fragment is FragmentDinamica2v3) palabraPrincipal.enEspanol[0]
            else palabraPrincipal.enAymara[0],
            getOptionsAsList()
        )
    }
}