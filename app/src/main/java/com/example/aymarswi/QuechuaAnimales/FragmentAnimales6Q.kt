package com.example.aymarswi.QuechuaAnimales

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseAnimales.FragmentAnimales7
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentAnimales6Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_animales6_q, container, false)
        val txtAnu = rootView.findViewById<TextView>(R.id.txtAnu)
        val txtWaka = rootView.findViewById<TextView>(R.id.txtWaka)
        val txtIwija = rootView.findViewById<TextView>(R.id.txtIwija)
        val txtCIwija = rootView.findViewById<TextView>(R.id.txtCIwija)
        val txtCWaka = rootView.findViewById<TextView>(R.id.txtCWaka)
        val txtCAnu = rootView.findViewById<TextView>(R.id.txtCAnu)

        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")

        val args = Bundle()
        args.putInt("valorc", ++contador)


        /* Esta funcion realiza el deslizamiento de las palabras a los contenedores vacios
        y se verifica cada una al terminar dedeslizarse */


        //Las palabras, los contenedores y las palabras correctas deben estar en un solo orden para enviarse

        Utils().deslizar3PalabrasA3Contenedores(
            requireContext() as AppCompatActivity,
            txtAnu,
            txtWaka,
            txtIwija,
            txtCAnu, txtCWaka,
            txtCIwija,
            txtAnu.text.toString(), txtWaka.text.toString(), txtIwija.text.toString(),R.id.fragmentContainerView3,
            FragmentAnimales7Q(),
            args, puntaje
        )

        return rootView
    }
}