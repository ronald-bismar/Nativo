package com.example.aymarswi.Util.dinamicas

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class OrdenarPalabras() : Actividad(AppCompatActivity(), AppCompatActivity(), R.id.fragmentContainerView3) {
    private lateinit var contenedorPalabras: LinearLayout
    private lateinit var contenedorOracion: LinearLayout

    private fun initObjects(contenedorPalabras: LinearLayout, contenedorOracion: LinearLayout) {
        this.contenedorPalabras = contenedorPalabras
        this.contenedorOracion = contenedorOracion
    }

    fun initDynamic(
        oracion: String, contenedorPalabras: LinearLayout, contenedorOracion: LinearLayout
    ) {
        initObjects(contenedorPalabras, contenedorOracion)
        crearBotonesEnContenedor(oracion.split(" "))
        clickBoton()
    }

    private fun crearBotonesEnContenedor(oracionDividida: List<String>) {
        for (palabra in oracionDividida) contenedorPalabras.addView(crearBoton(palabra))
    }

    private fun crearBoton(palabra: String): Button {
        val boton = Button(context)
        boton.isAllCaps = false
        boton.setBackgroundColor(Color.parseColor("#9C27B0"))
        boton.setTextColor(Color.parseColor("#FFFFFF"))
        boton.text = palabra
        return boton
    }

    private fun clickBoton() {
        habilitarClicks(contenedorPalabras)
        habilitarClicks(contenedorOracion)
    }

    private fun habilitarClicks(contenedor: LinearLayout) {
        for (i in 0 until contenedor.childCount) {
            val boton = contenedor.getChildAt(i) as Button
            boton.setOnClickListener {
                colocarEnOtroContenedor(boton)
            }
            if (contenedor == contenedorPalabras) boton.visibility = View.INVISIBLE
            else boton.visibility = View.GONE
        }
    }

    private fun colocarEnOtroContenedor(boton: Button) {
        if (boton.parent == contenedorOracion) {
            for (i in 0 until contenedorPalabras.childCount) {
                val botonComparar = contenedorPalabras.getChildAt(i) as Button
                if (boton.text.toString() == botonComparar.text.toString())
                    botonComparar.visibility = View.VISIBLE
            }
        } else
            contenedorOracion.addView(crearBoton(boton.text.toString()))
    }

}