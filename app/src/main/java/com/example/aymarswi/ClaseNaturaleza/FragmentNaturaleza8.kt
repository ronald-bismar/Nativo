package com.example.aymarswi.ClaseNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras


class FragmentNaturaleza8 : Fragment() {
    private lateinit var obText: EditText
    private lateinit var btnComprobar: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_naturaleza8, container, false)
        initComponents()

        opcionMultipleDePalabras().palabraVerdadera(
            "ali",
            palabraElegida = obText,
            botonComprobar = btnComprobar,
        )
        return rootView
    }

    private fun initComponents() {
        btnComprobar = rootView.findViewById(R.id.btnComp2)
        obText = rootView.findViewById(R.id.txtResp2)
    }

}