package com.example.aymarswi.model.textoLecciones

import android.annotation.SuppressLint
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.util.dinamicas.OrdenarPalabras
import com.google.android.flexbox.FlexboxLayout

class Dinamica7(fragment: Fragment) : BaseDinamica(fragment) {

    private var contenedorOracionRespuesta: LinearLayout
    private var txtPalabraPrincipalTraducida: TextView
    private lateinit var palabraPrincipal: Palabra


    init {
        this.contenedorOracionRespuesta = fragment.requireView().findViewById(R.id.etContenPalabra)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.flContenedorOpciones7)
        this.imagen = fragment.requireView().findViewById(R.id.imagen7)
        this.title = fragment.requireView().findViewById(R.id.txtTitle7)
        this.txtPalabraPrincipalTraducida = fragment.requireView().findViewById(R.id.txtTitleE7)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar16)

        configurar(sinOraciones = false)
    }

    @SuppressLint("SetTextI18n")
    override fun colocarDatosEnLaVista() {
        palabraPrincipal = LeccionesJSON.palabras[posicionRespuestaCorrecta]

        imagen?.let { LoadImage.loadInto(imagen!!, palabraPrincipal.imagen) }

        setTitle(palabraPrincipal.enAymara[0])
        txtPalabraPrincipalTraducida.text = "(${palabraPrincipal.enEspanol[0]})"

        crearBotonesEnContenedorDeOpciones(
            (this.palabraPrincipal.enAymara[0].split(if (palabraPrincipal.esOracion) " " else "")
                .toMutableList())
        )
    }

    private fun crearBotonesEnContenedorDeOpciones(oracionDividida: MutableList<String>) {

        val palabrasFiltradas = deleteSpaceBlankAndEmpty(oracionDividida)

        palabrasFiltradas.shuffle()

        for (opcionIndex in 0 until palabrasFiltradas.size) {
            contenedorOpciones.addView(CrearBoton().crearButtonTexto(palabrasFiltradas[opcionIndex]))
        }
    }

    private fun deleteSpaceBlankAndEmpty(oracionDividida: MutableList<String>) =
        oracionDividida.filter { it.trim().isNotEmpty() }.toMutableList()


    override fun iniciarDinamica() {
        OrdenarPalabras(
            contenedorOpciones as FlexboxLayout, contenedorOracionRespuesta, btnComprobar
        ).initDynamic(palabraPrincipal.enAymara[0])
    }
}