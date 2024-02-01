package com.example.aymarswi.model.lecciones

import androidx.fragment.app.Fragment
import com.example.aymarswi.ClaseAnimales.FragmentAnimales
import com.example.aymarswi.ClaseAnimales.FragmentAnimales10
import com.example.aymarswi.ClaseAnimales.FragmentAnimales2
import com.example.aymarswi.ClaseAnimales.FragmentAnimales3
import com.example.aymarswi.ClaseAnimales.FragmentAnimales4
import com.example.aymarswi.ClaseAnimales.FragmentAnimales5
import com.example.aymarswi.ClaseAnimales.FragmentAnimales6
import com.example.aymarswi.ClaseAnimales.FragmentAnimales7
import com.example.aymarswi.ClaseAnimales.FragmentAnimales8
import com.example.aymarswi.ClaseAnimales.FragmentAnimales9
import com.example.aymarswi.ClaseColores.FragmentColores
import com.example.aymarswi.ClaseColores.FragmentColores10
import com.example.aymarswi.ClaseColores.FragmentColores2
import com.example.aymarswi.ClaseColores.FragmentColores3
import com.example.aymarswi.ClaseColores.FragmentColores4
import com.example.aymarswi.ClaseColores.FragmentColores5
import com.example.aymarswi.ClaseColores.FragmentColores6
import com.example.aymarswi.ClaseColores.FragmentColores7
import com.example.aymarswi.ClaseColores.FragmentColores8
import com.example.aymarswi.ClaseColores.FragmentColores9
import com.example.aymarswi.ClaseFamilia.FragmentFamilia1
import com.example.aymarswi.ClaseFamilia.FragmentFamilia10
import com.example.aymarswi.ClaseFamilia.FragmentFamilia2
import com.example.aymarswi.ClaseFamilia.FragmentFamilia3
import com.example.aymarswi.ClaseFamilia.FragmentFamilia4
import com.example.aymarswi.ClaseFamilia.FragmentFamilia5
import com.example.aymarswi.ClaseFamilia.FragmentFamilia6
import com.example.aymarswi.ClaseFamilia.FragmentFamilia7
import com.example.aymarswi.ClaseFamilia.FragmentFamilia8
import com.example.aymarswi.ClaseFamilia.FragmentFamilia9
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza10
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza2
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza3
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza4
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza5
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza6
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza7
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza8
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza9
import com.example.aymarswi.ClaseNumeros.FragmentNumeros
import com.example.aymarswi.ClaseNumeros.FragmentNumeros10
import com.example.aymarswi.ClaseNumeros.FragmentNumeros2
import com.example.aymarswi.ClaseNumeros.FragmentNumeros3
import com.example.aymarswi.ClaseNumeros.FragmentNumeros4
import com.example.aymarswi.ClaseNumeros.FragmentNumeros5
import com.example.aymarswi.ClaseNumeros.FragmentNumeros6
import com.example.aymarswi.ClaseNumeros.FragmentNumeros7
import com.example.aymarswi.ClaseNumeros.FragmentNumeros8
import com.example.aymarswi.ClaseNumeros.FragmentNumeros9
import com.example.aymarswi.ClaseSaludos.FragmentSaludos2
import com.example.aymarswi.ClaseSaludos.FragmentSaludos3
import com.example.aymarswi.ClaseSaludos.FragmentSaludos4
import com.example.aymarswi.ClaseSaludos.FragmentSaludos5
import com.example.aymarswi.ClaseSaludos.FragmentSaludos6
import com.example.aymarswi.ClaseVerbos.FragmentVerbos
import com.example.aymarswi.ClaseVerbos.FragmentVerbos10
import com.example.aymarswi.ClaseVerbos.FragmentVerbos2
import com.example.aymarswi.ClaseVerbos.FragmentVerbos3
import com.example.aymarswi.ClaseVerbos.FragmentVerbos4
import com.example.aymarswi.ClaseVerbos.FragmentVerbos5
import com.example.aymarswi.ClaseVerbos.FragmentVerbos6
import com.example.aymarswi.ClaseVerbos.FragmentVerbos7
import com.example.aymarswi.ClaseVerbos.FragmentVerbos8
import com.example.aymarswi.ClaseVerbos.FragmentVerbos9
import com.example.aymarswi.FragmentSaludos
import com.example.aymarswi.Objetos.FragmentObjetos1
import com.example.aymarswi.Objetos.FragmentObjetos10
import com.example.aymarswi.Objetos.FragmentObjetos2
import com.example.aymarswi.Objetos.FragmentObjetos3
import com.example.aymarswi.Objetos.FragmentObjetos4
import com.example.aymarswi.Objetos.FragmentObjetos5
import com.example.aymarswi.Objetos.FragmentObjetos6
import com.example.aymarswi.Objetos.FragmentObjetos7
import com.example.aymarswi.Objetos.FragmentObjetos8
import com.example.aymarswi.Objetos.FragmentObjetos9
import com.example.aymarswi.Saludos.FragmentSaludos10
import com.example.aymarswi.Saludos.FragmentSaludos7
import com.example.aymarswi.Saludos.FragmentSaludos8
import com.example.aymarswi.Saludos.FragmentSaludos9

