package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras

class Dinamica8(fragment: Fragment): BaseDinamica(fragment){

    private var iconoSonido: ImageView

    init {
        iconoSonido = fragment.requireView().findViewById(R.id.imgVSonido)
        contenedorOpciones = fragment.requireView().findViewById(R.id.contenedorOpcionesD8)
        configurar(true)
    }
    override fun colocarDatosEnLaVista() {

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
        OpcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0], obtenerOpcionesComoLista()
        )
    }
}