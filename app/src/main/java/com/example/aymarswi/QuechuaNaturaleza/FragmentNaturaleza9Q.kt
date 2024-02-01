package com.example.aymarswi.QuechuaNaturaleza

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentNaturaleza9Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza9_q, container, false)
        val btnPanqa = rootView.findViewById<Button>(R.id.btnPanqa)
        val btnAli = rootView.findViewById<Button>(R.id.btnAli1)
        val btnChuqi1 = rootView.findViewById<Button>(R.id.btnChuqi1)
        val btnKhunu = rootView.findViewById<Button>(R.id.btnKhunu1)
        val imgVSonido = rootView.findViewById<ImageView>(R.id.imgVSonido)
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        Log.d("Valor", "Puntaje recibido $puntaje")
        Log.d("Valor", "Contador recibido $contador")
        val args = Bundle()
        args.putInt("valorc", contador)
        imgVSonido.setOnClickListener {
            val audio = MediaPlayer.create(requireContext(), R.raw.vozphisqa)
            audio.start()
        }
        btnChuqi1.setOnClickListener {
            args.putInt("valorp", ++puntaje)
            Utils().respuestaCorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentNaturaleza10Q(), args
            )
        }
        btnPanqa.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentNaturaleza10Q(), args
            )
        }
        btnAli.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentNaturaleza10Q(), args
            )
        }
        btnKhunu.setOnClickListener {
            args.putInt("valorp", puntaje)
            Utils().respuestaIncorrecta(
                requireActivity() as AppCompatActivity, R.id.contenedorDeFragments,
                FragmentNaturaleza10Q(), args
            )
        }

        return rootView
    }
}