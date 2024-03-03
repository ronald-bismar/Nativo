package com.example.aymarswi.model.textoLecciones

import DeslizarUnaPalabra
import android.util.Log
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class Dinamica10 (fragment: Fragment): BaseDinamica(fragment){

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
        val palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]
        title?.text = palabraPrincipal.enEspanol[0]
        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen!!)

        campoRespuesta.tag = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]

        removerUnElemento(palabraPrincipal.enAymara[0])
        Log.d("Posiciones","posiciones aleatorias: $posicionesAleatorias")
        contenedorOpciones.children.forEach {opcion ->
            if(opcion is TextView){
                val indexRandom = (0 until posicionesAleatorias.size).random()
                Log.d("Posiciones","index random: $indexRandom")
                    opcion.text = LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enAymara[0]
                    posicionesAleatorias.removeAt(indexRandom)
            }
        }
    }

    private fun removerUnElemento(palabraPrincipal: String) {
        posicionesAleatorias.removeAt(if(LeccionesJSON.palabras[posicionesAleatorias[0]].enAymara[0] != palabraPrincipal) 0 else 1)
    }

    override fun iniciarDinamica() {
        DeslizarUnaPalabra().initialize(LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0], campoRespuesta, contenedorOpciones, btnComprobar)
    }

}