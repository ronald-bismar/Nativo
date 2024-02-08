package com.example.aymarswi.ClaseNaturaleza

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras

class FragmentNaturaleza7 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza7, container, false)
        val llAli = rootView.findViewById<LinearLayout>(R.id.llAli)
        val llPanqara = rootView.findViewById<LinearLayout>(R.id.llPanqara)
        val llKhunu = rootView.findViewById<LinearLayout>(R.id.llKhunu)
        val llKhunuqullu = rootView.findViewById<LinearLayout>(R.id.llKhunuqullu)

//        opcionMultipleDePalabras().palabraVerdadera((llPanqara.getChildAt(1) as TextView).text.toString(), llAli, llPanqara, llKhunu, llKhunuqullu)

        return rootView    }
}