package com.example.aymarswi.QuechuaNumeros

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseNumeros.FragmentNumeros3
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentNumeros2Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_numeros2_q, container, false)
        val txtKimsa = rootView.findViewById<TextView>(R.id.txtKimsa)
        val txtPhisqa = rootView.findViewById<TextView>(R.id.txtPhisqa)
        val txtKimsaqallqu = rootView.findViewById<TextView>(R.id.txtKimsaqallqu1)
        val txtCKimsa = rootView.findViewById<TextView>(R.id.txtCKimsa)
        val txtCPhisqa = rootView.findViewById<TextView>(R.id.txtCPhisqa)
        val txtCKimsaqallqu = rootView.findViewById<TextView>(R.id.txtCKimsaqallqu)

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
            txtKimsa,
            txtPhisqa,
            txtKimsaqallqu,
            txtCKimsa, txtCPhisqa,
            txtCKimsaqallqu,
            txtKimsa.text.toString(), txtPhisqa.text.toString(), txtKimsaqallqu.text.toString(),R.id.fragmentContainerView3,
            FragmentNumeros3Q(),
            args, puntaje
        )

        return rootView   }
}