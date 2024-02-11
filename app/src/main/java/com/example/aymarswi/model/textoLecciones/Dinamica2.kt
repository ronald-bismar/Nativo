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

class Dinamica2 constructor(fragment: Fragment){
    private var fragment: Fragment
    private var title: TextView
    private var imagen: ImageView
    private var contenedorOpciones: LinearLayout

    private lateinit var posicionesRandomicas: MutableList<Int>
    private var posicionRespuestaCorrecta: Int = 0

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitle2)
        this.imagen = fragment.requireView().findViewById(R.id.imagen)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones2)

    }

    fun configurar() {

        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        posicionesRandomicas = PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(contenedorOpciones.childCount, sinOraciones = true)

        asignarRespuestaCorrecta()
        colocarDatosEnLaVista()
        obtenerOpcionesComoLista()
        iniciarDinamica()
    }

    private fun asignarRespuestaCorrecta() {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first()
    }

    private fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en español que servirá de guia para el usuario para traducirla al español
        title.text =
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]

        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until contenedorOpciones.childCount) {

            val indexRandom = (posicionesRandomicas.indices).random()

            //Colocamos el texto del boton que sera la opcion
            (contenedorOpciones.getChildAt(i) as Button).text =
                LeccionesJSON.palabras[indexRandom].enAymara[0]

            posicionesRandomicas.removeAt(indexRandom)
        }
    }

    private fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0], obtenerOpcionesComoLista()
        )
    }

    private fun obtenerOpcionesComoLista() : MutableList<Button> {
        val listaBotonesDeOpciones = mutableListOf<Button>()
        for (i in 0 until contenedorOpciones.childCount) {
            if (contenedorOpciones.getChildAt(i) is Button)
                listaBotonesDeOpciones.add(contenedorOpciones.getChildAt(i) as Button)
        }
        return listaBotonesDeOpciones
    }
}