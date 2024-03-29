package com.example.aymarswi.PantallasPrincipales

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.util.Actividad
import com.example.aymarswi.util.Datos
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView


class FragmentBien : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_bien, container, false)

        MediaPlayer.create(requireContext(), R.raw.sonidotrompeta).start()

        val mPuntaje = rootView.findViewById<TextView>(R.id.txtmostrardato)
        mPuntaje.text = "${Actividad.getInstanceActividad().puntaje}/10"
        val gifImageView = rootView.findViewById<GifImageView>(R.id.trofeogif)

        val gifDrawable = GifDrawable(resources, R.drawable.trofeo)
        gifDrawable.loopCount = 1
        gifImageView.setImageDrawable(gifDrawable)

        Datos().actualizarPuntaje(requireContext(), Actividad.getInstanceActividad().puntaje, getString(R.string.prefs_file))

        return rootView
    }
}