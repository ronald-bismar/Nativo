package com.example.aymarswi.model.lecciones

import androidx.fragment.app.Fragment
import com.example.aymarswi.ClaseFamilia.FragmentDinamica10
import com.example.aymarswi.ClaseAnimales.FragmentAnimales10
import com.example.aymarswi.ClaseAnimales.FragmentAnimales2
import com.example.aymarswi.ClaseAnimales.FragmentAnimales3
import com.example.aymarswi.ClaseAnimales.FragmentAnimales4
import com.example.aymarswi.ClaseAnimales.FragmentAnimales5
import com.example.aymarswi.ClaseAnimales.FragmentAnimales6
import com.example.aymarswi.ClaseFamilia.FragmentDinamica11
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
import com.example.aymarswi.ClaseFamilia.FragmentDinamica1v1
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2
import com.example.aymarswi.ClaseFamilia.FragmentDinamica3
import com.example.aymarswi.ClaseFamilia.FragmentDinamica4
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2v1
import com.example.aymarswi.ClaseFamilia.FragmentDinamica5
import com.example.aymarswi.ClaseFamilia.FragmentDinamica6
import com.example.aymarswi.ClaseFamilia.FragmentDinamica7
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2v2
import com.example.aymarswi.ClaseFamilia.FragmentDinamica8
import com.example.aymarswi.ClaseNumeros.FragmentNumeros10
import com.example.aymarswi.ClaseNumeros.FragmentNumeros5
import com.example.aymarswi.ClaseNumeros.FragmentNumeros6
import com.example.aymarswi.ClaseNumeros.FragmentNumeros7
import com.example.aymarswi.ClaseNumeros.FragmentNumeros8
import com.example.aymarswi.ClaseNumeros.FragmentNumeros9
import com.example.aymarswi.ClaseSaludos.FragmentSaludos2
import com.example.aymarswi.ClaseSaludos.FragmentSaludos3
import com.example.aymarswi.ClaseSaludos.FragmentSaludos4
import com.example.aymarswi.ClaseFamilia.FragmentDinamica5v1
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
import com.example.aymarswi.ClaseFamilia.FragmentDinamica2v3

class Lecciones {
    private val lecciones: List<DataLeccion> = listOf(
        DataLeccion(
            "Familia", listOf(
                com.example.aymarswi.ClaseFamilia.FragmentDinamica1(),
                FragmentDinamica2(),
                FragmentDinamica3(),
                FragmentDinamica4(),
                FragmentDinamica2v1(),
                FragmentDinamica5(),
                FragmentDinamica6(),
                FragmentDinamica6(),
                FragmentDinamica7(),
                FragmentDinamica6()
            )
        ),
        DataLeccion(
            "Naturaleza", listOf(
                FragmentDinamica2v2(),
                FragmentDinamica3(),
                FragmentDinamica2v2(),
                FragmentDinamica1v1(),
                FragmentDinamica6(),
                FragmentDinamica5(),
                FragmentDinamica6(),
                FragmentDinamica2v1(),
                FragmentDinamica7(),
                FragmentDinamica6()
            )
        ),
        DataLeccion(
            "Saludos", listOf(
                FragmentSaludos(),
                FragmentSaludos2(),
                FragmentSaludos3(),
                FragmentSaludos4(),
                FragmentDinamica5v1(),
                FragmentSaludos6(),
                FragmentSaludos7(),
                FragmentSaludos8(),
                FragmentDinamica2v3(),
                FragmentSaludos10()
            )
        ),
        DataLeccion(
            "Animales", listOf(
                FragmentDinamica10(),
                FragmentAnimales2(),
                FragmentAnimales3(),
                FragmentAnimales4(),
                FragmentAnimales5(),
                FragmentAnimales6(),
                FragmentDinamica11(),
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
                FragmentDinamica11(),
                FragmentDinamica7(),
                FragmentDinamica8(),
                FragmentDinamica10(),
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