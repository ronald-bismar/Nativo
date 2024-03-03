package com.example.aymarswi.model.textoLecciones

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras

class Dinamica1(fragment: Fragment) : BaseDinamica(fragment) {

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitle1)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones1)

        configurar(true)
    }

    override fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en aymara que servirá de guia para el usuario para traducirla al español
        title?.text =
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until contenedorOpciones.childCount) {

            if (contenedorOpciones.getChildAt(i) is LinearLayout) {
                val indexRandom = (0 until posicionesAleatorias.size).random()
                val opcion = contenedorOpciones.getChildAt(i) as LinearLayout

                //Colocamos la imagen de la opcion
                Glide.with(Actividad.getInstanceActividad().context)
                    .load(LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].imagen)
                    .into(opcion.getChildAt(0) as ImageView)

                //Colocamos el texto de la opcion
                (opcion.getChildAt(1) as TextView).text =
                    LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enEspanol[0]

                posicionesAleatorias.removeAt(indexRandom)
            }
        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdaderaLL(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0],
            obtenerOpcionesComoLista()
        )
    }
}