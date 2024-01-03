package com.example.aymarswi.PantallasPrincipales

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.aymarswi.PantallasPrincipales.ActivityContenedor.Companion.actividad
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.Datos

class FragmentMalo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mp = MediaPlayer.create(requireContext(), R.raw.sonidom)
        mp.start()
        val rootView: View = inflater.inflate(R.layout.fragment_malo, container, false)
        Toast.makeText(
            requireContext(),
            "Longitud ${actividad.rutaDeFragments.size}",
            Toast.LENGTH_SHORT
        ).show()
        val mPuntaje = rootView.findViewById<TextView>(R.id.mostrardatosM1)
        mPuntaje.text = "${actividad.puntaje}/10"

        Datos().actualizarPuntaje(requireContext(), actividad.puntaje, getString(R.string.prefs_file))

        return rootView
    }
}