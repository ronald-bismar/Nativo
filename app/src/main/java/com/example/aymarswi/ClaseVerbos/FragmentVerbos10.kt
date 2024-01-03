package com.example.aymarswi.ClaseVerbos

import android.graphics.Color
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

class FragmentVerbos10 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_verbos10, container, false)
        val btnYatiqaña = rootView.findViewById<Button>(R.id.btnYatiqaña)
        val btnIkiña = rootView.findViewById<Button>(R.id.btnIkiña2)
        val btnLuraña = rootView.findViewById<Button>(R.id.btnLuraña1)
        val btnManqasi = rootView.findViewById<Button>(R.id.btnMaqasi)
        val btnHacer = rootView.findViewById<Button>(R.id.btnHacer)
        val btnEstudiar = rootView.findViewById<Button>(R.id.btnEstudiar)
        val btnDormir = rootView.findViewById<Button>(R.id.btnDormir)
        val btnComer = rootView.findViewById<Button>(R.id.btnComer1)

        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        val args = Bundle()
        args.putInt("valorc", ++contador)
        args.putInt("valorp", ++puntaje)

        Utils().encontrarParesPantallaFinal(
            requireContext() as AppCompatActivity,
            btnYatiqaña,
            btnIkiña,
            btnLuraña,
            btnManqasi,
            btnEstudiar,
            btnDormir,
            btnHacer,
            btnComer,
            R.id.fragmentContainerView3,
            puntaje
        )

        return rootView
    }
}