package com.example.aymarswi.PantallasPrincipales

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.util.Actividad
import com.example.aymarswi.util.Datos
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView
class FragmentRegular2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_regular2, container, false)
        //val btnMenu = rootView.findViewById<Button>(R.id.btnMenu)
        MediaPlayer.create(requireContext(), R.raw.sonidotrompeta).start()
        val mPuntaje = rootView.findViewById<TextView>(R.id.txtmostrardatoR2)
        mPuntaje.text = "${Actividad.instance!!.puntaje}/10"

        val gifImageView = rootView.findViewById<GifImageView>(R.id.gifMedallaP)
        val gifDrawable = GifDrawable(resources, R.drawable.medallaplateada)
        gifDrawable.loopCount = 2
        gifImageView.setImageDrawable(gifDrawable)

        Datos().actualizarPuntaje(requireContext(), Actividad.instance!!.puntaje, getString(R.string.prefs_file))


        return rootView
    }
}