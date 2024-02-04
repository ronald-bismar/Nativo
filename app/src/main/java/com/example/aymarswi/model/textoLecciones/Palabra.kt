package com.example.aymarswi.model.textoLecciones

data class Palabra(
 val seccion: String,
 val nivelDeAprendizaje: Int,
 val enAymara: List<String>,
 val enEspanol: List<String>,
 val imagen: String,
 val palabraCorrecta: Boolean,
 val esOracion: Boolean,
 val fueAcertada: Boolean,
 val pronunciacion: String? // Puedes ajustar el tipo de datos según tus necesidades
)
