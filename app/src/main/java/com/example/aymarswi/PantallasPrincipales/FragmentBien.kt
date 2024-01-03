package com.example.aymarswi.PantallasPrincipales

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.Util.Datos
import com.google.firebase.firestore.FirebaseFirestore
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView


class FragmentBien : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val db = FirebaseFirestore.getInstance()
        var puntaje = requireArguments().getInt("valorp")
        val mp = MediaPlayer.create(requireContext(), R.raw.sonidotrompeta)
        mp.start()
        val rootView: View = inflater.inflate(R.layout.fragment_bien, container, false)
        val mPuntaje = rootView.findViewById<TextView>(R.id.txtmostrardato)
        mPuntaje.text = "$puntaje/10"
        val gifImageView = rootView.findViewById<GifImageView>(R.id.trofeogif)

        val gifDrawable = GifDrawable(resources, R.drawable.trofeo)
        gifDrawable.loopCount = 1
        gifImageView.setImageDrawable(gifDrawable)

        Datos().actualizarPuntaje(requireContext(), puntaje, getString(R.string.prefs_file))

        val prefs = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val correo = prefs.getString("correo", null)

        db.collection("usuarios").document(correo.toString()).get().addOnSuccessListener { documentSnapshot ->
            val trofeos = documentSnapshot.getLong("trofeos") ?: 0

            db.collection("usuarios").document(correo.toString()).update("trofeos", trofeos+1)
                .addOnSuccessListener {
                    Log.d("Actualizacion", "La puntuación se actualizó exitosamente")
                }
                .addOnFailureListener { e ->
                    Log.d("Actualizacion", "Error al actualizar la puntuación: ${e.message}")
                }
        }

        return rootView
    }
}