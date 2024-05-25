package com.example.aymarswi.ApiRest

data class User(
    var idUser: Int = -1,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var level: String = "", //Rango mas alto alcanzado por el usuario
    var imageProfileR: String = "",
    var imageProfileC: String = "",
    var estrellas: Long = 0,
    var trofeos: Long = 0,
    var medallasDoradas: Long = 0,
    var medallasPlateadas: Long = 0,
    var language: String = ""
)
