package com.example.aymarswi.QuechuaAnimales

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

class FragmentAnimales1Q : Fragment() {
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_animales1_q, container, false)
        val txtKatari = rootView.findViewById<TextView>(R.id.txtKatari)
        val txtApu = rootView.findViewById<TextView>(R.id.txtMallku)
        val txtSuri = rootView.findViewById<TextView>(R.id.txtSuri)
        val txtChini = rootView.findViewById<TextView>(R.id.txtChiñi)
        val txtContPalabra2 = rootView.findViewById<TextView>(R.id.txtContPalabra2)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar9)

        var puntaje = 0
        var contador = 1
        val args = Bundle()
        args.putInt("valorc", ++contador)


        /* Esta funcion realiza el deslizamiento de las palabras al contenedor vacio
        y verifica la palabra al hacer click en btnComprobar */


        Utils().deslizarPalabrasAUnContenedor(
            requireContext() as AppCompatActivity,
            txtKatari,
            txtApu,
            txtSuri,
            txtChini, txtContPalabra2,
            "Apu",
            btnComprobar, R.id.contenedorDeFragments, FragmentAnimales2Q(), args,
            puntaje
        )

        return rootView
    }
}