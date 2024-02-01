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

class FragmentNaturaleza4 : Fragment() {

    private lateinit var btnLloviendo: Button
    private lateinit var btnAmaneciendo: Button
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_naturaleza4, container, false)
        initComponents()
        opcionMultipleDePalabras().palabraVerdadera(btnLloviendo.text.toString(), btnLloviendo, btnAmaneciendo)
        return rootView
    }

    private fun initComponents() {
        btnLloviendo = rootView.findViewById(R.id.btnLloviendo);
        btnAmaneciendo = rootView.findViewById(R.id.btnAmaneciendo)
    }

}