package com.example.aymarswi.model.textoLecciones

import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.util.dinamicas.OpcionMultipleDePalabras

class Dinamica3(fragment: Fragment) : BaseDinamica(fragment) {

    private lateinit var palabraPrincipal: Palabra
    private var respuestaUsuario: EditText

    init {
        this.title = fragment.requireView().findViewById(R.id.txtTitle3)
        this.imagen = fragment.requireView().findViewById(R.id.imagen3)
        this.respuestaUsuario = fragment.requireView().findViewById(R.id.txtRespuesta3)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar3)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones3)

        configurar(sinOraciones = false)
    }

    override fun colocarDatosEnLaVista() {
        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]
        //Colocamos como titulo la palabra principal en español que servirá de guia para el usuario para traducirla al español
        setTitle("COMO SE ESCRIBE ${palabraPrincipal.enEspanol[0].uppercase()}?")
        //Colocamos la imagen de la opcion
        imagen?.let { LoadImage.loadInto(imagen!!, palabraPrincipal.imagen) }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            // No se da un indice ya que el usuario podrá escribir distintos derivados de la palabra u oracion
            palabraPrincipal.enAymara,  palabraElegida = respuestaUsuario, botonComprobar = btnComprobar,
        )
    }
}