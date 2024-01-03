package com.example.aymarswi.ApiRest

import com.example.aymarswi.Clasificacion.Usuario
import com.google.gson.annotations.SerializedName

data class UsuariosResponse(@SerializedName("listaUsuarios") var listaUsuarios: ArrayList<Usuario>)

