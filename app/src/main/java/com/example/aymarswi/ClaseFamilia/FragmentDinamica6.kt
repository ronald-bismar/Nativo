package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.aymarswi.R
import com.example.aymarswi.model.textoLecciones.Dinamica6

class FragmentDinamica6 : Fragment() {

    lateinit var btnTayka: Button
    lateinit var btnTiwula: Button
    lateinit var btnIpa: Button
    lateinit var btnKullaka: Button
    lateinit var btnComprobar: Button
    lateinit var etPalabra: TextView
    lateinit var rootView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_familia7, container, false)

        iniciarComponentes()


        return rootView
    }

    private fun iniciarComponentes() {
        btnTayka = rootView.findViewById(R.id.btnTayka)
        btnTiwula = rootView.findViewById(R.id.btnTiwula)
        btnIpa = rootView.findViewById(R.id.btnIpa)
        btnKullaka = rootView.findViewById(R.id.btnKullaka)
        etPalabra = rootView.findViewById(R.id.campoRespuesta)
        btnComprobar = rootView.findViewById(R.id.btnComprobar6)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dinamica6(this)
    }
}