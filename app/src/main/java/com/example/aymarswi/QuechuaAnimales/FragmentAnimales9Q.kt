package com.example.aymarswi.QuechuaAnimales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseAnimales.FragmentAnimales10
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentAnimales9Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View =  inflater.inflate(R.layout.fragment_animales9_q, container, false)
        val etWallpa = rootView.findViewById<EditText>(R.id.etWallpa)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar11)
        val txtValido = rootView.findViewById<TextView>(R.id.txtWallpaxa)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)

        btnComprobar.setOnClickListener {
            if(etWallpa.text.toString().trim() == txtValido.text.toString() || etWallpa.text.toString() == "P'isqu wallpa yura"){
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(requireActivity() as AppCompatActivity, R.id.fragmentContainerView3, FragmentAnimales10Q(), args)
            }else{
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(requireActivity() as AppCompatActivity, R.id.fragmentContainerView3, FragmentAnimales10Q(), args)
            }
        }
        return rootView
    }
}