package com.example.aymarswi.Util

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.media.MediaPlayer
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.aymarswi.ClaseFamilia.FragmentDinamica1
import com.example.aymarswi.ClaseFamilia.FragmentFamilia10
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2
import com.example.aymarswi.ClaseFamilia.FragmentDinamica3
import com.example.aymarswi.ClaseFamilia.FragmentDinamica4
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2v1
import com.example.aymarswi.ClaseFamilia.FragmentDinamica5
import com.example.aymarswi.ClaseFamilia.FragmentFamilia7
import com.example.aymarswi.ClaseFamilia.FragmentFamilia8
import com.example.aymarswi.ClaseFamilia.FragmentFamilia9
import com.example.aymarswi.PantallasPrincipales.FragmentBien
import com.example.aymarswi.PantallasPrincipales.FragmentMalo
import com.example.aymarswi.PantallasPrincipales.FragmentRegular
import com.example.aymarswi.PantallasPrincipales.FragmentRegular2
import com.example.aymarswi.PantallasPrincipales.FragmentRegular3
import com.example.aymarswi.R

open class Actividad protected constructor(
    activity: AppCompatActivity,
    context: AppCompatActivity,
    containerFragment: Int
) {


    var activity: AppCompatActivity
    var context: Context
    lateinit var rootView: View
    var containerFragment: Int = 0
    private lateinit var nextFragment: androidx.fragment.app.Fragment
    var posicionDeLaRutaDeFragments = 0
    var correcto: Boolean = false
    var puntaje = 0
    private var palabraCorrecta = ""
    var rutaDeFragments: List<androidx.fragment.app.Fragment> = listOf(
        FragmentDinamica1(),
        FragmentDinamica2(),
        FragmentDinamica3(),
        FragmentDinamica4(),
        FragmentDinamica2v1(),
        FragmentDinamica5(),
        FragmentFamilia7(),
        FragmentFamilia8(),
        FragmentFamilia9(),
        FragmentFamilia10()
    )

    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: Actividad? = null

        fun getInstance(
            activity: AppCompatActivity,
            context: AppCompatActivity,
            containerFragment: Int
        ): Actividad {
            if (instance == null) {
                instance = Actividad(activity, context, containerFragment)
            }
            return instance as Actividad
        }

        fun getInstanceActividad() = instance as Actividad

        fun setContext(activity: AppCompatActivity, context: Context, containerFragment: Int) {
            instance?.activity = activity
            instance?.context = context
            instance?.containerFragment = containerFragment
        }
    }

    init {
        this.activity = activity
        this.context = context
        this.containerFragment = containerFragment
    }

    fun setPalabraCorrecta(palabraCorrecta: String) {
        this.palabraCorrecta = palabraCorrecta
    }

    fun mostrarAlertDialog() {
        sonido()
        showAlertDialog()
    }

    fun sonido() {
        MediaPlayer.create(
            instance?.context,
            if (instance!!.correcto) R.raw.sonidorespuestacorrecta1 else R.raw.respuestaincorrecta1
        ).start()
    }

    private fun showAlertDialog() {
        val view = View.inflate(
            instance?.context,
            if (instance!!.correcto) R.layout.dialog_correcto else R.layout.dialog_incorrecto,
            null
        )
        view.findViewById<TextView>(R.id.txtRespCorrecta).text = palabraCorrecta

        viewInflate(view)
    }

    fun viewInflate(view: View) {
        val builder = AlertDialog.Builder(instance?.context).setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            if (posicionDeLaRutaDeFragments < instance?.rutaDeFragments!!.size) {
                nextFragment = instance!!.rutaDeFragments[posicionDeLaRutaDeFragments]
                pasarDeFragment()
            } else determinarPuntajeFinal()
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
        val fragmentManager: FragmentManager = instance?.activity!!.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        instance?.nextFragment?.let {
            transaction.replace(R.id.contenedorDeFragments, it).commit()

        }
    }


    fun editTextVacio() {
        val alertDialogBuilder = AlertDialog.Builder(instance?.context)
        alertDialogBuilder.setView(
            LayoutInflater.from(instance?.context).inflate(R.layout.menllenarcampo, null)
        )
        val alertDialog = alertDialogBuilder.create()
        val ventana = alertDialog.window
        ventana?.setGravity(Gravity.BOTTOM)
        val layoutParams = ventana?.attributes
        ventana?.attributes = layoutParams
        alertDialog.show()
    }

    fun respuesta() {
        posicionDeLaRutaDeFragments += 1
        instance!!.puntaje += if (instance!!.correcto) 1 else 0
        mostrarAlertDialog()
    }

    fun respuesta(correcto: Boolean) {
        this.correcto = correcto
        posicionDeLaRutaDeFragments += 1
        instance!!.puntaje += if (instance!!.correcto) 1 else 0
        mostrarAlertDialog()
    }
}