package com.example.aymarswi.Util

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.DragEvent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.aymarswi.PantallasPrincipales.FragmentBien
import com.example.aymarswi.PantallasPrincipales.FragmentMalo
import com.example.aymarswi.PantallasPrincipales.FragmentRegular
import com.example.aymarswi.PantallasPrincipales.FragmentRegular2
import com.example.aymarswi.PantallasPrincipales.FragmentRegular3
import com.example.aymarswi.R
import java.util.Stack

class Utils {
    //Ultimos metodos creados para pasar de fragments
    fun respuestaCorrecta(
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragmentSiguiente: Fragment,
    ) {
        sonidoCorrecto(activity)
        showAlertDialogCorrect(activity, activity, containerFragmentId, fragmentSiguiente)
    }
    private fun showAlertDialogCorrect(
        contexto: Context,
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragment: Fragment,
    ) {
        val view = View.inflate(contexto, R.layout.dialog_correcto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            pasarDeFragmentsinParametros(activity, containerFragmentId, fragment)
        }
    }
    fun pasarDeFragmentsinParametros(
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragment: Fragment,
    ) {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(containerFragmentId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun respuestaIncorrecta(
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragmentSiguiente: Fragment,
    ) {
        sonidoIncorrecto(activity)
        showAlertDialogIncorrect(
            activity,
            activity,
            containerFragmentId,
            fragmentSiguiente,
        )
    }
    fun showAlertDialogIncorrect(
        contexto: Context,
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragment: Fragment,
    ) {
        val view = View.inflate(contexto, R.layout.dialog_incorrecto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            pasarDeFragmentsinParametros(activity, containerFragmentId, fragment)
        }
    }

    //Primeros metodos creados para pasar de fragments
    fun respuestaCorrecta(
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle
    ) {
        sonidoCorrecto(activity)
        showAlertDialogCorrect(activity, activity, containerFragmentId, fragmentSiguiente, paquete)
    }

    fun pasarDeFragment(activity: AppCompatActivity, containerId: Int, fragment: Fragment) {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun pasarDeFragmentconParametros(
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragment: Fragment,
        paquete: Bundle
    ) {
        fragment.arguments = paquete
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(containerFragmentId, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun showAlertDialogCorrect(contexto: Context, callback: () -> Unit = {}) {
        val view = View.inflate(contexto, R.layout.dialog_correcto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            callback()

        }
    }

    fun showAlertDialogCorrect(
        contexto: Context,
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragment: Fragment,
        paquete: Bundle
    ) {
        val view = View.inflate(contexto, R.layout.dialog_correcto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            pasarDeFragmentconParametros(activity, containerFragmentId, fragment, paquete)
        }
    }

    fun sonidoCorrecto(contexto: Context) {
        val mp = MediaPlayer.create(contexto, R.raw.sonidorespuestacorrecta1)
        mp.start()
    }

    //Respuesta Incorrecta
    fun respuestaIncorrecta(
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle
    ) {
        sonidoIncorrecto(activity)
        showAlertDialogIncorrect(
            activity,
            activity,
            containerFragmentId,
            fragmentSiguiente,
            paquete
        )
    }

    fun showAlertDialogIncorrect(contexto: Context, callback: () -> Unit = {}) {
        val view = View.inflate(contexto, R.layout.dialog_incorrecto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            callback()
        }
    }

    fun alertDialogCorrectDeterminaResultado(
        contexto: Context,
        puntaje: Int,
        activity: AppCompatActivity,
        containerFragmentId: Int
    ) {
        val view = View.inflate(contexto, R.layout.dialog_correcto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            determinarPuntajeFinal(puntaje, activity, containerFragmentId)
        }
    }

    fun alertDialogIncorrectDeterminaResultado(
        contexto: Context,
        puntaje: Int,
        activity: AppCompatActivity,
        containerFragmentId: Int
    ) {
        val view = View.inflate(contexto, R.layout.dialog_incorrecto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            determinarPuntajeFinal(puntaje, activity, containerFragmentId)
        }
    }

    fun showAlertDialogIncorrect(
        contexto: Context,
        activity: AppCompatActivity,
        containerFragmentId: Int,
        fragment: Fragment,
        paquete: Bundle
    ) {
        val view = View.inflate(contexto, R.layout.dialog_incorrecto, null)
        val builder = AlertDialog.Builder(contexto)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.findViewById<Button>(R.id.btnConfirmar)?.setOnClickListener {
            dialog.dismiss()
            pasarDeFragmentconParametros(activity, containerFragmentId, fragment, paquete)
        }
    }

    fun sonidoIncorrecto(contexto: Context) {
        val mp = MediaPlayer.create(contexto, R.raw.respuestaincorrecta1)
        mp.start()
    }

    fun mostrarMensajeETextVacio(contexto: Context) {
        val alertDialogBuilder = AlertDialog.Builder(contexto)
        val customView = LayoutInflater.from(contexto).inflate(R.layout.menllenarcampo, null)
        alertDialogBuilder.setView(customView)
        val alertDialog = alertDialogBuilder.create()
        val ventana = alertDialog.window
        ventana?.setGravity(Gravity.BOTTOM)
        val layoutParams = ventana?.attributes
        ventana?.attributes = layoutParams
        alertDialog.show()
    }



    fun determinarPuntajeFinal(
        puntaje: Int,
        activity: AppCompatActivity,
        containerFragmentId: Int
    ) {
        val args = Bundle()
        if (puntaje == 10) {
            args.putInt("valorp", puntaje)
            pasarDeFragmentconParametros(activity, containerFragmentId, FragmentBien(), args)
        } else if (puntaje == 9) {
            args.putInt("valorp", puntaje)
            pasarDeFragmentconParametros(activity, containerFragmentId, FragmentRegular(), args)
        } else if (puntaje >= 7) {
            args.putInt("valorp", puntaje)
            args.putInt("valorp", puntaje)
            pasarDeFragmentconParametros(activity, containerFragmentId, FragmentRegular2(), args)
        } else if (puntaje >= 5) {
            args.putInt("valorp", puntaje)
            pasarDeFragmentconParametros(activity, containerFragmentId, FragmentRegular3(), args)
        } else {
            args.putInt("valorp", puntaje)
            pasarDeFragmentconParametros(activity, containerFragmentId, FragmentMalo(), args)
        }
    }


    //--------------
    //Funciones para escoger las palabras correctas haciendo click y ordenandolas


    fun ordenarPalabras(
        words: List<String>,
        contexto: AppCompatActivity,
        contenedorDePalabras: LinearLayout,
        contenedorDeLaOracionFormada: LinearLayout
    ) {
        val selectedWords = mutableListOf<Button>()

        for (word in words) {
            val button = Button(contexto)
            button.isAllCaps = false
            button.setBackgroundColor(Color.parseColor("#9C27B0"))
            button.setTextColor(Color.parseColor("#FFFFFF"))

            button.text = word
            button.setOnClickListener {
                val selectedWord = it as Button
                if (selectedWords.contains(selectedWord)) {
                    // The button has already been selected, restore its original position
                    contenedorDeLaOracionFormada.removeView(selectedWord)
                    contenedorDePalabras.addView(selectedWord)

                    // Remove the button from the list of selected buttons
                    selectedWords.remove(selectedWord)
                } else {
                    // Move the selected button to the sentence container
                    contenedorDePalabras.removeView(selectedWord)
                    contenedorDeLaOracionFormada.addView(selectedWord)

                    // Add the button to the list of selected buttons
                    selectedWords.add(selectedWord)
                }
                // Adjust the margins of the button for visual appearance
                val layoutParams = selectedWord.layoutParams as LinearLayout.LayoutParams
                layoutParams.setMargins(8, 8, 8, 8)
                selectedWord.layoutParams = layoutParams

                // Apply scale animation to the selected button
                val scaleXAnimator = ObjectAnimator.ofFloat(selectedWord, "scaleX", 0.5f, 1.0f)
                val scaleYAnimator = ObjectAnimator.ofFloat(selectedWord, "scaleY", 0.5f, 1.0f)
                scaleXAnimator.interpolator = AccelerateDecelerateInterpolator()
                scaleYAnimator.interpolator = AccelerateDecelerateInterpolator()
                scaleXAnimator.duration = 300
                scaleYAnimator.duration = 300
                scaleXAnimator.start()
                scaleYAnimator.start()

                // Handle additional logic as needed
            }

            contenedorDePalabras.addView(button)
        }
    }

    fun obtenerOracionFormada(contenedorDeLaOracionFormada: LinearLayout): String {
        val sentenceBuilder = StringBuilder()

        for (i in 0 until contenedorDeLaOracionFormada.childCount) {
            val button = contenedorDeLaOracionFormada.getChildAt(i) as Button
            sentenceBuilder.append(button.text).append(" ")
            Log.d("palabra", "Palabra formada: $sentenceBuilder")
        }
        return sentenceBuilder.toString().trim()
    }
//Funcion deslizarPalabras a su contenedor

    @SuppressLint("ClickableViewAccessibility")
    fun deslizarPalabras(
        contexto: AppCompatActivity,
        txtYatiqaña: TextView,
        txtLuraña: TextView,
        txtComprobar1: TextView,
        txtComprobar2: TextView,
        palabraRequerida1: String,
        palabraRequerida2: String,
        btnComprobar: Button,
        contenedorDeFragmentId: Int, fragmentSiguiente: Fragment, paquete: Bundle,
        puntaje: Int
    ) {
        var originalX: Float = 0f
        var originalY: Float = 0f
        var textoOriginal: String = ""

// Guardar la posición original del botón
        txtYatiqaña.post {
            originalX = txtYatiqaña.x
            originalY = txtYatiqaña.y
        }
        txtLuraña.post {
            originalX = txtLuraña.x
            originalY = txtLuraña.y
        }

        // Configurar el evento onTouchListener para btnYatiqaña
        txtYatiqaña.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val clipData = ClipData.newPlainText("", "")
                    val shadowBuilder = View.DragShadowBuilder(view)
                    view.startDrag(clipData, shadowBuilder, view, 0)
                    true
                }

                MotionEvent.ACTION_UP -> {
                    // Restaurar la posición original y borrar el texto al soltar el botón
                    if (txtYatiqaña.visibility == View.INVISIBLE) {
                        txtYatiqaña.x = originalX
                        txtYatiqaña.y = originalY
                        txtYatiqaña.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onTouchListener para btnLuraña
        txtLuraña.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val clipData = ClipData.newPlainText("", "")
                    val shadowBuilder = View.DragShadowBuilder(view)
                    view.startDrag(clipData, shadowBuilder, view, 0)
                    true
                }

                MotionEvent.ACTION_UP -> {
                    // Restaurar la posición original y borrar el texto al soltar el botón
                    if (txtLuraña.visibility == View.INVISIBLE) {
                        txtLuraña.x = originalX
                        txtLuraña.y = originalY
                        txtLuraña.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onDragListener para txtComprobar1
        txtComprobar1.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    true
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    // Resaltar txtComprobar1 cuando se arrastra algo sobre él
                    txtComprobar1.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                    true
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    // Quitar el resaltado cuando se sale de txtComprobar1
                    txtComprobar1.setBackgroundResource(R.drawable.strokedelgado)
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as TextView
                    val draggedText = draggedView.text.toString()
                    textoOriginal = txtComprobar1.text.toString()
                    txtComprobar1.text = draggedText
                    txtComprobar1.setBackgroundResource(R.drawable.strokedelgado)
                    draggedView.visibility = View.INVISIBLE
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onClickListener para txtComprobar1
        txtComprobar1.setOnClickListener {
            if (txtComprobar1.text == txtLuraña.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar1
                txtLuraña.visibility = View.VISIBLE
                txtComprobar1.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar1.text == txtYatiqaña.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar1
                txtYatiqaña.visibility = View.VISIBLE
                txtComprobar1.text = textoOriginal
                textoOriginal = ""
            }
        }

        // Configurar el evento onDragListener para txtComprobar2
        txtComprobar2.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    true
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    // Resaltar txtComprobar2 cuando se arrastra algo sobre él
                    txtComprobar2.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                    true
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    // Quitar el resaltado cuando se sale de txtComprobar2
                    txtComprobar2.setBackgroundResource(R.drawable.strokedelgado)
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as TextView
                    val draggedText = draggedView.text.toString()
                    textoOriginal = txtComprobar2.text.toString()
                    txtComprobar2.text = draggedText
                    txtComprobar2.setBackgroundResource(R.drawable.strokedelgado)
                    draggedView.visibility = View.INVISIBLE
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onClickListener para txtComprobar2
        txtComprobar2.setOnClickListener {
            if (txtComprobar2.text == txtLuraña.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txtLuraña.visibility = View.VISIBLE
                txtComprobar2.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar2.text == txtYatiqaña.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txtYatiqaña.visibility = View.VISIBLE
                txtComprobar2.text = textoOriginal
                textoOriginal = ""
            }
        }


        //Comprobar si las palabras en los contenedores son las correctas al hacer click en btnComprobar

        var puntajeActual = puntaje
        btnComprobar.setOnClickListener {
            if (txtComprobar1.text.toString() == palabraRequerida1 && txtComprobar2.text.toString() == palabraRequerida2) {
                paquete.putInt("valorp", ++puntajeActual)
                respuestaCorrecta(
                    contexto,
                    contenedorDeFragmentId,
                    fragmentSiguiente,
                    paquete
                )
            } else {
                paquete.putInt("valorp", puntajeActual)
                respuestaIncorrecta(
                    contexto,
                    contenedorDeFragmentId,
                    fragmentSiguiente,
                    paquete
                )
            }
        }

    }


    //Funcion que verifica tres textos segun si los textos son los requeridos
    @SuppressLint("ClickableViewAccessibility")
    fun deslizar3PalabrasA3Contenedores(
        contexto: AppCompatActivity,
        txt1: TextView,
        txt2: TextView,
        txt3: TextView,
        txtComprobar1: TextView,
        txtComprobar2: TextView,
        txtComprobar3: TextView,
        palabraRequerida1: String,
        palabraRequerida2: String,
        palabraRequerida3: String,
        contenedorDeFragmentId: Int, fragmentSiguiente: Fragment, paquete: Bundle,
        puntaje: Int
    ) {
        var originalX: Float = 0f
        var originalY: Float = 0f
        var textoOriginal: String = ""
        var txtDeslizado: TextView = txt1
        var cont = 0
        paquete.putInt("valorp", puntaje + 1)

// Guardar la posición original del botón
        txt1.post {
            originalX = txt1.x
            originalY = txt1.y
        }
        txt2.post {
            originalX = txt2.x
            originalY = txt2.y
        }
        txt3.post {
            originalX = txt2.x
            originalY = txt2.y
        }
        // Configurar el evento onTouchListener para txt1
        txt1.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val clipData = ClipData.newPlainText("", "")
                    val shadowBuilder = View.DragShadowBuilder(view)
                    view.startDrag(clipData, shadowBuilder, view, 0)
                    true
                }

                MotionEvent.ACTION_UP -> {
                    // Restaurar la posición original y borrar el texto al soltar el botón
                    if (txt1.visibility == View.INVISIBLE) {
                        txt1.x = originalX
                        txt1.y = originalY
                        txt1.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onTouchListener para txt2
        txt2.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val clipData = ClipData.newPlainText("", "")
                    val shadowBuilder = View.DragShadowBuilder(view)
                    view.startDrag(clipData, shadowBuilder, view, 0)
                    true
                }

                MotionEvent.ACTION_UP -> {
                    // Restaurar la posición original y borrar el texto al soltar el botón
                    if (txt2.visibility == View.INVISIBLE) {
                        txt2.x = originalX
                        txt2.y = originalY
                        txt2.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }
        // Configurar el evento onTouchListener para txt3
        txt3.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val clipData = ClipData.newPlainText("", "")
                    val shadowBuilder = View.DragShadowBuilder(view)
                    view.startDrag(clipData, shadowBuilder, view, 0)
                    true
                }

                MotionEvent.ACTION_UP -> {
                    // Restaurar la posición original y borrar el texto al soltar el botón
                    if (txt3.visibility == View.INVISIBLE) {
                        txt3.x = originalX
                        txt3.y = originalY
                        txt3.visibility = View.VISIBLE
                    }
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onDragListener para txtComprobar1
        txtComprobar1.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    true
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    // Resaltar txtComprobar1 cuando se arrastra algo sobre él
                    txtComprobar1.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                    true
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    // Quitar el resaltado cuando se sale de txtComprobar1
                    txtComprobar1.setBackgroundResource(R.drawable.strokedelgado)
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as TextView
                    val draggedText = draggedView.text.toString()
                    textoOriginal = txtComprobar1.text.toString()
                    txtComprobar1.text = draggedText
                    txtComprobar1.setBackgroundResource(R.drawable.strokedelgado)
                    if (txtComprobar1.text.toString() == palabraRequerida1) {
                        cont++
                        if (cont == 3) {
                            respuestaCorrecta(
                                contexto,
                                contenedorDeFragmentId,
                                fragmentSiguiente,
                                paquete
                            )
                        } else {
                            sonidoCorrecto(contexto)
                            showAlertDialogCorrect(contexto)
                            txtComprobar1.isClickable = false

                        }
                    } else {
                        sonidoIncorrecto(contexto)
                        showAlertDialogIncorrect(contexto)
                    }
                    draggedView.visibility = View.INVISIBLE
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onClickListener para txtComprobar1
        txtComprobar1.setOnClickListener {
            if (txtComprobar1.text == txt1.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar1
                txt1.visibility = View.VISIBLE
                txtComprobar1.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar1.text == txt2.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar1
                txt2.visibility = View.VISIBLE
                txtComprobar1.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar1.text == txt3.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar1
                txt3.visibility = View.VISIBLE
                txtComprobar1.text = textoOriginal
                textoOriginal = ""
            }
        }

        // Configurar el evento onDragListener para txtComprobar2
        txtComprobar2.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    true
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    // Resaltar txtComprobar2 cuando se arrastra algo sobre él
                    txtComprobar2.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                    true
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    // Quitar el resaltado cuando se sale de txtComprobar2
                    txtComprobar2.setBackgroundResource(R.drawable.strokedelgado)
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as TextView
                    val draggedText = draggedView.text.toString()
                    textoOriginal = txtComprobar2.text.toString()
                    txtComprobar2.text = draggedText
                    txtComprobar2.setBackgroundResource(R.drawable.strokedelgado)
                    if (txtComprobar2.text.toString() == palabraRequerida2) {
                        cont++
                        if (cont == 3) {
                            respuestaCorrecta(
                                contexto,
                                contenedorDeFragmentId,
                                fragmentSiguiente,
                                paquete
                            )
                        } else {
                            sonidoCorrecto(contexto)
                            showAlertDialogCorrect(contexto)
                            txtComprobar1.isClickable = false
                        }
                    } else {
                        sonidoIncorrecto(contexto)
                        showAlertDialogIncorrect(contexto)
                    }
                    draggedView.visibility = View.INVISIBLE
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onClickListener para txtComprobar2
        txtComprobar2.setOnClickListener {
            if (txtComprobar2.text == txt1.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txt1.visibility = View.VISIBLE
                txtComprobar2.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar2.text == txt2.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txt2.visibility = View.VISIBLE
                txtComprobar2.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar2.text == txt3.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txt3.visibility = View.VISIBLE
                txtComprobar2.text = textoOriginal
                textoOriginal = ""
            }
        }

        // Configurar el evento onDragListener para txtComprobar3
        txtComprobar3.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    true
                }

                DragEvent.ACTION_DRAG_ENTERED -> {
                    // Resaltar txtComprobar3 cuando se arrastra algo sobre él
                    txtComprobar3.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                    true
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    // Quitar el resaltado cuando se sale de txtComprobar3
                    txtComprobar3.setBackgroundResource(R.drawable.strokedelgado)
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as TextView
                    val draggedText = draggedView.text.toString()
                    textoOriginal = txtComprobar3.text.toString()
                    txtComprobar3.text = draggedText
                    txtComprobar3.setBackgroundResource(R.drawable.strokedelgado)
                    if (txtComprobar3.text.toString() == palabraRequerida3) {
                        cont++
                        if (cont == 3) {
                            respuestaCorrecta(
                                contexto,
                                contenedorDeFragmentId,
                                fragmentSiguiente,
                                paquete
                            )
                        } else {
                            sonidoCorrecto(contexto)
                            showAlertDialogCorrect(contexto)
                            txtComprobar1.isClickable = false
                        }
                    } else {
                        sonidoIncorrecto(contexto)
                        showAlertDialogIncorrect(contexto)
                    }
                    draggedView.visibility = View.INVISIBLE
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> {
                    true
                }

                else -> false
            }
        }

        // Configurar el evento onClickListener para txtComprobar3
        txtComprobar3.setOnClickListener {
            if (txtComprobar3.text == txt1.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txt1.visibility = View.VISIBLE
                txtComprobar3.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar3.text == txt2.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txt2.visibility = View.VISIBLE
                txtComprobar3.text = textoOriginal
                textoOriginal = ""
            } else if (txtComprobar3.text == txt3.text) {
                // Restaurar la visibilidad del botón y borrar el texto que esta en txtComprobar2
                txt3.visibility = View.VISIBLE
                txtComprobar3.text = textoOriginal
                textoOriginal = ""
            }
        }

        //Comprobar si las palabras en los contenedores son las correctas al hacer click en btnComprobar
    }

    //Funcion que verifica cuatro textos segun si los textos son los requeridos
    @SuppressLint("ClickableViewAccessibility")
    fun deslizar4PalabrasA4Contenedores(
        contexto: AppCompatActivity,
        txt1: TextView,
        txt2: TextView,
        txt3: TextView,
        txt4: TextView,
        txtComprobar1: TextView,
        txtComprobar2: TextView,
        txtComprobar3: TextView,
        txtComprobar4: TextView,
        palabraRequerida1: String,
        palabraRequerida2: String,
        palabraRequerida3: String,
        palabraRequerida4: String,
        contenedorDeFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle,
        puntaje: Int
    ) {
        var originalX: Float = 0f
        var originalY: Float = 0f
        var textoOriginal: String = ""
        var cont = 0
        paquete.putInt("valorp", puntaje + 1)

        // Guardar la posición original de los botones
        txt1.post {
            originalX = txt1.x
            originalY = txt1.y
        }
        txt2.post {
            originalX = txt2.x
            originalY = txt2.y
        }
        txt3.post {
            originalX = txt3.x
            originalY = txt3.y
        }
        txt4.post {
            originalX = txt4.x
            originalY = txt4.y
        }

        // Función para restaurar la visibilidad del botón y borrar el texto en el contenedor
        fun resetView(txtComprobar: TextView, originalView: TextView) {
            if (txtComprobar.text == originalView.text) {
                originalView.visibility = View.VISIBLE
                txtComprobar.text = textoOriginal
                textoOriginal = ""
            }
        }

        // Función para manejar el evento onTouchListener
        fun setupTouchListener(txt: TextView, txtComprobar: TextView) {
            txt.setOnTouchListener { view, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        val clipData = ClipData.newPlainText("", "")
                        val shadowBuilder = View.DragShadowBuilder(view)
                        view.startDrag(clipData, shadowBuilder, view, 0)
                        true
                    }

                    MotionEvent.ACTION_UP -> {
                        if (txt.visibility == View.INVISIBLE) {
                            txt.x = originalX
                            txt.y = originalY
                            txt.visibility = View.VISIBLE
                        }
                        true
                    }

                    else -> false
                }
            }

            txtComprobar.setOnClickListener {
                resetView(txtComprobar, txt1)
                resetView(txtComprobar, txt2)
                resetView(txtComprobar, txt3)
                resetView(txtComprobar, txt4)
            }
        }

        // Configurar el evento onTouchListener para los botones
        setupTouchListener(txt1, txtComprobar1)
        setupTouchListener(txt2, txtComprobar2)
        setupTouchListener(txt3, txtComprobar3)
        setupTouchListener(txt4, txtComprobar4)

        // Función para manejar el evento onDragListener
        fun setupDragListener(txtComprobar: TextView, palabraRequerida: String) {
            txtComprobar.setOnDragListener { _, event ->
                when (event.action) {
                    DragEvent.ACTION_DRAG_STARTED -> true

                    DragEvent.ACTION_DRAG_ENTERED -> {
                        txtComprobar.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                        true
                    }

                    DragEvent.ACTION_DRAG_EXITED -> {
                        txtComprobar.setBackgroundResource(R.drawable.strokedelgado)
                        true
                    }

                    DragEvent.ACTION_DROP -> {
                        val draggedView = event.localState as TextView
                        val draggedText = draggedView.text.toString()
                        textoOriginal = txtComprobar.text.toString()
                        txtComprobar.text = draggedText
                        txtComprobar.setBackgroundResource(R.drawable.strokedelgado)
                        if (txtComprobar.text.toString() == palabraRequerida) {
                            cont++
                            if (cont == 4) {
                                respuestaCorrecta(
                                    contexto,
                                    contenedorDeFragmentId,
                                    fragmentSiguiente,
                                    paquete
                                )
                            } else {
                                sonidoCorrecto(contexto)
                                showAlertDialogCorrect(contexto)
                                txtComprobar1.isClickable = false
                            }
                        } else {
                            sonidoIncorrecto(contexto)
                            showAlertDialogIncorrect(contexto)
                        }
                        draggedView.visibility = View.INVISIBLE
                        true
                    }

                    DragEvent.ACTION_DRAG_ENDED -> true

                    else -> false
                }
            }
        }

        // Configurar el evento onDragListener para los contenedores
        setupDragListener(txtComprobar1, palabraRequerida1)
        setupDragListener(txtComprobar2, palabraRequerida2)
        setupDragListener(txtComprobar3, palabraRequerida3)
        setupDragListener(txtComprobar4, palabraRequerida4)
    }

    //Funcion encontrar los pares de las palabras

    fun encontrarParesPantallaFinal(
        contexto: AppCompatActivity,
        btnA1: Button,
        btnB1: Button,
        btnC1: Button,
        btnD1: Button,
        btnA2: Button,
        btnB2: Button,
        btnC2: Button,
        btnD2: Button,
        contenedorDeFragmentId: Int, puntaje: Int
    ) {
        var c = 0
        btnA1.setOnClickListener {
            btnA1.setBackgroundResource(R.drawable.button_background_yellow)
            btnA2.isClickable = true
            btnA2.setOnClickListener {
                btnA2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 4) {
                    Utils().sonidoCorrecto(contexto)
                    Utils().alertDialogCorrectDeterminaResultado(
                        contexto,
                        puntaje,
                        contexto,
                        contenedorDeFragmentId
                    )
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnA1.isClickable = false
                    btnA2.isClickable = false
                    val colorFondo = btnA1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnA1.setBackgroundColor(Color.TRANSPARENT)
                    btnA2.setBackgroundColor(Color.TRANSPARENT)
                }

            }
            btnB2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnC2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
        }
        btnB1.setOnClickListener {
            btnB1.setBackgroundResource(R.drawable.button_background_yellow)
            btnB2.isClickable = true
            btnB2.setOnClickListener {
                btnB2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 4) {
                    Utils().sonidoCorrecto(contexto)
                    Utils().alertDialogCorrectDeterminaResultado(
                        contexto,
                        puntaje,
                        contexto,
                        contenedorDeFragmentId
                    )
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnB1.isClickable = false
                    btnB2.isClickable = false
                    val colorFondo = btnB1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnB1.setBackgroundColor(Color.TRANSPARENT)
                    btnB2.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            btnC2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnA2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }

        }
        btnC1.setOnClickListener {
            btnC1.setBackgroundResource(R.drawable.button_background_yellow)
            btnC2.isClickable = true
            btnC2.setOnClickListener {
                btnC2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 4) {
                    Utils().sonidoCorrecto(contexto)
                    Utils().alertDialogCorrectDeterminaResultado(
                        contexto,
                        puntaje,
                        contexto,
                        contenedorDeFragmentId
                    )
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnC1.isClickable = false
                    btnC2.isClickable = false
                    val colorFondo = btnC1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnC1.setBackgroundColor(Color.TRANSPARENT)
                    btnC2.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnA2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnB2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
        }
        btnD1.setOnClickListener {
            btnD1.setBackgroundResource(R.drawable.button_background_yellow)
            btnD2.isClickable = true
            btnD2.setOnClickListener {
                btnD2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 4) {
                    Utils().sonidoCorrecto(contexto)
                    Utils().alertDialogCorrectDeterminaResultado(
                        contexto,
                        puntaje,
                        contexto,
                        contenedorDeFragmentId
                    )
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnD1.isClickable = false
                    btnD2.isClickable = false
                    val colorFondo = btnD1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnD1.setBackgroundColor(Color.TRANSPARENT)
                    btnD2.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            btnA2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnB2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
            btnC2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
            }
        }
    }


    //Encontrar pares de botones
    fun encontrar5Pares(
        activity: AppCompatActivity,
        contexto: AppCompatActivity,
        btnA1: Button,
        btnB1: Button,
        btnC1: Button,
        btnD1: Button,
        btnE1: Button,
        btnA2: Button,
        btnB2: Button,
        btnC2: Button,
        btnD2: Button,
        btnE2: Button,
        contenedorDeFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle
    ) {
        val fondoOriginal = btnA1.background
        var c = 0
        btnA1.setOnClickListener {
            btnA1.setBackgroundResource(R.drawable.button_background_yellow)
            btnA2.isClickable = true
            btnA2.setOnClickListener {
                btnA2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 5) {
                    respuestaCorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnA1.isClickable = false
                    btnA2.isClickable = false
                    val colorFondo = btnA1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnA1.setBackgroundColor(Color.TRANSPARENT)
                    btnA2.setBackgroundColor(Color.TRANSPARENT)
                }

            }
            btnB2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnA1.background = fondoOriginal
                btnB2.background = fondoOriginal
            }
            btnC2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnA1.background = fondoOriginal
                btnC2.background = fondoOriginal
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnA1.background = fondoOriginal
                btnD2.background = fondoOriginal
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnA1.background = fondoOriginal
                btnD2.background = fondoOriginal
            }
        }
        btnB1.setOnClickListener {
            btnB1.setBackgroundResource(R.drawable.button_background_yellow)
            btnB2.isClickable = true
            btnB2.setOnClickListener {
                btnB2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 5) {
                    respuestaCorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnB1.isClickable = false
                    btnB2.isClickable = false
                    val colorFondo = btnB1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnB1.setBackgroundColor(Color.TRANSPARENT)
                    btnB2.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            btnC2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnB1.background = fondoOriginal
                btnC2.background = fondoOriginal
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnB1.background = fondoOriginal
                btnD2.background = fondoOriginal
            }
            btnE2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnB1.background = fondoOriginal
                btnE2.background = fondoOriginal
            }
            btnA2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnB1.background = fondoOriginal
                btnA2.background = fondoOriginal
            }

        }
        btnC1.setOnClickListener {
            btnC1.setBackgroundResource(R.drawable.button_background_yellow)
            btnC2.isClickable = true
            btnC2.setOnClickListener {
                btnC2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 5) {
                    respuestaCorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnC1.isClickable = false
                    btnC2.isClickable = false
                    val colorFondo = btnC1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnC1.setBackgroundColor(Color.TRANSPARENT)
                    btnC2.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnC1.background = fondoOriginal
                btnD2.background = fondoOriginal
            }
            btnA2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnC1.background = fondoOriginal
                btnA2.background = fondoOriginal
            }
            btnB2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnC1.background = fondoOriginal
                btnB2.background = fondoOriginal
            }
            btnE2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnC1.background = fondoOriginal
                btnE2.background = fondoOriginal
            }
        }
        btnD1.setOnClickListener {
            btnD1.setBackgroundResource(R.drawable.button_background_yellow)
            btnD2.isClickable = true
            btnD2.setOnClickListener {
                btnD2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 5) {
                    respuestaCorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnD1.isClickable = false
                    btnD2.isClickable = false
                    val colorFondo = btnD1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnD1.setBackgroundColor(Color.TRANSPARENT)
                    btnD2.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            btnA2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnD1.background = fondoOriginal
                btnA2.background = fondoOriginal
            }
            btnB2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnD1.background = fondoOriginal
                btnB2.background = fondoOriginal
            }
            btnC2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnD1.background = fondoOriginal
                btnC2.background = fondoOriginal
            }
            btnE2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnD1.background = fondoOriginal
                btnE2.background = fondoOriginal
            }
        }
        btnE1.setOnClickListener {
            btnE1.setBackgroundResource(R.drawable.button_background_yellow)
            btnE2.isClickable = true
            btnE2.setOnClickListener {
                btnE2.setBackgroundResource(R.drawable.button_background_yellow)
                if (++c == 5) {
                    respuestaCorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
                } else {
                    Utils().sonidoCorrecto(contexto)
                    btnE1.isClickable = false
                    btnE2.isClickable = false
                    val colorFondo = btnE1.background
                    colorFondo.setAlpha(128) // Valor de transparencia (0-255)
                    btnE1.setBackgroundColor(Color.TRANSPARENT)
                    btnE2.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            btnA2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnE1.background = fondoOriginal
                btnA2.background = fondoOriginal
            }
            btnB2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnE1.background = fondoOriginal
                btnB2.background = fondoOriginal
            }
            btnC2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnE1.background = fondoOriginal
                btnC2.background = fondoOriginal
            }
            btnD2.setOnClickListener {
                Utils().sonidoIncorrecto(contexto)
                Utils().showAlertDialogIncorrect(contexto)
                btnE1.background = fondoOriginal
                btnD2.background = fondoOriginal
            }
        }
    }


    //Funcion para formar oracion con botones pero escrito


    fun formarOracionConTextoDelBotonPara4Botones(
        btnManzanaja: Button,
        btnWilawa2: Button,
        btnLarankha: Button,
        btnUkaxa: Button,
        txtOManzana: TextView,
        btnComprobar: Button, cantidadDePalabrasParaLaOracion: Int
    ) {
        cont = 0
            btnManzanaja.setOnClickListener {

                txtOManzana.append(btnManzanaja.text.toString() + " ")
                btnManzanaja.visibility = View.INVISIBLE
                cont++
            }
            btnWilawa2.setOnClickListener {

                txtOManzana.append(btnWilawa2.text.toString() + " ")
                btnWilawa2.visibility = View.INVISIBLE
                cont++
            }
            btnLarankha.setOnClickListener {

                txtOManzana.append(btnLarankha.text.toString() + " ")
                btnLarankha.visibility = View.INVISIBLE
                cont++
            }
            btnUkaxa.setOnClickListener {

                txtOManzana.append(btnUkaxa.text.toString() + " ")
                btnUkaxa.visibility = View.INVISIBLE
                cont++

            }


        txtOManzana.setOnClickListener {
            if (txtOManzana.text.isNotEmpty()) {
                val ultimaPalabra = eliminarUltimaPalabra(txtOManzana)
                cont--
                when (ultimaPalabra) {
                    btnManzanaja.text.toString() -> {
                        btnManzanaja.visibility = View.VISIBLE
                    }

                    btnWilawa2.text.toString() -> {
                        btnWilawa2.visibility = View.VISIBLE
                    }

                    btnLarankha.text.toString() -> {
                        btnLarankha.visibility = View.VISIBLE
                    }

                    btnUkaxa.text.toString() -> {
                        btnUkaxa.visibility = View.VISIBLE
                    }
                }
            }
        }
        obtenerOracionFormada(txtOManzana)
    }

    fun eliminarUltimaPalabra(oracion: TextView): String {
        val palabras = oracion.text.toString().trim().split("\\s+".toRegex())
        val ultimaPalabra = palabras.last()
        val palabraSinLaUltima = palabras.dropLast(1)
        val nuevaCadena = palabraSinLaUltima.joinToString(" ")
        oracion.text = nuevaCadena
        return ultimaPalabra.trim()
    }

    fun obtenerOracionFormada(oracion: TextView): String {
        return oracion.text.toString().trim()
    }

    /* Formar oracion con botones
     Ordenar botones con sus palabras en una oracion al hacer click segunda forma */

    private var oracionFormada1 = ""
    private val buttonsList = mutableListOf<Button>()
    private var cont2 = 1
    fun formarOracionCon4Botones(
        Idboton1: Int,
        Idboton2: Int,
        Idboton3: Int,
        Idboton4: Int,
        oracionRequerida: String,
        rootView: View,
        txtOHoja: LinearLayout,
        btnComprobar: Button,
        activity: AppCompatActivity,
        fragmentSiguiente: Fragment,
        contenedorDeFragmentId: Int, paquete: Bundle, puntaje: Int, cantidadDePalabras: Int
    ) {
        setupButton(
            rootView,
            Idboton1,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton2,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton3,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton4,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )

    }

    /* Formar oracion con botones
     Ordenar botones con sus palabras en una oracion al hacer click segunda forma */

    private var oracionFormada = ""
    private val buttons = mutableListOf<Button>()
    private var cont = 1
    fun formarOracionConBotones(
        Idboton1: Int,
        Idboton2: Int,
        Idboton3: Int,
        Idboton4: Int,
        Idboton5: Int,
        Idboton6: Int,
        oracionRequerida: String,
        rootView: View,
        txtOHoja: LinearLayout,
        btnComprobar: Button,
        activity: AppCompatActivity,
        fragmentSiguiente: Fragment,
        contenedorDeFragmentId: Int, paquete: Bundle, puntaje: Int, cantidadDePalabras: Int
    ) {


        setupButton(
            rootView,
            Idboton1,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton2,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton3,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton4,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton5,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )
        setupButton(
            rootView,
            Idboton6,
            txtOHoja,
            activity,
            btnComprobar,
            oracionRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDePalabras
        )

    }

    private fun setupButton(
        rootView: View,
        buttonId: Int,
        txtOHoja: LinearLayout,
        contexto: AppCompatActivity,
        btnComprobar: Button,
        oracionRequerida: String,
        contenedorDeFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle, puntaje: Int,
        cantidadDePalabras: Int
    ) {
        val button = rootView.findViewById<Button>(buttonId)
        buttons.add(button)


        button.setOnClickListener {
            if (cont <= cantidadDePalabras) {
                oracionFormada += button.text.toString() + " "
                button.visibility = View.INVISIBLE
                val btnCopia = btnCrearCopiaDeBoton(button, contexto)
                cont++

                btnCopia.setOnClickListener {
                    oracionFormada =
                        eliminarPalabraEnOracion(oracionFormada, button.text.toString(), contexto)
                    button.visibility = View.VISIBLE
                    (btnCopia.parent as ViewGroup).removeView(btnCopia)
                    cont--
                }

                txtOHoja.addView(btnCopia)
                animateButton(btnCopia)
            }
        }


        //Comprobar la oracion
        btnComprobar.setOnClickListener {
            var puntajeActual = puntaje
            Toast.makeText(contexto, oracionFormada, Toast.LENGTH_SHORT).show()
            if (oracionFormada.trim() == oracionRequerida) {
                paquete.putInt("valorp", ++puntajeActual)
                respuestaCorrecta(contexto, contenedorDeFragmentId, fragmentSiguiente, paquete)
            } else {
                paquete.putInt("valorp", puntajeActual)
                respuestaIncorrecta(contexto, contenedorDeFragmentId, fragmentSiguiente, paquete)
            }

        }
    }

    private fun btnCrearCopiaDeBoton(botonOriginal: Button, contexto: Context): Button {
        val btnCopia = Button(contexto).apply {
            text = botonOriginal.text
            setTextColor(botonOriginal.currentTextColor)
            typeface = botonOriginal.typeface
            textSize = 20f
            isAllCaps = false
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(10, 0, 10, 0)
            }

            // Copiar el fondo del botonOriginal al btnCopia
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                background = botonOriginal.background.constantState?.newDrawable()
            } else {
                @Suppress("DEPRECATION")
                setBackgroundDrawable(botonOriginal.background.constantState?.newDrawable())
            }
        }
        return btnCopia
    }

    private fun eliminarPalabraEnOracion(
        oracion: String,
        palabra: String,
        contexto: Context
    ): String {
        val palabras = oracion.split(" ")
        val palabrasSinPalabra = palabras.filter { it != palabra }
        val oracionSinPalabra = palabrasSinPalabra.joinToString(" ")
        Toast.makeText(contexto, oracionSinPalabra, Toast.LENGTH_SHORT).show()
        return oracionSinPalabra
    }

    private fun animateButton(button: Button) {
        val scaleAnimation = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        scaleAnimation.duration = 50
        scaleAnimation.interpolator = AccelerateInterpolator()

        button.startAnimation(scaleAnimation)
    }

