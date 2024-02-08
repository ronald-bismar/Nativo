package com.example.aymarswi.model.textoLecciones

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.ClaseFamilia.FragmentDinamica5
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras
import com.example.aymarswi.model.textoLecciones.LeccionesJSON.getOracionPrincipal

class Dinamica5(fragment: FragmentDinamica5) {
    private var fragment: Fragment
    private var oracionIncompleta: LinearLayout
    private var botones: LinearLayout
    private var btnComprobar: Button

    private var posicionPalabraFaltante: Int = 0
    private lateinit var oracionPrincipal: String
    private lateinit var posicionesRandomicas: List<PosicionParaAñadirALaVista>
    private lateinit var palabrasDivididas: List<String>

    init {
        this.fragment = fragment
        this.oracionIncompleta = fragment.requireView().findViewById(R.id.llOracionIncompleta)
        this.botones = fragment.requireView().findViewById(R.id.llBotones)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar5)
    }

    fun configurar() {

        //Para remover todas las vistas de el contenedor linearlayout

        this.oracionPrincipal = getOracionPrincipal().enAymara[0]
        palabrasDivididas = dividirOracionPrincipal()

        posicionPalabraFaltante = (palabrasDivididas.indices).random()

        agregarTextViewAlContenedor(palabrasDivididas, posicionPalabraFaltante)

        agregarBotonesDeRespuesta()

    }

    private fun agregarBotonesDeRespuesta() {
        posicionesRandomicas =
            PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(1, true)
        colocarDatosEnLaVista()
    }

    private fun agregarTextViewAlContenedor(
        palabrasDivididas: List<String>,
        posicionRandomica: Int
    ) {
        for (i in palabrasDivididas.indices) {
            val texto = crearTextView(palabrasDivididas[i])
            if (i == posicionRandomica) {
                oracionIncompleta.addView(texto)
                oracionIncompleta.getChildAt(i).visibility = View.INVISIBLE
                oracionIncompleta.getChildAt(i).setBackgroundResource(R.drawable.bordesrplomo)
            } else
                oracionIncompleta.addView(texto)
        }
    }

    private fun crearTextView(palabra: String): TextView {
        val texto = TextView(Actividad.instance?.context)
        texto.text = palabra
        return texto
    }

    private fun dividirOracionPrincipal(): List<String> {
        return oracionPrincipal.trim().split(" ")
    }

    private fun colocarDatosEnLaVista() {

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until botones.childCount) {
            var opcionRandom: PosicionParaAñadirALaVista
            do {
                opcionRandom = posicionesRandomicas[(posicionesRandomicas.indices).random()]
            } while (opcionRandom.fueAñadido)

            //Colocamos el texto de la opcion
            (botones.getChildAt(i) as TextView).text =
                if(i == posicionPalabraFaltante)palabrasDivididas[posicionPalabraFaltante] else LeccionesJSON.palabras[opcionRandom.numero].enAymara[0]

            opcionRandom.fueAñadido = true
        }
        iniciarDinamica()
    }

    private fun iniciarDinamica() {

        val listaBotones = mutableListOf<Button>()
        for (i in 0 until botones.size){
            listaBotones.add(botones.getChildAt(i) as Button)
        }

        opcionMultipleDePalabras().palabraVerdadera(
            listaBotones,
            palabraCorrecta = palabrasDivididas[posicionPalabraFaltante],
            palabraElegida = oracionIncompleta.getChildAt(posicionPalabraFaltante) as TextView,
            botonComprobar = btnComprobar,
        )
    }
}