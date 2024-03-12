package com.example.aymarswi.model.textoLecciones

import DeslizarUnaPalabra
import android.util.Log
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class Dinamica10(fragment: Fragment) : BaseDinamica(fragment) {

    private lateinit var palabraPrincipal: Palabra
    private var campoRespuesta: TextView

    init {
        title = fragment.requireView().findViewById(R.id.txtTitleD10)
        imagen = fragment.requireView().findViewById(R.id.imagenD10)
        contenedorOpciones = fragment.requireView().findViewById(R.id.contenedorOpcionesD10)
        campoRespuesta = fragment.requireView().findViewById(R.id.txtContPalabraD10)
        btnComprobar = fragment.requireView().findViewById(R.id.btnComprobarD10)

        configurar(sinOraciones = true)
    }

    override fun colocarDatosEnLaVista() {
        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        setTitle(palabraPrincipal.enEspanol[0])
        imagen?.let { LoadImage.loadInto(imagen!!, palabraPrincipal.imagen) }

        campoRespuesta.tag = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]

        removerUnElemento(palabraPrincipal.enAymara[0])

        mezclarPosicionesAleatorias()
        var indexRandom = 0
        contenedorOpciones.children.forEach { opcion ->
            if (opcion is TextView)
                opcion.text =
                    LeccionesJSON.palabras[posicionesAleatorias[indexRandom++]].enAymara[0]
        }
    }

    private fun removerUnElemento(palabraPrincipal: String) {
        posicionesAleatorias.removeAt(if (LeccionesJSON.palabras[posicionesAleatorias[0]].enAymara[0] != palabraPrincipal) 0 else 1)
    }

    override fun iniciarDinamica() {
        DeslizarUnaPalabra().initialize(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0],
            campoRespuesta,
            contenedorOpciones,
            btnComprobar
        )
    }
}