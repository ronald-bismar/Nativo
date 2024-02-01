package com.example.aymarswi.Historias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.aymarswi.ClaseFamilia.FragmentFamilia1
import com.example.aymarswi.R
class FragmentHistoriaTupakKatari : Fragment() {

    private lateinit var textView: TextView
    private lateinit var maskView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val rootView = inflater.inflate(R.layout.fragment_historia_tupak_katari, container, false)
        val btnHist = rootView.findViewById<Button>(R.id.btnHist)
        textView = rootView.findViewById(R.id.txtDeslizable)

        val animation = AnimationUtils.loadAnimation(context, R.anim.creditos_animacion)
        textView.startAnimation(animation)
        btnHist.setOnClickListener {
            val fragment = FragmentFamilia1()
            val transaccion: FragmentTransaction = requireActivity().supportFragmentManager
                .beginTransaction().replace(R.id.contenedorDeFragments,fragment)
            transaccion.commit()
        }
        return rootView
    }
}