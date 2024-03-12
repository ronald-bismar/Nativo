package com.example.aymarswi.model.textoLecciones
data class Palabra(
 val seccion: String,
 val nivelDeAprendizaje: Int,
 val enAymara: List<String>,
 val enEspanol: List<String>,
 val imagen: String,
 var esAbstracta: Boolean,
 var esOracion: Boolean,
 val pronunciacion: String?,
)
