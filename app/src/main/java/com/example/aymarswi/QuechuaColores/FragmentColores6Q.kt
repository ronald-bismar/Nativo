package com.example.aymarswi.QuechuaColores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.ClaseColores.FragmentColores7
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores6Q : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores6_q, container, false)
        val txtOHoja = rootView.findViewById<LinearLayout>(R.id.txtOHoja)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar6)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()
        args.putInt("valorc", ++contador)

        val oracionOriginal = "La hoja es verde"
        Utils().formarOracionConBotones(
            R.id.btnEs,
            R.id.btnHoja,
            R.id.btnLa,
            R.id.btnRama,
            R.id.btnVerde,
            R.id.btnCafe,
            oracionOriginal,
            rootView,
            txtOHoja,
            btnComprobar,
            requireActivity() as AppCompatActivity,
            FragmentColores7Q(),
            R.id.fragmentContainerView3,
            args, puntaje,
            4)
        return rootView
    }
}