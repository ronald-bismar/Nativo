package com.example.aymarswi.Util.dinamicas

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
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
        Log.d("oracion", "oracion dividida ${this.oracion.length}")
        crearBotonesEnContenedor(this.oracion.split(if (esOracion()) " " else ""))
        botonComprobar.setOnClickListener { verifyResponse() }
        instance!!.setPalabraCorrecta(oracion)
    }

    private fun esOracion(): Boolean {
        return oracion.contains(" ")
    }

    private fun crearBotonesEnContenedor(oracionDividida: List<String>) {
        for (i in if (esOracion()) oracionDividida.indices else 1 until oracionDividida.size - 1)
            contenedorPalabras.addView(crearButtonTexto(oracionDividida[i]))
    }

    private fun crearButtonTexto(palabra: String): TextView {

        val buttonTexto = TextView(instance!!.context)
        buttonTexto.text = palabra

        buttonStyle(buttonTexto)

        buttonTexto.layoutParams = FlexboxLayout.LayoutParams(
            FlexboxLayout.LayoutParams.WRAP_CONTENT,
            FlexboxLayout.LayoutParams.WRAP_CONTENT
        )

        buttonTexto.setOnClickListener { colocarEnOtroContenedor(buttonTexto) }

        return buttonTexto
    }

    private fun buttonStyle(buttonTexto: TextView) {

        buttonTexto.setTextColor(ContextCompat.getColor(instance!!.context, R.color.colorWhite))
        buttonTexto.textSize = 30F
        buttonTexto.typeface = ResourcesCompat.getFont(instance!!.context, R.font.linotteregular)
        buttonTexto.isClickable = true
        buttonTexto.setBackgroundResource(R.color.colorPurple)
        buttonTexto.setPadding(20, 10, 20, 10)
    }

    private fun colocarEnOtroContenedor(buttonTexto: TextView) {
        if (buttonTexto.parent == contenedorOracionRespuesta) {
            for (i in 0 until contenedorPalabras.childCount) {
                val botonComparar = contenedorPalabras.getChildAt(i) as TextView
                if (buttonTexto.text.toString() == botonComparar.text.toString()) {
                    botonComparar.visibility = View.VISIBLE
                    buttonTexto.visibility = View.GONE
                }
            }
        } else {
            contenedorOracionRespuesta.addView(crearButtonTexto(buttonTexto.text.toString()))
            buttonTexto.visibility = View.INVISIBLE
        }
    }

    private fun verifyResponse() {
        getInstanceActividad().respuesta(joinText().equals(oracion, ignoreCase = true))
    }

    private fun joinText(): String {
        var oracionUnida = ""
        for (i in 0 until contenedorOracionRespuesta.childCount)
            oracionUnida += (contenedorPalabras.getChildAt(i) as TextView).text.toString() + if (esOracion()) " " else ""

        return oracionUnida.trim()
    }
}