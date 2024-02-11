package com.example.aymarswi.model.textoLecciones

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica1(fragment: Fragment) {

    private var fragment: Fragment
    private var title: TextView
    private var contOpciones: LinearLayout

    private lateinit var posicionesRandomicas: MutableList<Int>
    private var posicionRespuestaCorrecta: Int = 0

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitle1)
        this.contOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones1)
    }

    fun configurar() {
        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        posicionesRandomicas =
            PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(
                contOpciones.childCount,
                sinOraciones = true
            )

        asignarRespuestaCorrecta()
        colocarDatosEnLaVista()
        iniciarDinamica()
    }

    private fun asignarRespuestaCorrecta() {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first()
    }

    private fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en aymara que servirá de guia para el usuario para traducirla al español
        title.text =
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until  contOpciones.childCount) {
            val indexRandom = (posicionesRandomicas.indices).random()

            val opcion = contOpciones.getChildAt(i) as LinearLayout

            //Colocamos la imagen de la opcion
            Glide.with(Actividad.getInstanceActividad().context)
                .load(LeccionesJSON.palabras[indexRandom].imagen)
                .into(opcion.getChildAt(0) as ImageView)

            //Colocamos el texto de la opcion
            (opcion.getChildAt(1) as TextView).text =
                LeccionesJSON.palabras[indexRandom].enEspanol[0]

            posicionesRandomicas.removeAt(indexRandom)
        }

    }

    private fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdaderaLL(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0], obtenerOpcionesComoLista()
        )
    }
    private fun obtenerOpcionesComoLista(): MutableList<LinearLayout>{
        val listaOpciones = mutableListOf<LinearLayout>()
        for(i in 0 until contOpciones.childCount){
            if(contOpciones.getChildAt(i) is LinearLayout)
                listaOpciones.add(contOpciones.getChildAt(i) as LinearLayout)
        }
         return listaOpciones
    }
}