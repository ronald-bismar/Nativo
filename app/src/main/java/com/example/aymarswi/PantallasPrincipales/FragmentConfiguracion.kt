package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.aymarswi.R

class FragmentConfiguracion : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_configuracion, container, false)

        val btnAtras = rootView.findViewById<ImageButton>(R.id.imgBtnAtras)

        btnAtras.setOnClickListener {

            requireActivity().onBackPressed()

        }

        return rootView
    }

}