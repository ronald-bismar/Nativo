package com.example.aymarswi.PantallasPrincipales

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.util.Actividad
import com.example.aymarswi.util.Datos

class FragmentMalo : Fragment() {

    private lateinit var btnMenu: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val mp = MediaPlayer.create(requireContext(), R.raw.sonidom)
        mp.start()
        rootView = inflater.inflate(R.layout.fragment_malo, container, false)
        initComponents()
        val mPuntaje = rootView.findViewById<TextView>(R.id.mostrardatosM1)
        mPuntaje.text = "${Actividad.getInstanceActividad().puntaje}/10"

        Datos().actualizarPuntaje(requireContext(), Actividad.getInstanceActividad().puntaje, getString(R.string.prefs_file))

        volverMenuAlMenuPrincipal()

        return rootView
    }

    private fun volverMenuAlMenuPrincipal() {
        btnMenu.setOnClickListener {
            val intent: Intent = (Intent(requireContext(), ContenedorPantallasPrincipales::class.java))
            intent.putExtra("valor", 30)
            startActivity(intent)
        }
    }

    private fun initComponents() {
        btnMenu = rootView.findViewById(R.id.button3)
    }
}