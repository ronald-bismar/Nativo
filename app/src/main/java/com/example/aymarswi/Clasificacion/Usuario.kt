package com.example.aymarswi.Clasificacion

import java.net.URL

data class Usuario(
    val imagenPerfil: Int,
    val nombreUsuario: String,
    val nivel: String,
    val puntaje: Int,
    val imagenIconos: Int
): Comparable<Usuario>{
    override fun compareTo(other: Usuario): Int {
        return other.puntaje.compareTo(puntaje)
    }
}