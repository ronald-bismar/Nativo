package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras
import com.google.android.flexbox.FlexboxLayout

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

        title.text = LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]

        // Colocamos la imagen de la opción
        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)

        /*Añadimos los datos a la vista de forma que no estén en el mismo orden cada vez (para eso se usan números aleatorios)*/
        for (i in 0 until contenedorOpciones.childCount) {
            val indexRandom = (0 until posicionesRandomicas.size).random()

            // Colocamos el texto de la opción
            (contenedorOpciones.getChildAt(i) as Button).text = LeccionesJSON.palabras[posicionesRandomicas[indexRandom]].enAymara[0]

            posicionesRandomicas.removeAt(indexRandom)
        }
    }
    override fun iniciarDinamica() {
      opcionMultipleDePalabras().palabraVerdadera(
            obtenerOpcionesComoLista(),
            palabraCorrecta = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0],
            palabraElegida = campoRespuesta,
            botonComprobar = btnComprobar
        )
    }
}