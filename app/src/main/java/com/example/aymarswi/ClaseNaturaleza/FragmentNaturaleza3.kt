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

class FragmentNaturaleza3 : Fragment() {
    private lateinit var btnPanqara1: Button
    private lateinit var btnJallu: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_naturaleza3, container, false)
       initComponents()

        opcionMultipleDePalabras().palabraVerdadera(btnPanqara1.text.toString(), btnPanqara1, btnJallu)
        return rootView
    }

    private fun initComponents() {
        btnPanqara1 = rootView.findViewById(R.id.btnPanqara1)
        btnJallu = rootView.findViewById(R.id.btnJallu)
    }
}