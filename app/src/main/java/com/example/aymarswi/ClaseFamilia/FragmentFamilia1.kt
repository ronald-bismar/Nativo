package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
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

        Log.d("Contexto","posicion actual: ${Actividad.getInstance().posicionDeLaRutaDeFragments}")
        Actividad.getInstance().setPalabraCorrecta("Papá")
        btnPapa.setOnClickListener { Actividad.getInstance().respuesta(true) }
        btnHermano.setOnClickListener { Actividad.getInstance().respuesta(false) }

        return rootView
    }

    private fun initComponentes() {
        btnPapa = rootView.findViewById(R.id.imgBtnPapa)
        btnHermano = rootView.findViewById(R.id.imgBtnHermano)
    }
}