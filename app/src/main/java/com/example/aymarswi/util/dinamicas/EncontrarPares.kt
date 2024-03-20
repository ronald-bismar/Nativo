package com.example.aymarswi.util.dinamicas

import android.graphics.Color
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.aymarswi.R
import com.example.aymarswi.util.Actividad

open class EncontrarPares :
    Actividad(AppCompatActivity(), AppCompatActivity(), R.id.contenedorDeFragments) {

    private lateinit var contenedorOpcionesEnEspanol: LinearLayout
    private lateinit var contenedorOpcionesEnAymara: LinearLayout
    private var selectedOptionEspanol: Boolean = false
    private var selectedOptionAymara: Boolean = false
    private var buttonAuxEspanol: Button? = null
    private var buttonAuxAymara: Button? = null

    fun initDinamic(
        contenedorOpcionesEnEspanol: LinearLayout,
        contenedorOpcionesEnAymara: LinearLayout
    ) {
        this.contenedorOpcionesEnEspanol = contenedorOpcionesEnEspanol
        this.contenedorOpcionesEnAymara = contenedorOpcionesEnAymara
        configureOnClick(this.contenedorOpcionesEnAymara)
        configureOnClick(this.contenedorOpcionesEnEspanol)
    }

    private fun configureOnClick(contenedorOpciones: LinearLayout) {
        contenedorOpciones.children.forEach { view ->
            if (view is Button) {
                view.setOnClickListener { buttonPressed(view) }
            }
        }
    }

    private fun buttonPressed(view: Button) {
        if (view.parent == contenedorOpcionesEnEspanol) {
            if (!selectedOptionEspanol) {
                view.setTextColor(Color.GREEN)
                selectedOptionEspanol = true
            } else {
                if (view == buttonAuxEspanol) {
                    view.setTextColor(Color.BLACK)
                    selectedOptionEspanol = false
                } else {
                    view.setTextColor(Color.GREEN)
                    buttonAuxEspanol?.setTextColor(Color.BLACK)
                }
            }
            buttonAuxEspanol = view
        }
        if (view.parent == contenedorOpcionesEnAymara) {
            if (!selectedOptionAymara) {
                view.setTextColor(Color.GREEN)
                selectedOptionAymara = true
            } else {
                if (view == buttonAuxAymara) {
                    view.setTextColor(Color.BLACK)
                    selectedOptionAymara = false
                } else {
                    view.setTextColor(Color.GREEN)
                    buttonAuxAymara?.setTextColor(Color.BLACK)
                }
            }
            buttonAuxAymara = view
        }
        if (selectedOptionEspanol && selectedOptionAymara)
            verificarRespuesta(buttonAuxEspanol, buttonAuxAymara)
    }

    private fun verificarRespuesta(buttonAuxEspañol: Button?, buttonAuxAymara: Button?) {
        if (buttonAuxEspañol?.tag.toString() == buttonAuxAymara?.tag.toString()) {
            Toast.makeText(getInstanceActividad().context, "Correcto", Toast.LENGTH_SHORT).show()
            dissabledButtons(listOf(buttonAuxEspañol, buttonAuxAymara))
        } else
            Toast.makeText(getInstanceActividad().context, "Incorrecto", Toast.LENGTH_SHORT).show()
        restauredButtons(listOf(buttonAuxEspañol, buttonAuxAymara))
    }

    private fun restauredButtons(buttons: List<Button?>) {
        buttons.forEach { button -> button?.setTextColor(Color.BLACK) }
        reinitSelected()
    }

    private fun reinitSelected() {
        selectedOptionEspanol = false
        selectedOptionAymara = false
    }

    private fun dissabledButtons(listButtonsSelected: List<Button?>) {
        listButtonsSelected.forEach { button ->
            button?.setTextColor(Color.BLACK)
            button?.alpha = 0.5f
            button?.isClickable = false
        }
        realizarAccionesCuandoTodosLosBotonesDesactivados()
    }
    private fun verificarTodosLosBotonesDesactivados(): Boolean {
        return !contenedorOpcionesEnEspanol.children.any { it.isClickable }
                && !contenedorOpcionesEnAymara.children.any { it.isClickable }
    }

    private fun realizarAccionesCuandoTodosLosBotonesDesactivados() {
        if (verificarTodosLosBotonesDesactivados()) {
            instance!!.respuesta(true)
        }
    }
}