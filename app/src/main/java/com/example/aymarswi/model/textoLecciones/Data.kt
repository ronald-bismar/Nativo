package com.example.aymarswi.model.textoLecciones

import androidx.fragment.app.Fragment
import com.example.aymarswi.ClaseFamilia.FragmentFamilia1
import com.example.aymarswi.ClaseFamilia.FragmentFamilia2
import com.example.aymarswi.ClaseFamilia.FragmentFamilia3
import com.example.aymarswi.ClaseFamilia.FragmentFamilia4
import com.example.aymarswi.R

class Data {
 private val datos = listOf(
  DatosView(FragmentFamilia1(), listOf(hashMapOf("titulo" to "Awki"))),
  DatosView(FragmentFamilia2(), listOf(hashMapOf("titulo" to "COMO SE DICE MAMÁ", "imagen" to "R.mipmap.mama", "boton1" to "tayka", "boton2" to "kullaka"))),
  DatosView(FragmentFamilia3(), listOf(hashMapOf("titulo" to "COMO SE ESCRIBE HERMANO?", "imagen" to "R.mipmap.hermanom"))),
  DatosView(FragmentFamilia4(), listOf(hashMapOf("titulo" to "COMO SE ESCRIBE HERMANO?", "imagen" to "R.mipmap.hermanom"))),
  )
 private data class DatosView(
  val fragment: Fragment,val views: List<HashMap<String, String>>)


}