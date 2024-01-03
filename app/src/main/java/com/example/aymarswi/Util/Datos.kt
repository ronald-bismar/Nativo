package com.example.aymarswi.Util

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.aymarswi.R
import com.google.firebase.firestore.FirebaseFirestore

class Datos {


    fun actualizarPuntaje(contexto: Context, puntaje: Int, preferences: String) {

        Log.d("Puntaje", "Puntaje obtenido de la leccion: $puntaje")
        // Instancia de Firestore
        val db = FirebaseFirestore.getInstance()
        // Actualizar puntaje del usuario
        var puntajeAcumulado: Long = 0
        var nivelUsuario = ""

        val prefs = contexto.getSharedPreferences(
            preferences,
            Context.MODE_PRIVATE
        )
        val correo = prefs.getString("correo", null)

        db.collection("usuarios").document(correo.toString()).get().addOnSuccessListener { document ->
            puntajeAcumulado = document.getLong("puntuacion") ?: 0
            Log.d("Puntaje", "Puntaje obtenido de firebase: $puntajeAcumulado")

            puntajeAcumulado += puntaje.toLong()

            Log.d("Puntaje", "Puntaje y puntaje Acumulado: $puntajeAcumulado")

            if (puntajeAcumulado >= 0 && puntajeAcumulado <= 49) {
                nivelUsuario = "Principiante"
            } else if (puntajeAcumulado >= 50 && puntajeAcumulado <= 99) {
                nivelUsuario = "Elemental"
            } else if (puntajeAcumulado >= 100 && puntajeAcumulado <= 149) {
                nivelUsuario = "Intermedio"
            } else if (puntajeAcumulado >= 150 && puntajeAcumulado <= 199) {
                nivelUsuario = "Intermedio Alto"
            } else if (puntajeAcumulado >= 200 && puntajeAcumulado <= 249) {
                nivelUsuario = "Avanzado"
            } else if (puntajeAcumulado >= 250) {
                nivelUsuario = "Competente"
            }

            db.collection("usuarios").document(correo.toString()).update(
                hashMapOf<String, Any>(
                    "puntuacion" to puntajeAcumulado,
                    "nivel" to nivelUsuario
                )
            ).addOnSuccessListener {
                Log.d("Puntaje", "Se actualizo el puntaje el cual es $puntajeAcumulado")
            }.addOnFailureListener { e ->
                Log.d("Actualizacion", "Error al actualizar los datos")
            }
        }
    }
    fun determinarNivel(estrellas: Int, trofeos: Int, medallasDoradas: Int, medallasPlateadas: Int): Int{
        var idIcono = 0
        if(estrellas > 0){
            when(estrellas){
                1-> idIcono = R.mipmap.unaestrella1
                2-> idIcono = R.mipmap.dosestrellas
                3-> idIcono = R.mipmap.tresestrellas1
                4-> idIcono = R.mipmap.cuatroestrellas
                5-> idIcono = R.mipmap.cincoestrellas
            }
        }
        else if(trofeos > 0){
            when(trofeos){
                1-> idIcono = R.mipmap.untrofeo
                2-> idIcono = R.mipmap.dostrofeos
                3-> idIcono = R.mipmap.trestrofeos
                4-> idIcono = R.mipmap.cuatrotrofeos
                5-> idIcono = R.mipmap.cincotrofeos
            }
        }
        else if(medallasDoradas > 0){
            when(medallasDoradas){
                1-> idIcono = R.mipmap.unamedalladorada
                2-> idIcono = R.mipmap.dosmedallasdoradas
                3-> idIcono = R.mipmap.tresmedallasdoradas
                4-> idIcono = R.mipmap.cuatromedallasdoradas
                5-> idIcono = R.mipmap.cincomedallas
            }
        }
        else if(medallasPlateadas > 0){
            when(medallasPlateadas){
                1-> idIcono = R.mipmap.unamedallaplateada
                2-> idIcono = R.mipmap.dosmedallasplateadas
                3-> idIcono = R.mipmap.tresmedallasplateadas
                4-> idIcono = R.mipmap.cuatromedallasplateadas
                5-> idIcono = R.mipmap.cincomedallasplateadas
            }
        }
        return idIcono
    }
    fun actualizarPreferenciasDeObjetos(contexto: Context, preferences: String, claseObjeto: Int){

    }
}