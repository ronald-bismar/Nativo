package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2v3
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras

class Dinamica2 (fragment: Fragment) : BaseDinamica(fragment) {
    
    private lateinit var palabraPrincipal: Palabra
    init {
        this.title = fragment.requireView().findViewById(R.id.txtTitle2)
        this.imagen = (fragment.requireView().findViewById(R.id.imagen))
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones2)

        configurar(true)
    }

    override fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en español que servirá de guia para el usuario para traducirla al español
        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        title?.text =
            if (fragment is FragmentDinamica2v3) palabraPrincipal.enAymara[0] else palabraPrincipal.enEspanol[0]

        if (imagen != null) {
            Glide.with(Actividad.getInstanceActividad().context)
                .load(palabraPrincipal.imagen)
                .into(imagen!!)
        }

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until contenedorOpciones.childCount) {
            val indexRandom = (0 until posicionesAleatorias.size).random()

            //Colocamos el texto del boton que sera la opcion
            (contenedorOpciones.getChildAt(i) as Button).text =
                if (fragment is FragmentDinamica2v3)
                    LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enEspanol[0]
                else
                    LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enAymara[0]

            posicionesAleatorias.removeAt(indexRandom)
        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            if (fragment is FragmentDinamica2v3) palabraPrincipal.enEspanol[0]
            else palabraPrincipal.enEspanol[0],
            obtenerOpcionesComoLista()
        )
    }
}