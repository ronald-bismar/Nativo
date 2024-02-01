package com.example.aymarswi.ClaseColores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentColores6 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_colores6, container, false)
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
            FragmentColores7(),
            R.id.contenedorDeFragments,
            args, puntaje,
            4)
        return rootView
    }
}