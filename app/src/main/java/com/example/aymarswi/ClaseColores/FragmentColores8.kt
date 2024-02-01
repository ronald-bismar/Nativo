package com.example.aymarswi.ClaseColores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores8 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores8, container, false)
        val txtOHoja = rootView.findViewById<LinearLayout>(R.id.txtPChuqña)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar7)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)

        val palabraOriginal = "chuqña"
        Utils().formarPalabraConBotones(
            R.id.btnC,
            R.id.btnH,
            R.id.btnU,
            R.id.btnQ,
            R.id.btnN,
            R.id.btnA,
            palabraOriginal,
            rootView,
            txtOHoja,
            btnComprobar,
            requireActivity() as AppCompatActivity,
            FragmentColores9(),
            R.id.contenedorDeFragments,
            args, puntaje,6
        )
        return rootView
    }
}