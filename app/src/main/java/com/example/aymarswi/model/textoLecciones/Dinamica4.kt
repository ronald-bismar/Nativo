package com.example.aymarswi.model.textoLecciones

import android.os.Build
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.util.dinamicas.OpcionMultipleDePalabras

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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en aymara que servirá de guia para el usuario para traducirla al español
        oracion.text = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol,
            palabraElegida = respuestaUsuario,
            botonComprobar = btnComprobar,
        )
    }
}