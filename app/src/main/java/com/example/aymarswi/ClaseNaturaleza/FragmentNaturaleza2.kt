package com.example.aymarswi.ClaseNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentNaturaleza2 : Fragment() {

    private lateinit var btnCebada: Button
    private lateinit var btnPapa1: Button
    private lateinit var btnComp: Button
    private lateinit var etPapa: TextView
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       rootView = inflater.inflate(R.layout.fragment_naturaleza2, container, false)
        initComponents()

        return rootView
    }
    private fun initComponents() {
        btnCebada = rootView.findViewById(R.id.btnCebada)
        btnPapa1 = rootView.findViewById(R.id.btnPapa1)
        btnComp = rootView.findViewById(R.id.btnComp3)
        etPapa = rootView.findViewById(R.id.etPapa)
    }
}