package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica2 constructor(fragment: Fragment): BaseDinamica(fragment){
    init {
        this.title = fragment.requireView().findViewById(R.id.txtTitle2)
        this.imagen = fragment.requireView().findViewById(R.id.imagen)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones2)

        configurar(true)
    }
    override fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en español que servirá de guia para el usuario para traducirla al español
        title.text =
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]

        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until contenedorOpciones.childCount) {

            val indexRandom = (0 until posicionesRandomicas.size).random()

            //Colocamos el texto del boton que sera la opcion
            (contenedorOpciones.getChildAt(i) as Button).text =
                LeccionesJSON.palabras[posicionesRandomicas[indexRandom]].enAymara[0]

            posicionesRandomicas.removeAt(indexRandom)
        }
    }

    override fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0], obtenerOpcionesComoLista()
        )
    }
}