package com.example.aymarswi.PantallasPrincipales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.aymarswi.ClaseAnimales.FragmentAnimales
import com.example.aymarswi.ClaseColores.FragmentColores
import com.example.aymarswi.ClaseFamilia.FragmentDinamica1
import com.example.aymarswi.ClaseNaturaleza.FragmentNaturaleza
import com.example.aymarswi.ClaseNumeros.FragmentNumeros
import com.example.aymarswi.ClaseVerbos.FragmentVerbos
import com.example.aymarswi.Clasificacion.FragmentClasificacion
import com.example.aymarswi.FragmentSaludos
import com.example.aymarswi.FragmentsGuias.FragmentGuiaBiblioteca
import com.example.aymarswi.FragmentsGuias.FragmentGuiaConversacion
import com.example.aymarswi.FragmentsGuias.FragmentGuiaDiccionario
import com.example.aymarswi.FragmentsGuias.FragmentGuiaHistorias
import com.example.aymarswi.FragmentsGuias.FragmentGuiaLecciones
import com.example.aymarswi.Objetos.FragmentObjetos1
import com.example.aymarswi.QuechuaAnimales.FragmentAnimales0Q
import com.example.aymarswi.QuechuaColores.FragmentColores0Q
import com.example.aymarswi.QuechuaFamilia.FragmentFamilia0Q
import com.example.aymarswi.QuechuaNaturaleza.FragmentNaturaleza0Q
import com.example.aymarswi.QuechuaNumeros.FragmentNumeros0Q
import com.example.aymarswi.QuechuaObejetos.FragmentObjetos0Q
import com.example.aymarswi.QuechuaSaludos.FragmentSaludo0Q
import com.example.aymarswi.QuechuaVerbos.FragmentVerbos0Q
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.model.lecciones.Lecciones
import com.example.aymarswi.model.textoLecciones.LeccionesJSON

class ActivityContenedor : AppCompatActivity() {
    private lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor)
        Actividad.getInstance(this, this, R.id.contenedorDeFragments)


        when (intent.extras?.getInt("valor")) {
            1 -> {
                LeccionesJSON.seccion("Familia")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Familia")
                fragment = FragmentDinamica1()
            }

            2 -> {
                LeccionesJSON.seccion("Naturaleza")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Naturaleza")
                fragment = FragmentNaturaleza()
            }

            3 -> {
                LeccionesJSON.seccion("Saludos")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Saludos")
                fragment = FragmentSaludos()
            }

            4 -> {
                LeccionesJSON.seccion("Animales")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Animales")
                fragment = FragmentAnimales()
            }

            5 -> {
                LeccionesJSON.seccion("Verbos")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Verbos")
                fragment = FragmentVerbos()
            }

            6 -> {
                LeccionesJSON.seccion("Colores")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Colores")
                FragmentColores()
            }

            7 -> {
                LeccionesJSON.seccion("Numeros")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Numeros")
                fragment = FragmentNumeros()
            }

            8 -> {
                LeccionesJSON.seccion("Objetos")
                Actividad.getInstanceActividad().rutaDeFragments = Lecciones().getLesson("Objetos")
                fragment = FragmentObjetos1()
            }

            9 -> FragmentFamilia0Q()
            10 -> FragmentNaturaleza0Q()
            11 -> FragmentSaludo0Q()
            12 -> FragmentAnimales0Q()
            13 -> FragmentVerbos0Q()
            14 -> FragmentColores0Q()
            15 -> FragmentNumeros0Q()
            16 -> FragmentObjetos0Q()
            93 -> FragmentGuiaDiccionario()
            94 -> FragmentGuiaLecciones()
            95 -> FragmentGuiaBiblioteca()
            96 -> FragmentAvatar2()
            97 -> FragmentClasificacion()
            98 -> FragmentGuiaConversacion()
            99 -> FragmentGuiaHistorias()
            100 -> FragmentRegistro()
            else -> FragmentDinamica1()
        }

        supportFragmentManager.commit {
            add(R.id.contenedorDeFragments, fragment)
            setReorderingAllowed(true)
        }
    }
}