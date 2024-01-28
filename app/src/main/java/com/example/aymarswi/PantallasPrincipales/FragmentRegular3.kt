package com.example.aymarswi.PantallasPrincipales

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.Datos


class FragmentRegular3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mp = MediaPlayer.create(requireContext(), R.raw.sonidotadaa)
        mp.start()
        val rootView: View = inflater.inflate(R.layout.fragment_regular3, container, false)
        val mPuntaje = rootView.findViewById<TextView>(R.id.txtmostrardatoR3)
        mPuntaje.text = "${Actividad.getInstanceActividad().puntaje}/10"

        Datos().actualizarPuntaje(requireContext(), Actividad.getInstanceActividad().puntaje, getString(R.string.prefs_file))

        return rootView
    }
}