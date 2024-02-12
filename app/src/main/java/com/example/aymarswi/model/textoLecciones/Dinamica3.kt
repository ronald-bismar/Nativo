package com.example.aymarswi.model.textoLecciones

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class Dinamica3(fragment: Fragment): BaseDinamica(fragment) {

   private var respuestaUsuario: EditText

    init {
        this.title = fragment.requireView().findViewById(R.id.txtTitle3)
        this.imagen = fragment.requireView().findViewById(R.id.imagen3)
        this.respuestaUsuario = fragment.requireView().findViewById(R.id.txtRespuesta3)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar3)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.llContenedorOpciones3)

        configurar(sinOraciones = false)
    }

    @SuppressLint("SetTextI18n")
    override fun colocarDatosEnLaVista() {
        //Colocamos como titulo la palabra principal en español que servirá de guia para el usuario para traducirla al español
        title.text =
            "COMO SE ESCRIBE ${LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0].uppercase()}?"

        //Colocamos la imagen de la opcion
        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)
    }

    override fun iniciarDinamica() {
        opcionMultipleDePalabras().palabraVerdadera(
            LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara, // No se da un indice ya que el usuario podrá escribir distintos derivados de la palabra u oracion
            palabraElegida = respuestaUsuario as EditText,
            botonComprobar = btnComprobar,
        )
    }
}