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
import com.example.aymarswi.ClaseColores.FragmentColores4
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentNaturaleza10 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza10, container, false)
        val btnWaraña = rootView.findViewById<Button>(R.id.btnWaraña)
        val btnKhunu = rootView.findViewById<Button>(R.id.btnKhunu)
        val btnJawira1 = rootView.findViewById<Button>(R.id.btnJawira1)
        val btnUmampi = rootView.findViewById<Button>(R.id.btnUmampi)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar18)
        val txtORegar = rootView.findViewById<TextView>(R.id.txtORegar)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val args = Bundle()
        args.putInt("valorc", ++contador)

        Utils().formarOracionConTextoDelBotonPara4Botones(
            btnWaraña,
            btnKhunu,
            btnJawira1,
            btnUmampi,
            txtORegar,
            btnComprobar,2
        )
        btnComprobar.setOnClickListener{
            val cad = Utils().obtenerOracionFormada(txtORegar)
            Log.d("Oracion","OracionDevuelta: $cad")
            if (cad.trim().lowercase() == "umampi waraña") {
                if(contador == 10){
                    ++puntaje
                    Utils().sonidoCorrecto(requireContext())
                    Utils().alertDialogCorrectDeterminaResultado(requireContext(), puntaje, requireActivity() as AppCompatActivity, R.id.fragmentContainerView3)
                }else {
                    args.putInt("valorp", ++puntaje)
                    Utils().respuestaCorrecta(
                        requireContext() as AppCompatActivity,
                        R.id.fragmentContainerView3,
                        FragmentNaturaleza8(),
                        args
                    )
                }
            } else {
                if(contador == 10){
                    Utils().sonidoIncorrecto(requireContext())
                    Utils().alertDialogIncorrectDeterminaResultado(requireContext(), puntaje, requireActivity() as AppCompatActivity, R.id.fragmentContainerView3)
                }else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.fragmentContainerView3,
                    FragmentNaturaleza8(),
                    args
                )
                }
            }
        }
        return rootView  }
}