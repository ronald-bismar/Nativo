package com.example.aymarswi.model.textoLecciones

import android.annotation.SuppressLint
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.OrdenarPalabras
import com.google.android.flexbox.FlexboxLayout

class Dinamica7(fragment: Fragment) : BaseDinamica(fragment) {

    private var contenedorOracionRespuesta: LinearLayout
    private var title2: TextView
    private lateinit var texto: Palabra


    init {
        this.contenedorOracionRespuesta = fragment.requireView().findViewById(R.id.etContenPalabra)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.flContenedorOpciones7)
        this.imagen = fragment.requireView().findViewById(R.id.imagen7)
        this.title = fragment.requireView().findViewById(R.id.txtTitle7)
        this.title2 = fragment.requireView().findViewById(R.id.txtTitleE7)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar16)

        configurar(sinOraciones = false)
    }

    @SuppressLint("SetTextI18n")
    override fun colocarDatosEnLaVista() {
        texto = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        Glide.with(Actividad.getInstanceActividad().context)
            .load(LeccionesJSON.palabras[posicionRespuestaCorrecta].imagen)
            .into(imagen)

        title.text = LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0]
        title2.text = "(${LeccionesJSON.palabras[posicionRespuestaCorrecta].enEspanol[0]})"
        crearBotonesEnContenedor(
            (this.texto.enAymara[0].trim().split(if (texto.esOracion) " " else "").toMutableList())
        )
    }

    private fun crearBotonesEnContenedor(oracionDividida: MutableList<String>) {

        var rangoDePalabras =
            if (texto.esOracion) oracionDividida.indices else 1 until oracionDividida.size - 1
        for (i in rangoDePalabras) {
            val indexRandom = (rangoDePalabras).random()
            contenedorOpciones.addView(CrearBoton().crearButtonTexto(oracionDividida[indexRandom]))
            oracionDividida.removeAt(indexRandom)
            rangoDePalabras =
                if (texto.esOracion) oracionDividida.indices else 1 until oracionDividida.size - 1
        }
    }

    override fun iniciarDinamica() {
        OrdenarPalabras(
            contenedorOpciones as FlexboxLayout, contenedorOracionRespuesta, btnComprobar
        ).initDynamic(LeccionesJSON.palabras[posicionRespuestaCorrecta].enAymara[0])
    }

}