package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.PantallasPrincipales.ActivityContenedor.Companion.actividad
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad

class FragmentFamilia1 : Fragment() {
    private lateinit var btnPapa: ImageButton
    private lateinit var btnHermano: ImageButton
    private lateinit var rootView: View



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia1, container, false)

        initComponentes()

        Log.d("Contexto","posicion actual: ${actividad.posicionDeLaRutaDeFragments}")
        btnPapa.setOnClickListener { actividad.respuesta(true, requireActivity() as AppCompatActivity) }
        btnHermano.setOnClickListener { actividad.respuesta(false, requireActivity() as AppCompatActivity) }

        return rootView
    }

    private fun initComponentes() {
        btnPapa = rootView.findViewById(R.id.imgBtnPapa)
        btnHermano = rootView.findViewById(R.id.imgBtnHermano)
    }
}