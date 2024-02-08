package com.example.aymarswi.ClaseNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentNaturaleza5 : Fragment() {

    private lateinit var btnSembrar: Button
    private lateinit var btnRegarPlanta: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_naturaleza5, container, false)

        initComponents()
//        opcionMultipleDePalabras().palabraVerdadera(btnRegarPlanta.text.toString(), btnSembrar, btnRegarPlanta)

        return rootView
    }

    private fun initComponents() {
        btnSembrar = rootView.findViewById(R.id.btnSembrar);
        btnRegarPlanta = rootView.findViewById(R.id.btnRegarPlanta)
    }
}