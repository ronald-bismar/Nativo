package com.example.aymarswi.ClaseFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentFamilia10 : Fragment() {
    private lateinit var btnKullaka4: Button
    private lateinit var btnJila : Button
    private lateinit var  btnJilaku: Button
    private lateinit var btnAchachila: Button
    private lateinit var etPalabra3: TextView
    private lateinit var btnComprobar: Button
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_familia10, container, false)
        initComponents()
        var puntaje = requireArguments().getInt("valorp")
        val args = Bundle()
        var contador = requireArguments().getInt("valorc")
        args.putInt("valorc", ++contador)

        btnKullaka4.setOnClickListener {
                etPalabra3.text = btnKullaka4.text.toString()
        }
        btnJila.setOnClickListener {
                etPalabra3.text = btnJila.text.toString()
        }
        btnJilaku.setOnClickListener {
                etPalabra3.text = btnJilaku.text.toString()
        }
        btnAchachila.setOnClickListener {
                etPalabra3.text = btnAchachila.text.toString()
        }
        etPalabra3.setOnClickListener {
            etPalabra3.text = ""
        }

        btnComprobar.setOnClickListener {

            if (etPalabra3.text.toString() == btnJilaku.text.toString()) {
                puntaje++
                if(contador == 10){
                    Utils().sonidoCorrecto(requireContext())
                    Utils().alertDialogCorrectDeterminaResultado(requireContext(), puntaje,requireActivity() as AppCompatActivity, R.id.fragmentContainerView3)
                }
                else {
                    args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireActivity() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentFamilia9(),
                    args
                )
                }
            } else {
                if(contador == 10){
                    Utils().sonidoCorrecto(requireContext())
                    Utils().alertDialogCorrectDeterminaResultado(requireContext(), puntaje,requireActivity() as AppCompatActivity, R.id.fragmentContainerView3)
                }
                else {
                    args.putInt("valorp", puntaje)
                    Utils().respuestaCorrecta(
                        requireActivity() as AppCompatActivity,
                        R.id.fragmentContainerView3,
                        FragmentFamilia9(),
                        args
                    )
                }
            }
        }
        return rootView  }

    private fun initComponents() {
        btnKullaka4 = rootView.findViewById(R.id.btnKullaka4)
        btnJila = rootView.findViewById(R.id.btnJila)
        btnJilaku = rootView.findViewById(R.id.btnJilaku)
        btnAchachila = rootView.findViewById(R.id.btnAchachila)
        etPalabra3 = rootView.findViewById(R.id.etContenPalabra)
        btnComprobar = rootView.findViewById(R.id.btnComprobar17)
    }
}