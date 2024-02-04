package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.model.textoLecciones.Palabra
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class FragmentFamilia1 : Fragment() {
    private lateinit var btnPapa: ImageButton
    private lateinit var btnHermano: ImageButton
    private lateinit var rootView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia1, container, false)

        initComponents()

        Glide.with(this).load(listaPalabras[2].imagen).into(btnHermano)

        Actividad.getInstanceActividad().setPalabraCorrecta("Papá")
        btnPapa.setOnClickListener { Actividad.getInstanceActividad().respuesta(true) }
        btnHermano.setOnClickListener { Actividad.getInstanceActividad().respuesta(false) }

        return rootView
    }

    private fun initComponents() {
        btnPapa = rootView.findViewById(R.id.imgBtnPapa)
        btnHermano = rootView.findViewById(R.id.imgBtnHermano)
    }
}