package com.example.aymarswi.model.textoLecciones

import DeslizarPalabras
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.aymarswi.R

class Dinamica9(fragment: Fragment) : BaseDinamica(fragment) {

    private var contenedorPalabrasEnEspanol: ConstraintLayout

    init {
        contenedorPalabrasEnEspanol =
            fragment.requireView().findViewById(R.id.contenedorPalabrasEnCastellanoD9)
        contenedorOpciones =
            fragment.requireView().findViewById(R.id.contenedorOpcionesParaArrastrarD9)

        configurar(sinOraciones = true)
    }

    override fun colocarDatosEnLaVista() {
        colocarPalabrasEnEspanol()
        colocarOpcionesEnAymara()
    }

    fun determinarAltoDeLaPalabraEnEspañol(texto: TextView) {
        if (!texto.toString().all { it.isDigit() }) {
            val layoutParams = LinearLayout.LayoutParams(300, 120)
            texto.layoutParams = layoutParams
            texto.textSize = 30F
        }
    }

    fun colocarPalabrasEnEspanol() {
        mezclarPosicionesAleatorias()
        for (indexOpcion in 0 until contenedorPalabrasEnEspanol.childCount) {
            val campoEspanol = contenedorPalabrasEnEspanol.getChildAt(indexOpcion)
            if (campoEspanol is LinearLayout) {
                setTextAndTag(
                    (campoEspanol.getChildAt(0) as TextView),
                    text = LeccionesJSON.palabras[posicionesAleatorias[indexOpcion]].enEspanol[0]
                )
                setTextAndTag(
                    (campoEspanol.getChildAt(1) as TextView),
                    tag = LeccionesJSON.palabras[posicionesAleatorias[indexOpcion]].enAymara[0]
                )
                determinarAltoDeLaPalabraEnEspañol(campoEspanol.getChildAt(0) as TextView)
            }
        }
    }

    private fun colocarOpcionesEnAymara() {
        mezclarPosicionesAleatorias()
        for (indexOpcion in 0 until contenedorPalabrasEnEspanol.childCount) {
            val opcion = contenedorOpciones.getChildAt(indexOpcion)
            if (opcion is TextView) {
                val palabra = LeccionesJSON.palabras[posicionesAleatorias[indexOpcion]].enAymara[0]
                setTextAndTag(opcion, text = palabra, tag = palabra)
            }
        }
    }

    fun setTextAndTag(textView: TextView, text: String = "", tag: String = "") {
        textView.text = text
        textView.tag = tag
    }

    override fun iniciarDinamica() {
        DeslizarPalabras().deslizarPalabras(contenedorPalabrasEnEspanol, contenedorOpciones)
    }
}