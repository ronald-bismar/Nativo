package com.example.aymarswi.Saludos

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentSaludos10 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_saludos10, container, false)
        val btnBDias = rootView.findViewById<Button>(R.id.btnBDias)
        val btnBTardes = rootView.findViewById<Button>(R.id.btnBTardes)
        val btnBNoches = rootView.findViewById<Button>(R.id.btnBNoches)
        val imgVSonido1 = rootView.findViewById<ImageView>(R.id.imgVSonido1)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val args = Bundle()
        args.putInt("valorc", contador)
        imgVSonido1.setOnClickListener {
            val audio = MediaPlayer.create(requireContext(), R.raw.vozphisqa)
            audio.start()
        }
        btnBDias.setOnClickListener {
            if(contador == 10){
                Utils().sonidoIncorrecto(requireContext())
                Utils().alertDialogIncorrectDeterminaResultado(requireContext(), puntaje, requireActivity() as AppCompatActivity, R.id.fragmentContainerView3)
            }else{
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(requireActivity() as AppCompatActivity, R.id.fragmentContainerView3,
                    FragmentSaludos8(), args)
            }

        }
        btnBTardes.setOnClickListener {
            if (contador == 10) {
                ++puntaje
                Utils().sonidoCorrecto(requireContext())
                Utils().alertDialogCorrectDeterminaResultado(
                    requireContext(),
                    puntaje,
                    requireActivity() as AppCompatActivity,
                    R.id.fragmentContainerView3
                )
            } else {
                args.putInt("valorp", ++puntaje)
                Utils().respuestaCorrecta(
                    requireActivity() as AppCompatActivity, R.id.fragmentContainerView3,
                    FragmentSaludos8(), args
                )
            }
        }
        btnBNoches.setOnClickListener {
            if(contador == 10){
                Utils().sonidoIncorrecto(requireContext())
                Utils().alertDialogIncorrectDeterminaResultado(requireContext(), puntaje, requireActivity() as AppCompatActivity, R.id.fragmentContainerView3)
            }else {
                args.putInt("valorp", puntaje)
                Utils().respuestaIncorrecta(
                    requireActivity() as AppCompatActivity, R.id.fragmentContainerView3,
                    FragmentSaludos8(), args
                )
            }
        }
        return rootView    }
}