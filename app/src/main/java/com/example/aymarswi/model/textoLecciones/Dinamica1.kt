package com.example.aymarswi.model.textoLecciones

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras

class Dinamica1(fragment: Fragment) : BaseDinamica(fragment) {

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitle1)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones1)

        configurar(true)
    }

    override fun colocarDatosEnLaVista() {
        // Colocamos como título la palabra principal en aymara que servirá de guía para el usuario para traducirla al español
        setTitle(LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara.firstOrNull())

        // Mezclamos los índices para que no salgan siempre en el mismo orden
        mezclarPosicionesAleatorias()

        for (opcionIndex in 0 until contenedorOpciones.childCount) {
            val opcion = contenedorOpciones.getChildAt(opcionIndex)
            if (opcion is LinearLayout)
                colocarOpcionEnVista(opcion, posicionesAleatorias[opcionIndex])
        }
    }
    private fun colocarOpcionEnVista(opcionLayout: LinearLayout, posicionAleatoria: Int) {
        setImageOption(opcionLayout, posicionAleatoria)
        setTextOption(opcionLayout, posicionAleatoria)
    }
    private fun setTextOption(opcionLayout: LinearLayout, posicionAleatoria: Int) {
        val textView: TextView = opcionLayout.getChildAt(1) as TextView
        textView.text = LeccionesJSON.palabras[posicionAleatoria].enEspanol.firstOrNull()
    }
    private fun setImageOption(opcionLayout: LinearLayout, posicionAleatoria: Int) {
        val imageView: ImageView = opcionLayout.getChildAt(0) as ImageView
        val directionImagen: String = LeccionesJSON.palabras[posicionAleatoria].imagen
        LoadImage.loadInto(imageView, directionImagen)
    }
    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdaderaLL(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0],
            getOptionsAsList()
        )
    }
}