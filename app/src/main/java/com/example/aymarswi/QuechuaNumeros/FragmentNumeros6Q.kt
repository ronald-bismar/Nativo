package com.example.aymarswi.QuechuaNumeros

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

class FragmentNumeros6Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_numeros6_q, container, false)

        val btnPusi1 = view.findViewById<Button>(R.id.btnPusi1)
        val btnPhisqa1 = view.findViewById<Button>(R.id.btnPhisqa1)
        val btnKimsa1 = view.findViewById<Button>(R.id.btnKimsa1)
        val btbMaya1 = view.findViewById<Button>(R.id.btbMaya1)
        val btnPaya1 = view.findViewById<Button>(R.id.btnPaya1)

        val btnPusi2 = view.findViewById<Button>(R.id.btnPusi2)
        val btnPhisqa2 = view.findViewById<Button>(R.id.btnPhisqa2)
        val btnKimsa2 = view.findViewById<Button>(R.id.btnKimsa2)
        val btbMaya2 = view.findViewById<Button>(R.id.btbMaya2)
        val btnPaya2 = view.findViewById<Button>(R.id.btnPaya2)

        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        args.putInt("valorp", ++puntaje)
        Utils().encontrar5Pares(requireActivity() as AppCompatActivity, requireContext() as AppCompatActivity,btnPusi1,btnPhisqa1,btnKimsa1,btbMaya1,btnPaya1,btnPusi2,btnPhisqa2,btnKimsa2,btbMaya2,btnPaya2,R.id.contenedorDeFragments,
            FragmentNumeros7Q(),args)

        return view
    }
}