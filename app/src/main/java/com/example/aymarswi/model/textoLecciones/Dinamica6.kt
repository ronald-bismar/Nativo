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

class Dinamica6(fragment: Fragment) {
    private var fragment: Fragment
    private var imagen: ImageView
    private var title: TextView
    private var campoRespuesta: TextView
    private var contenedorOpcionesDeBotones: FlexboxLayout
    private var btnComprobar: Button
    private var posicionRespuestaCorrecta = 0

    init {
        this.fragment = fragment
        this.imagen = fragment.requireView().findViewById(R.id.imagen6)
        this.title = fragment.requireView().findViewById(R.id.txtTitle6)
        this.campoRespuesta = fragment.requireView().findViewById(R.id.campoRespuesta)
        this.contenedorOpcionesDeBotones = fragment.requireView().findViewById(R.id.flContenedorBotones6)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar6)
    }

    fun configurar() {

        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        val posicionesRandomicas =
            PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(
                contenedorOpcionesDeBotones.childCount + 1,
                sinOraciones = true
            )

        asignarRespuestaCorrecta(posicionesRandomicas)
        colocarDatosEnLaVista(posicionesRandomicas.toMutableList())
        iniciarDinamica()
    }

    private fun asignarRespuestaCorrecta(posicionesRandomicas: List<Int>) {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first()
        LeccionesJSON.palabras[posicionRespuestaCorrecta].palabraCorrecta = true
    }

    private fun colocarDatosEnLaVista(posicionesRandomicas: MutableList<Int>) {

        title.text = LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]

        // Colocamos la imagen de la opción
        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)

        /*Añadimos los datos a la vista de forma que no estén en el mismo orden cada vez (para eso se usan números aleatorios)*/
        for (i in 0 until contenedorOpcionesDeBotones.childCount) {
            val indexRandom = (posicionesRandomicas.indices).random()

            // Eliminamos el elemento seleccionado de la lista
            posicionesRandomicas.removeAt(indexRandom)

            // Colocamos el texto de la opción
            (contenedorOpcionesDeBotones.getChildAt(i) as Button).text = LeccionesJSON.palabras[indexRandom].enAymara[0]
        }
    }
    fun iniciarDinamica() {
      opcionMultipleDePalabras().palabraVerdadera(
            obtenerOpcionesComoLista(),
            palabraCorrecta = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0],
            palabraElegida = campoRespuesta,
            botonComprobar = btnComprobar
        )
    }
    private fun obtenerOpcionesComoLista(): MutableList<Button> {
        val listaBotones = mutableListOf<Button>()
        for (i in 0 until contenedorOpcionesDeBotones.childCount) {
            listaBotones.add(contenedorOpcionesDeBotones.getChildAt(i) as Button)
        }
        return listaBotones
    }
}