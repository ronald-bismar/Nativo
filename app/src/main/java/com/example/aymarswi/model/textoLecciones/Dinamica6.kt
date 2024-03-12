package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras

class Dinamica6(fragment: Fragment) : BaseDinamica(fragment) {

    private lateinit var palabraPrincipal: Palabra
    private var campoRespuesta: TextView


    init {
        this.imagen = fragment.requireView().findViewById(R.id.imagen6)
        this.title = fragment.requireView().findViewById(R.id.txtTitle6)
        this.campoRespuesta = fragment.requireView().findViewById(R.id.campoRespuesta)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.flContenedorBotones6)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar6)

        configurar(sinOraciones = true)
    }

    override fun colocarDatosEnLaVista() {

        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        setTitle(palabraPrincipal.enEspanol[0])

        imagen?.let { LoadImage.loadInto(imagen!!, palabraPrincipal.imagen) }

        mezclarPosicionesAleatorias()

        /*Añadimos los datos a la vista de forma que no estén en el mismo orden cada vez (para eso se usan números aleatorios)*/
        for (opcionIndex in 0 until contenedorOpciones.childCount) {
            // Colocamos el texto de la opción
            val opcion = contenedorOpciones.getChildAt(opcionIndex)
            if (opcion is Button)
                opcion.text = LeccionesJSON.palabras[posicionesAleatorias[opcionIndex]].enAymara[0]
        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            getOptionsAsList(),
            palabraCorrecta = palabraPrincipal.enAymara[0],
            palabraElegida = campoRespuesta,
            botonComprobar = btnComprobar
        )
    }
}