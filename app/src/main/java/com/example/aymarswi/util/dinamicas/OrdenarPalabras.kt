package com.example.aymarswi.util.dinamicas

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.util.Actividad
import com.example.aymarswi.model.textoLecciones.CrearBoton
import com.google.android.flexbox.FlexboxLayout

class OrdenarPalabras(
    contenedorPalabras: FlexboxLayout,
    contenedorOracionRespuesta: LinearLayout,
    botonComprobar: Button
) :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.contenedorDeFragments) {

    private var contenedorPalabras: FlexboxLayout
    private var contenedorOracionRespuesta: LinearLayout
    private lateinit var oracion: String
    private var botonComprobar: Button

    init {
        this.contenedorPalabras = contenedorPalabras
        this.contenedorOracionRespuesta = contenedorOracionRespuesta
        this.botonComprobar = botonComprobar
    }

    fun initDynamic(oracion: String) {
        this.oracion = oracion.trim()
        Actividad.getInstanceActividad().setPalabraCorrecta(this.oracion)
        colocarOnClicks()
        clickBotonComprobar()
    }

    private fun clickBotonComprobar() {
        botonComprobar.setOnClickListener { verifyResponse() }
    }

    private fun colocarOnClicks() {
        for(i in 0 until contenedorPalabras.childCount){
            contenedorPalabras.getChildAt(i).setOnClickListener {
                colocarEnOtroContenedor(contenedorPalabras.getChildAt(i) as TextView)
            }
        }
    }


    private fun esOracion(): Boolean {
        return oracion.contains(" ")
    }

    private fun colocarEnOtroContenedor(buttonTexto: TextView) {
        if (buttonTexto.parent == contenedorOracionRespuesta) {
            for (i in 0 until contenedorPalabras.childCount) {
                val botonComparar = contenedorPalabras.getChildAt(i) as TextView
                if (buttonTexto.text.toString() == botonComparar.text.toString()) {
                    botonComparar.visibility = View.VISIBLE
                    contenedorOracionRespuesta.removeView(buttonTexto)
                }
            }
        } else {
            val textCreado = CrearBoton().crearButtonTexto(buttonTexto.text.toString())
            textCreado.setOnClickListener { colocarEnOtroContenedor(textCreado) }
            contenedorOracionRespuesta.addView(textCreado)
            buttonTexto.visibility = View.INVISIBLE
        }
        Log.d("LETRA", "${buttonTexto.text}")
    }

    private fun verifyResponse() {
        getInstanceActividad().respuesta(joinText().equals(oracion, ignoreCase = true))
        Log.d("LETRA", "${joinText()}, ${oracion}")
    }

    private fun joinText(): String {
        var oracionUnida = ""
        for (i in 0 until contenedorOracionRespuesta.childCount)
            oracionUnida += (contenedorOracionRespuesta.getChildAt(i) as TextView).text.toString() + if (esOracion()) " " else ""

        return oracionUnida.trim()
    }
}