package com.example.aymarswi.QuechuaNumeros

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

class FragmentNumeros10Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rooView: View = inflater.inflate(R.layout.fragment_numeros10_q, container, false)
        val pa = rooView.findViewById<EditText>(R.id.pa)
        val saqa = rooView.findViewById<EditText>(R.id.saqa)
        val tu = rooView.findViewById<EditText>(R.id.tu)
        val ka = rooView.findViewById<EditText>(R.id.ka)
        val btnComprobar = rooView.findViewById<Button>(R.id.btnComprobar14)

        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        btnComprobar.setOnClickListener {
            if (pa.text.toString().trim().lowercase() == "pa" && saqa.text.toString().trim()
                    .lowercase() == "saqa" && tu.text.toString().trim()
                    .lowercase() == "tu" && ka.text.toString().trim()
                    .lowercase() == "ka"
            ) {
                args.putInt("valorp", ++puntaje)
                Utils().alertDialogCorrectDeterminaResultado(requireContext(), puntaje,requireActivity() as AppCompatActivity,R.id.fragmentContainerView3)
            } else {
                args.putInt("valorp", puntaje)
                Utils().alertDialogIncorrectDeterminaResultado(requireContext(), puntaje,requireActivity() as AppCompatActivity,R.id.fragmentContainerView3)
            }
        }


        return rooView  }
}