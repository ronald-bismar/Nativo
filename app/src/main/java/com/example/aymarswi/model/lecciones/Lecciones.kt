package com.example.aymarswi.model.lecciones

import androidx.fragment.app.Fragment
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica12
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1v1
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica2
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica3
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica4
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica2v1
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica5
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica6
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica7
import com.example.aymarswi.FragmentsDinamicas.FragmentDinamica2v2

class
Lecciones {
    private val lecciones: List<DataLeccion> = listOf(
        DataLeccion(
            "Familia", listOf(
                com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1(),
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
                com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1(),
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
            "Animales", listOf(
                com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1(),
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
            "Verbos", listOf(
                com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1(),
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
            "Colores", listOf(
                FragmentDinamica1(),
                FragmentDinamica7(),
                FragmentDinamica12(),
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
            "Numeros", listOf(
                com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1(),
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
            "Objetos", listOf(
                com.example.aymarswi.FragmentsDinamicas.FragmentDinamica1(),
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