class Lecciones {
    private val lecciones: List<DataLeccion> = listOf(
        DataLeccion(
            "Familia", listOf(
                FragmentFamilia1(),
                FragmentFamilia2(),
                FragmentFamilia3(),
                FragmentFamilia4(),
                FragmentFamilia5(),
                FragmentFamilia6(),
                FragmentFamilia7(),
                FragmentFamilia8(),
                FragmentFamilia9(),
                FragmentFamilia10()
            )
        ),
        DataLeccion(
            "Naturaleza", listOf(
                FragmentNaturaleza(),
                FragmentNaturaleza2(),
                FragmentNaturaleza3(),
                FragmentNaturaleza4(),
                FragmentNaturaleza5(),
                FragmentNaturaleza6(),
                FragmentNaturaleza7(),
                FragmentNaturaleza8(),
                FragmentNaturaleza9(),
                FragmentNaturaleza10()
            )
        ),
        DataLeccion(
            "Saludos", listOf(
                FragmentSaludos(),
                FragmentSaludos2(),
                FragmentSaludos3(),
                FragmentSaludos4(),
                FragmentSaludos5(),
                FragmentSaludos6(),
                FragmentSaludos7(),
                FragmentSaludos8(),
                FragmentSaludos9(),
                FragmentSaludos10()
            )
        ),
        DataLeccion(
            "Animales", listOf(
                FragmentAnimales(),
                FragmentAnimales2(),
                FragmentAnimales3(),
                FragmentAnimales4(),
                FragmentAnimales5(),
                FragmentAnimales6(),
                FragmentAnimales7(),
                FragmentAnimales8(),
                FragmentAnimales9(),
                FragmentAnimales10()
            )
        ),
        DataLeccion(
            "Verbos", listOf(
                FragmentVerbos(),
                FragmentVerbos2(),
                FragmentVerbos3(),
                FragmentVerbos4(),
                FragmentVerbos5(),
                FragmentVerbos6(),
                FragmentVerbos7(),
                FragmentVerbos8(),
                FragmentVerbos9(),
                FragmentVerbos10()
            )
        ),
        DataLeccion(
            "Colores", listOf(
                FragmentColores(),
                FragmentColores2(),
                FragmentColores3(),
                FragmentColores4(),
                FragmentColores5(),
                FragmentColores6(),
                FragmentColores7(),
                FragmentColores8(),
                FragmentColores9(),
                FragmentColores10()
            )
        ),
        DataLeccion(
            "Numeros", listOf(
                FragmentNumeros(),
                FragmentNumeros2(),
                FragmentNumeros3(),
                FragmentNumeros4(),
                FragmentNumeros5(),
                FragmentNumeros6(),
                FragmentNumeros7(),
                FragmentNumeros8(),
                FragmentNumeros9(),
                FragmentNumeros10()
            )
        ),
        DataLeccion(
            "Objetos", listOf(
                FragmentObjetos1(),
                FragmentObjetos2(),
                FragmentObjetos3(),
                FragmentObjetos4(),
                FragmentObjetos5(),
                FragmentObjetos6(),
                FragmentObjetos7(),
                FragmentObjetos8(),
                FragmentObjetos9(),
                FragmentObjetos10()
            )
        ),
    )

    fun getLesson(nameLesson: String): List<Fragment> {
        var leccionSolicitada = listOf<Fragment>()
        for (leccion in lecciones) {
            if (nameLesson.equals(leccion.nameLesson, ignoreCase = true))
                leccionSolicitada = leccion.fragmentsLessons
        }
        return leccionSolicitada
    }
}