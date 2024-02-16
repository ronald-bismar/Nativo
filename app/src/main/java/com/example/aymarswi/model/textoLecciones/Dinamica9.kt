package com.example.aymarswi.model.textoLecciones

import DeslizarPalabras
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.aymarswi.R

class Dinamica9(fragment: Fragment): BaseDinamica (fragment){

    private var contenedorPalabrasEnEspanol: ConstraintLayout
    private var posicionesRandomicasBotones = mutableListOf<Int>()

    init {
        contenedorPalabrasEnEspanol = fragment.requireView().findViewById(R.id.contenedorPalabrasEnCastellanoD9)
        contenedorOpciones = fragment.requireView().findViewById(R.id.contenedorOpcionesParaArrastrarD9)
        configurar(sinOraciones = true)
    }
    override fun colocarDatosEnLaVista() {
        posicionesRandomicasBotones = posicionesRandomicas.toMutableList()
        colocarPalabrasEnEspanol()
        colocarOpcionesEnAymara()
    }

    override fun iniciarDinamica() {
       DeslizarPalabras().deslizarPalabras(contenedorPalabrasEnEspanol, contenedorOpciones)
    }
    fun determinarAltoDeLaPalabraEnEspañol(texto: TextView){
        if(!texto.toString().all { it.isDigit() }){
            val layoutParams = LinearLayout.LayoutParams(300, 120)
            texto.layoutParams = layoutParams
            texto.textSize = 30F
        }
    }
    fun colocarPalabrasEnEspanol(){
        for (i in 0 until contenedorPalabrasEnEspanol.childCount){
            val indexRandom = (0 until posicionesRandomicas.size).random()
            val campoEspanol = contenedorPalabrasEnEspanol.getChildAt(i) as LinearLayout
            ( campoEspanol.getChildAt(0) as TextView ).text = LeccionesJSON.palabras[posicionesRandomicas[indexRandom]].enEspanol[0]

            colocarTag( campoEspanol.getChildAt(1) as TextView, indexRandom )

            determinarAltoDeLaPalabraEnEspañol(campoEspanol.getChildAt(0) as TextView)

            posicionesRandomicas.removeAt(indexRandom)
        }
    }

    private fun colocarOpcionesEnAymara() {
        for (i in 0 until contenedorPalabrasEnEspanol.childCount){
            val indexRandom = (0 until posicionesRandomicasBotones.size).random()
            ( contenedorOpciones.getChildAt(i) as TextView ).text = LeccionesJSON.palabras[posicionesRandomicasBotones[indexRandom]].enAymara[0]

            colocarTag(contenedorOpciones.getChildAt(i) as TextView, indexRandom)

            posicionesRandomicasBotones.removeAt(indexRandom)
        }
    }

    private fun colocarTag(textView: TextView, indexRandom: Int) {
        textView.tag = LeccionesJSON.palabras[posicionesRandomicasBotones[indexRandom]].enAymara[0]
    }

}