//Armar palabra con botones v2


//Armar palabra con botones v1

    private var palabraFormada = ""
    private val buttonsLetter = mutableListOf<Button>()
    private var contL = 1
    fun formarPalabraConBotones(
        Idboton1: Int,
        Idboton2: Int,
        Idboton3: Int,
        Idboton4: Int,
        Idboton5: Int,
        Idboton6: Int,
        palabraRequerida: String,
        rootView: View,
        txtOHoja: LinearLayout,
        btnComprobar: Button,
        activity: AppCompatActivity,
        fragmentSiguiente: Fragment,
        contenedorDeFragmentId: Int, paquete: Bundle, puntaje: Int, cantidadDeLetras: Int
    ) {
        configurarBoton(
            rootView,
            Idboton1,
            txtOHoja,
            activity,
            btnComprobar,
            palabraRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDeLetras
        )
        configurarBoton(
            rootView,
            Idboton2,
            txtOHoja,
            activity,
            btnComprobar,
            palabraRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDeLetras
        )
        configurarBoton(
            rootView,
            Idboton3,
            txtOHoja,
            activity,
            btnComprobar,
            palabraRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDeLetras
        )
        configurarBoton(
            rootView,
            Idboton4,
            txtOHoja,
            activity,
            btnComprobar,
            palabraRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDeLetras
        )
        configurarBoton(
            rootView,
            Idboton5,
            txtOHoja,
            activity,
            btnComprobar,
            palabraRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDeLetras
        )
        configurarBoton(
            rootView,
            Idboton6,
            txtOHoja,
            activity,
            btnComprobar,
            palabraRequerida,
            contenedorDeFragmentId,
            fragmentSiguiente,
            paquete,
            puntaje,
            cantidadDeLetras
        )
    }

    private fun configurarBoton(
        rootView: View,
        buttonId: Int,
        txtOHoja: LinearLayout,
        contexto: AppCompatActivity,
        btnComprobar: Button,
        palabraRequerida: String,
        contenedorDeFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle, puntaje: Int,
        cantidadDePalabras: Int
    ) {
        val button = rootView.findViewById<Button>(buttonId)
        buttonsLetter.add(button)


        button.setOnClickListener {
            if (contL <= cantidadDePalabras) {
                palabraFormada += button.text.toString()
                button.visibility = View.INVISIBLE
                val btnCopia = btnCrearCopiaDeBoton2(button, contexto)
                contL++

                btnCopia.setOnClickListener {
                    palabraFormada =
                        eliminarLetrasEnPalabra(palabraFormada, button.text.toString()[0])
                    button.visibility = View.VISIBLE
                    (btnCopia.parent as ViewGroup).removeView(btnCopia)
                    contL--
                }

                txtOHoja.addView(btnCopia)
                animateButton(btnCopia)
            }
        }


        //Comprobar la palabra
        btnComprobar.setOnClickListener {
            var puntajeActual = puntaje
            Toast.makeText(contexto, palabraFormada, Toast.LENGTH_SHORT).show()
            if (palabraFormada.trim() == palabraRequerida) {
                paquete.putInt("valorp", ++puntajeActual)
                respuestaCorrecta(contexto, contenedorDeFragmentId, fragmentSiguiente, paquete)
            } else {
                paquete.putInt("valorp", puntajeActual)
                respuestaIncorrecta(contexto, contenedorDeFragmentId, fragmentSiguiente, paquete)
            }

        }
    }

    private fun btnCrearCopiaDeBoton2(botonOriginal: Button, contexto: Context): Button {
        val btnCopia = Button(contexto).apply {
            text = botonOriginal.text
            setTextColor(botonOriginal.currentTextColor)
            typeface = botonOriginal.typeface
            setBackgroundResource(R.drawable.button_background)
            textSize = 20f
            isAllCaps = false
            layoutParams = LinearLayout.LayoutParams(
                80,
                80
            ).apply {
                setMargins(10, 0, 10, 0)
            }

        }
        return btnCopia
    }

    private fun eliminarLetrasEnPalabra(palabra: String, letra: Char): String {
        val letras = palabra.toCharArray()
        val letrasSinLetra = letras.filter { it != letra }
        val palabraSinLetra = letrasSinLetra.joinToString("")
        return palabraSinLetra
    }


    //Sopa de letras

    private lateinit var palabra1: TextView
    private lateinit var palabra2: TextView
    private lateinit var palabra3: TextView
    private lateinit var palabra4: TextView
    private lateinit var formedWord: StringBuilder
    private var stackTxt: Stack<TextView> = Stack()
    private var letrasUsadasMasVeces: Char = 'u'
    var cont1 = 0
    private var bandera = false
    fun sopaDeLetras(
        idLetra1: Int,
        idLetra2: Int,
        idLetra3: Int,
        idLetra4: Int,
        idLetra5: Int,
        idLetra6: Int,
        idLetra7: Int,
        idLetra8: Int,
        idLetra9: Int,
        idLetra10: Int,
        idLetra11: Int,
        idLetra12: Int,
        idLetra13: Int,
        idLetra14: Int,
        idLetra15: Int,
        idLetra16: Int,
        idLetra17: Int,
        idLetra18: Int,
        idLetra19: Int,
        idLetra20: Int,
        idLetra21: Int,
        idLetra22: Int,
        idLetra23: Int,
        idLetra24: Int,
        idLetra25: Int,
        contexto: Context,
        view: View,
        palabraBuscada1: TextView,
        palabraBuscada2: TextView,
        palabraBuscada3: TextView,
        palabraBuscada4: TextView,
        btnContinuar: Button,
        letrasParaUsarDosVeces: Char,
        activity: AppCompatActivity,
        contenedorDeFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle
    ) {
        palabra1 = palabraBuscada1
        palabra2 = palabraBuscada2
        palabra3 = palabraBuscada3
        palabra4 = palabraBuscada4
        formedWord = StringBuilder()
        letrasUsadasMasVeces = letrasParaUsarDosVeces


        val textViewClickListener: (TextView) -> Unit = { textView ->
            stackTxt.push(textView)
            formedWord.append(textView.text)
            textView.setBackgroundResource(R.drawable.esquinasredondas)
            checkFormedWord(
                contexto,
                activity,
                contenedorDeFragmentId,
                fragmentSiguiente,
                paquete,
                btnContinuar
            )
        }

        setTextViewClickListener(view, idLetra1, textViewClickListener)
        setTextViewClickListener(view, idLetra2, textViewClickListener)
        setTextViewClickListener(view, idLetra3, textViewClickListener)
        setTextViewClickListener(view, idLetra4, textViewClickListener)
        setTextViewClickListener(view, idLetra5, textViewClickListener)
        setTextViewClickListener(view, idLetra6, textViewClickListener)
        setTextViewClickListener(view, idLetra7, textViewClickListener)
        setTextViewClickListener(view, idLetra8, textViewClickListener)
        setTextViewClickListener(view, idLetra9, textViewClickListener)
        setTextViewClickListener(view, idLetra10, textViewClickListener)
        setTextViewClickListener(view, idLetra11, textViewClickListener)
        setTextViewClickListener(view, idLetra12, textViewClickListener)
        setTextViewClickListener(view, idLetra13, textViewClickListener)
        setTextViewClickListener(view, idLetra14, textViewClickListener)
        setTextViewClickListener(view, idLetra15, textViewClickListener)
        setTextViewClickListener(view, idLetra16, textViewClickListener)
        setTextViewClickListener(view, idLetra17, textViewClickListener)
        setTextViewClickListener(view, idLetra18, textViewClickListener)
        setTextViewClickListener(view, idLetra19, textViewClickListener)
        setTextViewClickListener(view, idLetra20, textViewClickListener)
        setTextViewClickListener(view, idLetra21, textViewClickListener)
        setTextViewClickListener(view, idLetra22, textViewClickListener)
        setTextViewClickListener(view, idLetra23, textViewClickListener)
        setTextViewClickListener(view, idLetra24, textViewClickListener)
        setTextViewClickListener(view, idLetra25, textViewClickListener)
    }

    private fun setTextViewClickListener(view: View, id: Int, clickListener: (TextView) -> Unit) {
        view.findViewById<TextView>(id).setOnClickListener {
            clickListener(it as TextView)
        }
    }

    fun checkFormedWord(
        contexto: Context,
        activity: AppCompatActivity,
        contenedorDeFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle,
        btnContinuar: Button
    ) {
        when (formedWord.toString()) {
            palabra1.text.toString() -> {
                showToast(formedWord.toString(), contexto)
                vaciarPilaYMarcar(stackTxt, letrasUsadasMasVeces)
                underlineTextView(palabra1)
                formedWord.clear()
                cont1++
            }

            palabra2.text.toString() -> {
                showToast(formedWord.toString(), contexto)
                vaciarPilaYMarcar(stackTxt, letrasUsadasMasVeces)
                underlineTextView(palabra2)
                formedWord.clear()
                cont1++
            }

            palabra3.text.toString() -> {
                showToast(formedWord.toString(), contexto)
                vaciarPilaYMarcar(stackTxt, letrasUsadasMasVeces)
                underlineTextView(palabra3)
                formedWord.clear()
                cont1++
            }

            palabra4.text.toString() -> {
                showToast(formedWord.toString(), contexto)
                vaciarPilaYMarcar(stackTxt, letrasUsadasMasVeces)
                underlineTextView(palabra4)
                formedWord.clear()
                cont1++
            }
        }
        if (formedWord.toString().length > palabra1.length() && formedWord.toString().length > palabra2.length() &&
            formedWord.toString().length > palabra3.length() && formedWord.toString().length > palabra4.length()
        ) {
            vaciarPilaTxtView(stackTxt)
            formedWord.clear()
        } else if (cont1 >= 4) {
            btnContinuar.isVisible = true
            btnContinuar.setOnClickListener {
                val contador = paquete.getInt("valorc")
                if (contador >= 10) {
                    val puntajeTotal = paquete.getInt("valorp")
                    sonidoCorrecto(contexto)
                    alertDialogCorrectDeterminaResultado(
                        contexto,
                        puntajeTotal,
                        activity,
                        contenedorDeFragmentId
                    )
                } else {
                    respuestaCorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
                }
            }


        }
    }

    private fun underlineTextView(textView: TextView) {
        val spannableString = SpannableString(textView.text)
        spannableString.setSpan(
            UnderlineSpan(),
            0,
            spannableString.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = spannableString
    }

    private fun vaciarPilaTxtView(pila: Stack<TextView>) {
        while (pila.isNotEmpty()) {
            val it = pila.pop()
            it.setBackgroundResource(android.R.color.transparent)
        }
    }

    private fun vaciarPilaYMarcar(pila: Stack<TextView>, letrasParaUsar: Char) {
        while (pila.isNotEmpty()) {
            val it = pila.pop()
            if (it.text.toString()[0] != letrasParaUsar)
                it.isClickable = false
            it.setBackgroundResource(R.drawable.borderverdeclaro)
        }
    }

    private fun showToast(word: String, contexto: Context) {
        Toast.makeText(contexto, "Palabra formada: $word", Toast.LENGTH_SHORT).show()
    }

    // Funcion Deslizar Palabras A Un Contenedor


    @SuppressLint("ClickableViewAccessibility")
    fun deslizarPalabrasAUnContenedor(
        activity: AppCompatActivity,
        txt1: TextView,
        txt2: TextView,
        txt3: TextView,
        txt4: TextView,
        txtComprobar: TextView,
        palabraRequerida: String,
        btnComprobar: Button,
        contenedorDeFragmentId: Int,
        fragmentSiguiente: Fragment,
        paquete: Bundle,
        puntaje: Int
    ) {
        val textViewList = listOf(txt1, txt2, txt3, txt4)

        var originalX = 0f
        var originalY = 0f
        var textoOriginal = ""

        textViewList.forEach { textView ->
            textView.post {
                originalX = textView.x
                originalY = textView.y
            }

            textView.setOnTouchListener { view, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        val clipData = ClipData.newPlainText("", "")
                        val shadowBuilder = View.DragShadowBuilder(view)
                        view.startDrag(clipData, shadowBuilder, view, 0)
                        true
                    }

                    MotionEvent.ACTION_UP -> {
                        if (textView.visibility == View.INVISIBLE) {
                            textView.x = originalX
                            textView.y = originalY
                            textView.visibility = View.VISIBLE
                        }
                        true
                    }

                    else -> false
                }
            }
        }

        txtComprobar.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> true

                DragEvent.ACTION_DRAG_ENTERED -> {
                    txtComprobar.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                    true
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    txtComprobar.setBackgroundResource(R.drawable.strokedelgado)
                    true
                }

                DragEvent.ACTION_DROP -> {
                    val draggedView = event.localState as TextView
                    val draggedText = draggedView.text.toString()
                    textoOriginal = txtComprobar.text.toString()
                    txtComprobar.text = draggedText
                    txtComprobar.setBackgroundResource(R.drawable.strokedelgado)
                    draggedView.visibility = View.INVISIBLE
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> true

                else -> false
            }
        }

        txtComprobar.setOnClickListener {
            textViewList.forEach { textView ->
                if (txtComprobar.text == textView.text) {
                    textView.visibility = View.VISIBLE
                    txtComprobar.text = textoOriginal
                    textoOriginal = ""
                }
            }
        }

        var puntajeActual = puntaje

        btnComprobar.setOnClickListener {
            if (txtComprobar.text.toString().lowercase().trim() == palabraRequerida.lowercase()) {
                paquete.putInt("valorp", ++puntajeActual)
                respuestaCorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
            } else {
                paquete.putInt("valorp", puntajeActual)
                respuestaIncorrecta(activity, contenedorDeFragmentId, fragmentSiguiente, paquete)
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    fun deslizarPalabrasAUnContenedorClaseFinal(
        contexto: AppCompatActivity,
        txt1: TextView,
        txt2: TextView,
        txt3: TextView,
        txt4: TextView,
        txtComprobar: TextView,
        palabraRequerida: String,
        btnComprobar: Button,
        contenedorDeFragmentId: Int,
        paquete: Bundle,
        puntaje: Int
    ) {
        val textViewList = listOf(txt1, txt2, txt3, txt4)
        var originalX = 0f
        var originalY = 0f
        var textoOriginal = ""
        var txtComprobarOcupado = false

        textViewList.forEach { textView ->
            textView.post {
                originalX = textView.x
                originalY = textView.y
            }

            textView.setOnTouchListener { view, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        val clipData = ClipData.newPlainText("", "")
                        val shadowBuilder = View.DragShadowBuilder(view)
                        view.startDrag(clipData, shadowBuilder, view, 0)
                        true
                    }

                    MotionEvent.ACTION_UP -> {
                        if (textView.visibility == View.INVISIBLE) {
                            textView.x = originalX
                            textView.y = originalY
                            textView.visibility = View.VISIBLE
                        }
                        true
                    }

                    else -> false
                }
            }
        }

        txtComprobar.setOnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> true

                DragEvent.ACTION_DRAG_ENTERED -> {
                    txtComprobar.setBackgroundResource(R.drawable.strokedelgado_highlighted)
                    true
                }

                DragEvent.ACTION_DRAG_EXITED -> {
                    txtComprobar.setBackgroundResource(R.drawable.strokedelgado)
                    true
                }

                DragEvent.ACTION_DROP -> {
                    if (!txtComprobarOcupado) {
                        val draggedView = event.localState as TextView
                        val draggedText = draggedView.text.toString()
                        textoOriginal = txtComprobar.text.toString()
                        txtComprobar.text = draggedText
                        txtComprobar.setBackgroundResource(R.drawable.strokedelgado)
                        draggedView.visibility = View.INVISIBLE
                        txtComprobarOcupado = true
                    }
                    true
                }

                DragEvent.ACTION_DRAG_ENDED -> true

                else -> false
            }
        }

        txtComprobar.setOnClickListener {
            if (txtComprobarOcupado) {
                textViewList.forEach { textView ->
                    if (txtComprobar.text == textView.text) {
                        textView.visibility = View.VISIBLE
                        txtComprobar.text = textoOriginal
                        textoOriginal = ""
                        txtComprobarOcupado = false
                    }
                }
            }
        }

        var puntajeActual = puntaje

        btnComprobar.setOnClickListener {
            if (txtComprobar.text.toString() == palabraRequerida) {
                ++puntajeActual
                sonidoCorrecto(contexto)
                alertDialogCorrectDeterminaResultado(
                    contexto,
                    puntajeActual,
                    contexto,
                    contenedorDeFragmentId
                )
            } else {
                sonidoIncorrecto(contexto)
                Utils().alertDialogIncorrectDeterminaResultado(
                    contexto,
                    puntajeActual,
                    contexto,
                    contenedorDeFragmentId
                )
            }
        }
    }
}