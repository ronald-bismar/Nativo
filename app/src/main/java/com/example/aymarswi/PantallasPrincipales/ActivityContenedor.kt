package com.example.aymarswi.PantallasPrincipales

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.aymarswi.ClaseAnimales.FragmentAnimales
import com.example.aymarswi.ClaseColores.FragmentColores
import com.example.aymarswi.ClaseFamilia.FragmentFamilia1
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

class ActivityContenedor : AppCompatActivity() {
    companion object{
        lateinit var actividad: Actividad
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor)
        actividad = Actividad(this, this, R.id.fragmentContainerView3)

        when (intent.extras?.getInt("valor")) {
            1 -> {

                supportFragmentManager.commit {
                    add<FragmentFamilia1>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            2 -> {

                supportFragmentManager.commit {
                    add<FragmentNaturaleza>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)


                }
            }

            3 -> {
                supportFragmentManager.commit {
                    add<FragmentSaludos>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            4 -> {
                supportFragmentManager.commit {
                    add<FragmentAnimales>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            5 -> {
                supportFragmentManager.commit {
                    add<FragmentVerbos>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            6 -> {
                supportFragmentManager.commit {
                    add<FragmentColores>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            7 -> {
                supportFragmentManager.commit {
                    add<FragmentNumeros>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            8 -> {
                supportFragmentManager.commit {
                    add<FragmentObjetos1>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            9 -> {
                supportFragmentManager.commit {
                    add<FragmentFamilia0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }

            }

            10 -> {
                supportFragmentManager.commit {
                    add<FragmentNaturaleza0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }

            }

            11 -> {
                supportFragmentManager.commit {
                    add<FragmentSaludo0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }

            }

            12 -> {
                supportFragmentManager.commit {
                    add<FragmentAnimales0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }

            }

            13 -> {
                supportFragmentManager.commit {
                    add<FragmentVerbos0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }

            }

            14 -> {
                supportFragmentManager.commit {
                    add<FragmentColores0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }

            }

            15 -> {
                supportFragmentManager.commit {
                    add<FragmentNumeros0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }

            }

            16 -> {
                supportFragmentManager.commit {
                    add<FragmentObjetos0Q>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            93 -> {
                supportFragmentManager.commit {
                    add<FragmentGuiaDiccionario>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            94 -> {
                supportFragmentManager.commit {
                    add<FragmentGuiaLecciones>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            95 -> {
                supportFragmentManager.commit {
                    add<FragmentGuiaBiblioteca>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            96 -> {
                supportFragmentManager.commit {
                    add<FragmentAvatar2>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            97 -> {
                supportFragmentManager.commit {
                    add<FragmentClasificacion>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            98 -> {
                supportFragmentManager.commit {
                    add<FragmentGuiaConversacion>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            99 -> {
                supportFragmentManager.commit {
                    add<FragmentGuiaHistorias>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }

            100 -> {
                supportFragmentManager.commit {
                    add<FragmentRegistro>(R.id.fragmentContainerView3)
                    setReorderingAllowed(true)
                }
            }
        }
    }
}