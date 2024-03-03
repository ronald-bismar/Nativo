package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras

class Dinamica6(fragment: Fragment): BaseDinamica(fragment) {

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

        title?.text = LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]

        // Colocamos la imagen de la opción
        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen!!)

        /*Añadimos los datos a la vista de forma que no estén en el mismo orden cada vez (para eso se usan números aleatorios)*/
        for (i in 0 until contenedorOpciones.childCount) {
            val indexRandom = (0 until posicionesAleatorias.size).random()

            // Colocamos el texto de la opción
            (contenedorOpciones.getChildAt(i) as Button).text = LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enAymara[0]

            posicionesAleatorias.removeAt(indexRandom)
        }
    }
    override fun iniciarDinamica() {
      OpcionMultipleDePalabras().palabraVerdadera(
            obtenerOpcionesComoLista(),
            palabraCorrecta = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0],
            palabraElegida = campoRespuesta,
            botonComprobar = btnComprobar
        )
    }
}