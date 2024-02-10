package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras
import com.google.android.flexbox.FlexboxLayout

class Dinamica6 (fragment: Fragment) {
    private var fragment : Fragment
    private var imagen: ImageView
    private var title: TextView
    private var campoRespuesta: TextView
    private var opciones: FlexboxLayout
    private var btnComprobar: Button

    private var posicionRespuestaCorrecta = 0


    init {
        this.fragment = fragment
        this.imagen = fragment.requireView().findViewById(R.id.imagen6)
        this.title = fragment.requireView().findViewById(R.id.txtTitle6)
        this.campoRespuesta = fragment.requireView().findViewById(R.id.campoRespuesta)
        this.opciones = fragment.requireView().findViewById(R.id.flContenedorBotones6)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar6)
    }
    fun configurar(){

        //Generamos numeros randomicos para obtener palabras de la lista en posiciones aleatorias
        val posicionesRandomicas = PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(opciones.childCount, sinOraciones = true)

        asignarRespuestaCorrecta(posicionesRandomicas)
        colocarDatosEnLaVista(posicionesRandomicas)
    }
    private fun asignarRespuestaCorrecta(posicionesRandomicas: List<PosicionParaAñadirALaVista>) {
        //Usamos como palabra principal de la dinamica la primera opcion de la lista de opciones que salió
        posicionRespuestaCorrecta = posicionesRandomicas.first().numero
        LeccionesJSON.palabras[posicionRespuestaCorrecta].palabraCorrecta = true
    }
    private fun colocarDatosEnLaVista(posicionesRandomicas: List<PosicionParaAñadirALaVista>) {
        //Colocamos como titulo la palabra principal en aymara que servirá de guia para el usuario para traducirla al español
        title.text =
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]

        //Colocamos la imagen de la opcion
        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until opciones.childCount) {
            var opcionRandom: PosicionParaAñadirALaVista
            do {
                opcionRandom = posicionesRandomicas[(posicionesRandomicas.indices).random()]
            } while (opcionRandom.fueAñadido)

            //Colocamos el texto de la opcion
            (opciones.getChildAt(i) as Button).text =
                LeccionesJSON.palabras[opcionRandom.numero].enAymara[0]

            opcionRandom.fueAñadido = true
        }
        iniciarDinamica()
    }

    fun iniciarDinamica(){
        val listButton = mutableListOf<Button>()
        for(i in 0 until opciones.childCount){
            listButton.add(opciones.getChildAt(i) as Button)
        }

         opcionMultipleDePalabras().palabraVerdadera(
            listButton,
            palabraCorrecta = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0],
            palabraElegida = campoRespuesta,
            botonComprobar = btnComprobar
        )
    }
}