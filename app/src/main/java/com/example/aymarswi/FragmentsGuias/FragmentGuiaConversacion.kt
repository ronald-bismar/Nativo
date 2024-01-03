package com.example.aymarswi.FragmentsGuias

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.Chat.FragmentConversacion
import com.example.aymarswi.PantallasPrincipales.FragmentListaDeConversaciones
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.databinding.FragmentListaDeConversacionesBinding

class FragmentGuiaConversacion : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_guia_conversacion, container, false)
        val botonEmpezar = rootView.findViewById<Button>(R.id.btnEmpezarConversacion)

        botonEmpezar.setOnClickListener {
            Utils().pasarDeFragment(requireActivity() as
                    AppCompatActivity,R.id.ContenedorP_Principales, FragmentListaDeConversaciones())
        }
    return rootView
    }
}