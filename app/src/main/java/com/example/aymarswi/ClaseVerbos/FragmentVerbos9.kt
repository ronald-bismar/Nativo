package com.example.aymarswi.ClaseVerbos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerbos9 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_verbos9, container, false)
        val txtYatiqaña = rootView.findViewById<TextView>(R.id.txtYatiqaña)
        val txtLuraña = rootView.findViewById<TextView>(R.id.TxtLuraña)
        val txtComprobar1 = rootView.findViewById<TextView>(R.id.txtComprobar1)
        val txtComprobar2 = rootView.findViewById<TextView>(R.id.txtComprobar2)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar)

        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")

        val args = Bundle()
        args.putInt("valorc", ++contador)


        /* Esta funcion realiza el deslizamiento de las palabras a los contenedores vacios
        y verifica las palabras al hacer click en btnComprobar */


        Utils().deslizarPalabras(
            requireContext() as AppCompatActivity,
            txtYatiqaña,
            txtLuraña,
            txtComprobar1,
            txtComprobar2, "yatiqaña",
            "luraña",
            btnComprobar, R.id.contenedorDeFragments,FragmentVerbos10(), args,
            puntaje
        )

        return rootView
    }
}