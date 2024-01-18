package com.example.aymarswi.Util.dinamicas

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.google.android.flexbox.FlexboxLayout

class OrdenarPalabras :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.fragmentContainerView3) {
    private lateinit var contenedorPalabras: FlexboxLayout
    private lateinit var contenedorOracionRespuesta: LinearLayout

    private fun initObjects(
        contenedorPalabras: FlexboxLayout,
        contenedorOracionRespuesta: LinearLayout
    ) {
        this.contenedorPalabras = contenedorPalabras
        this.contenedorOracionRespuesta = contenedorOracionRespuesta
    }

    fun initDynamic(
        oracion: String, contenedorPalabras: FlexboxLayout, contenedorOracionRespuesta: LinearLayout
    ) {
        Log.d("Oracion", "Oracion recibida:$oracion")
        initObjects(contenedorPalabras, contenedorOracionRespuesta)
        crearBotonesEnContenedor(oracion.split(""))
        habilitarClicks(contenedorPalabras)

    }

    private fun crearBotonesEnContenedor(oracionDividida: List<String>) {
        for (palabra in oracionDividida) contenedorPalabras.addView(crearButtonTexto(palabra))
    }

    private fun crearButtonTexto(palabra: String): TextView {

        val buttonTexto = TextView(instance!!.context)

        buttonTexto.text = palabra
        buttonTexto.setTextColor(ContextCompat.getColor(instance!!.context, R.color.colorBlack))
        buttonTexto.textSize = 30F
        buttonTexto.typeface = ResourcesCompat.getFont(instance!!.context, R.font.linotteregular)
        buttonTexto.isClickable = true
        buttonTexto.setBackgroundResource(R.color.colorYellow)
        buttonTexto.setPadding(20,10,20, 10)

        buttonTexto.layoutParams = FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT)

        return buttonTexto
    }


    private fun habilitarClicks(contenedor: ViewGroup) {
        for (i in 0 until contenedor.childCount) {
            val buttonTexto = contenedor.getChildAt(i) as TextView
            buttonTexto.isClickable = true
            buttonTexto.setOnClickListener {
                colocarEnOtroContenedor(buttonTexto)
            }
            if (contenedor == contenedorPalabras) buttonTexto.visibility = View.VISIBLE
            else buttonTexto.visibility = View.GONE
        }
    }

    private fun colocarEnOtroContenedor(buttonTexto: TextView) {
        Log.d("Click","Se clicko y es verdadero?: ${buttonTexto.parent == contenedorOracionRespuesta}")
        if (buttonTexto.parent == contenedorOracionRespuesta) {
            for (i in 0 until contenedorPalabras.childCount) {
                val botonComparar = contenedorPalabras.getChildAt(i) as TextView
                if (buttonTexto.text.toString() == botonComparar.text.toString()){
                    botonComparar.visibility = View.VISIBLE

                }
            }
            habilitarClicks(contenedorOracionRespuesta)
        } else{
            contenedorOracionRespuesta.addView(crearButtonTexto(buttonTexto.text.toString()))
            buttonTexto.visibility = View.INVISIBLE
        }
    }
}