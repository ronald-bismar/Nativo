package com.example.aymarswi.PantallasPrincipales

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.Datos
import com.google.firebase.firestore.FirebaseFirestore
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView

class FragmentRegular : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mp = MediaPlayer.create(requireContext(), R.raw.sonidosuccessytrompeta)
        mp.start()
        val rootView: View = inflater.inflate(R.layout.fragment_regular, container, false)
        val mPuntaje = rootView.findViewById<TextView>(R.id.txtmostrardatoR1)
        mPuntaje.text = "${Actividad.getInstanceActividad().puntaje}/10"
        val gifImageView = rootView.findViewById<GifImageView>(R.id.gifMedalla)
        val gifDrawable = GifDrawable(resources, R.drawable.medalladorada)
        gifDrawable.loopCount = 2
        gifImageView.setImageDrawable(gifDrawable)

        Datos().actualizarPuntaje(requireContext(), Actividad.getInstanceActividad().puntaje, getString(R.string.prefs_file))

        return rootView
    }
}