package com.example.aymarswi.QuechuaColores

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

class FragmentColores3Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_colores3_q, container, false)
        val btnManzanaja = rootView.findViewById<Button>(R.id.btnManzanaja)
        val btnWilawa2 = rootView.findViewById<Button>(R.id.btnWilawa2)
        val btnLarankha = rootView.findViewById<Button>(R.id.btnLarankha)
        val btnUkaxa = rootView.findViewById<Button>(R.id.btnUkaxa)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar4)
        val txtOManzana = rootView.findViewById<TextView>(R.id.txtOManzana)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", contador)

        Utils().formarOracionConTextoDelBotonPara4Botones(
            btnManzanaja,
            btnWilawa2,
            btnLarankha,
            btnUkaxa,
            txtOManzana,
            btnComprobar,3
        )
        btnComprobar.setOnClickListener{
            val cad = Utils().obtenerOracionFormada(txtOManzana)
            Log.d("Oracion","OracionDevuelta: $cad")
            if (cad == "Uka manzanaj wilawa") {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentColores4Q(),
                    args
                )
            } else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireContext() as AppCompatActivity,
                    R.id.contenedorDeFragments,
                    FragmentColores4Q(),
                    args
                )
            }
        }
        return rootView
    }
}