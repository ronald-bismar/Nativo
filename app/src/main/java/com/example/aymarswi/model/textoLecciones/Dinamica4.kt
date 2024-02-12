package com.example.aymarswi.model.textoLecciones

import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica4(fragment: Fragment): BaseDinamica(fragment) {

    private var oracion: TextView
    private var respuestaUsuario: EditText

    init {
        this.imagen = fragment.requireView().findViewById(R.id.imagen4)
        this.oracion = fragment.requireView().findViewById(R.id.txtOracion4)
        this.respuestaUsuario = fragment.requireView().findViewById(R.id.txtRespuesta4)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar4)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones4)

        configurar(sinOraciones = false)
    }


    override fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en aymara que servirá de guia para el usuario para traducirla al español
        oracion.text = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]
    }

    override fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol,
            palabraElegida = respuestaUsuario,
            botonComprobar = btnComprobar,
        )
    }
}