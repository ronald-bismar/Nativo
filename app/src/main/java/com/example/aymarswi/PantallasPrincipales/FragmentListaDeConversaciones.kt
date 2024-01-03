package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.aymarswi.Chat.FragmentConversacion
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentListaDeConversaciones : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView= inflater.inflate(R.layout.fragment_lista_de_conversaciones, container, false)

        val btnSaludos = rootView.findViewById<ConstraintLayout>(R.id.btnAruntanaka)
        btnSaludos.setOnClickListener {
            Utils().pasarDeFragment(requireActivity() as AppCompatActivity, R.id.ContenedorP_Principales, FragmentConversacion())
        }
    return rootView
    }
}