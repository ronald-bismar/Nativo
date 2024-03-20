package com.example.aymarswi.PantallasPrincipales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.aymarswi.R
class FragmentMenuDeLeccionesQ : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_menu_de_lecciones_q, container, false)

        val imgBtnFamilia = rootView.findViewById<ImageButton>(R.id.imgBtnFamilia)
        val imgBtnNaturaleza = rootView.findViewById<ImageButton>(R.id.imgBtnNaturaleza)
        val imgSaludos = rootView.findViewById<ImageButton>(R.id.imgBtnSaludos)
        val imgBtnAnimales = rootView.findViewById<ImageButton>(R.id.imgBtnAnimales)
        val imgBtnVerbos = rootView.findViewById<ImageButton>(R.id.imgBtnVerbos)
        val imgBtnColores = rootView.findViewById<ImageButton>(R.id.imgBtnColores)
        val imgBtnNumeros = rootView.findViewById<ImageButton>(R.id.imgBtnNumeros)
        val imgBtnObjetos = rootView.findViewById<ImageButton>(R.id.imgBtnObjetos)
        imgBtnFamilia.setOnClickListener{
            val intent = Intent(requireContext(), ActivityContenedor::class.java)
            intent.putExtra("valor", 1)
            startActivity(intent)
        }
        imgBtnNaturaleza.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 2)
            startActivity(intent)
        }
        imgSaludos.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 3)
            startActivity(intent)
        }
        imgBtnAnimales.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 4)
            startActivity(intent)
        }
        imgBtnVerbos.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 5)
            startActivity(intent)
        }
        imgBtnColores.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 6)
            startActivity(intent)
        }
        imgBtnNumeros.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 7)
            startActivity(intent)
        }
        imgBtnObjetos.setOnClickListener{
            val intent = Intent(requireContext(),ActivityContenedor::class.java)
            intent.putExtra("valor", 8)
            startActivity(intent)
        }

        return rootView
    }
}