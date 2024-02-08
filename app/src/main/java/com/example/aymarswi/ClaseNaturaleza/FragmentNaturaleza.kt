package com.example.aymarswi.ClaseNaturaleza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.aymarswi.R
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentNaturaleza : Fragment() {
    private lateinit var rootView: View
    private lateinit var btnAli:Button
    private lateinit var btnPanqara:Button
    private lateinit var btnPallqa:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_naturaleza, container, false)
        initComponents()


//        opcionMultipleDePalabras().palabraVerdaderaLL(palabraCorrecta = btnAli.text.toString(), btnAli, btnPanqara, btnPallqa)

        return rootView
    }

    private fun initComponents() {
        btnAli = rootView.findViewById(R.id.btnAli)
        btnPanqara = rootView.findViewById(R.id.btnPanqara)
        btnPallqa = rootView.findViewById(R.id.btnPallqa)
    }
}