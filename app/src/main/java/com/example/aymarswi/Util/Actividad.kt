package com.example.aymarswi.Util

import android.app.AlertDialog
import android.content.Context
import android.media.MediaPlayer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.aymarswi.ClaseFamilia.FragmentFamilia1
import com.example.aymarswi.ClaseFamilia.FragmentFamilia10
import com.example.aymarswi.ClaseFamilia.FragmentFamilia2
import com.example.aymarswi.ClaseFamilia.FragmentFamilia3
import com.example.aymarswi.ClaseFamilia.FragmentFamilia4
import com.example.aymarswi.ClaseFamilia.FragmentFamilia5
import com.example.aymarswi.ClaseFamilia.FragmentFamilia6
import com.example.aymarswi.ClaseFamilia.FragmentFamilia7
import com.example.aymarswi.ClaseFamilia.FragmentFamilia8
import com.example.aymarswi.ClaseFamilia.FragmentFamilia9
import com.example.aymarswi.PantallasPrincipales.FragmentBien
import com.example.aymarswi.PantallasPrincipales.FragmentMalo
import com.example.aymarswi.PantallasPrincipales.FragmentRegular
import com.example.aymarswi.PantallasPrincipales.FragmentRegular2
import com.example.aymarswi.PantallasPrincipales.FragmentRegular3
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.OrdenarPalabras
import com.example.aymarswi.Util.dinamicas.escribirPalabraYVerificar
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

open class Actividad(activity: AppCompatActivity, context: AppCompatActivity, containerFragment: Int) {


    var activity: AppCompatActivity
    var context: Context
    lateinit var rootView: View
    var containerFragment: Int = 0
    private lateinit var nextFragment: Fragment
    var posicionDeLaRutaDeFragments = 1
    var correcto: Boolean = false
    var puntaje = 0
    var rutaDeFragments: List<Fragment> = listOf(
        FragmentFamilia1(),
        FragmentFamilia2(),
        FragmentFamilia3(),
        FragmentFamilia4(),
        FragmentFamilia5(),
        FragmentFamilia6(),
        FragmentFamilia7(),
        FragmentFamilia8(),
        FragmentFamilia9(),
        FragmentFamilia10()
    )
    lateinit var escribirPalabraYVerificar: escribirPalabraYVerificar
    lateinit var opcionMultipleDePalabras: opcionMultipleDePalabras
    lateinit var ordenarPalabras: OrdenarPalabras
    init {
        this.activity = activity as AppCompatActivity
        this.context = context as AppCompatActivity
        this.containerFragment = containerFragment
    }

    fun respuestaCorrecta() {
        ++puntaje
        sonido()
        showAlertDialog()
    }

    fun respuestaIncorrecta() {
        sonido()
        showAlertDialog()
    }

    fun sonido() {
        MediaPlayer.create(
            context,
            if (correcto) R.raw.sonidorespuestacorrecta1 else R.raw.respuestaincorrecta1
        ).start()
    }

    fun showAlertDialog() {
        val view = View.inflate(
            context,
            if (correcto) R.layout.dialog_correcto else R.layout.dialog_incorrecto,
            null
        )

        viewInflate(view)
    }

    fun viewInflate(view: View) {
        val builder = AlertDialog.Builder(context).setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            if (posicionDeLaRutaDeFragments <= rutaDeFragments.size) pasarDeFragment()
            else determinarPuntajeFinal()
        }
    }

    fun determinarPuntajeFinal() {
        nextFragment = if (puntaje == 10) FragmentBien()
        else if (puntaje == 9) FragmentRegular()
        else if (puntaje >= 7) FragmentRegular2()
        else if (puntaje >= 5) FragmentRegular3()
        else FragmentMalo()
        pasarDeFragment()
    }

    fun pasarDeFragment() {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView3, nextFragment).addToBackStack(null).commit()
    }


    fun editTextVacio() {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setView(
            LayoutInflater.from(context).inflate(R.layout.menllenarcampo, null)
        )
        val alertDialog = alertDialogBuilder.create()
        val ventana = alertDialog.window
        ventana?.setGravity(Gravity.BOTTOM)
        val layoutParams = ventana?.attributes
        ventana?.attributes = layoutParams
        alertDialog.show()
    }

    fun respuesta(activity: AppCompatActivity) {
        nextFragment = rutaDeFragments[posicionDeLaRutaDeFragments++]
        if (correcto) respuestaCorrecta()
        else respuestaIncorrecta()
    }

    fun respuesta(correcto: Boolean, activity: AppCompatActivity) {
        this.correcto = correcto
        nextFragment = rutaDeFragments[posicionDeLaRutaDeFragments++]
        if (correcto) respuestaCorrecta()
        else respuestaIncorrecta()
    }
}