package com.example.aymarswi.QuechuaColores

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

class FragmentColores10Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_colores10_q, container, false)
        val txtChumpi = rootView.findViewById<TextView>(R.id.txtChumpi)
        val txtChuqña = rootView.findViewById<TextView>(R.id.txtMallku)
        val txtLarama = rootView.findViewById<TextView>(R.id.txtSuri)
        val txtChiqi = rootView.findViewById<TextView>(R.id.txtChiñi)
        val txtContPalabra = rootView.findViewById<TextView>(R.id.txtContPalabra2)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar9)

        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")

        val args = Bundle()
        args.putInt("valorc", ++contador)


        /* Esta funcion realiza el deslizamiento de las palabras al contenedor vacio
        y verifica la palabra al hacer click en btnComprobar */


        Utils().deslizarPalabrasAUnContenedorClaseFinal(
            requireContext() as AppCompatActivity,
            txtChuqña,
            txtChumpi,
            txtLarama,
            txtChiqi, txtContPalabra,
            "k'awsay",
            btnComprobar, R.id.fragmentContainerView3,
            args,
            puntaje
        )

        return rootView
    }
}