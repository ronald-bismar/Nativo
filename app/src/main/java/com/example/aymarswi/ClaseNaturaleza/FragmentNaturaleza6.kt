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

class FragmentNaturaleza6 : Fragment() {
    private lateinit var btnPanq: Button
    private lateinit var btnJawira: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_naturaleza6, container, false)
        initComponents()

        opcionMultipleDePalabras().palabraVerdadera(btnJawira.text.toString(), btnJawira, btnPanq)

        return rootView
    }

    private fun initComponents() {
        btnPanq = rootView.findViewById(R.id.btnPanq)
        btnJawira = rootView.findViewById(R.id.btnJawira)
    }
}