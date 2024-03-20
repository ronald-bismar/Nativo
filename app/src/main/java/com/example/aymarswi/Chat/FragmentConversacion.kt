package com.example.aymarswi.Chat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aymarswi.PantallasPrincipales.FragmentDiccionario
import com.example.aymarswi.R
import com.example.aymarswi.databinding.FragmentConversacionBinding
import com.example.aymarswi.util.Actividad
import com.example.prueba.Mensaje
import com.example.prueba.RecyclerNombre

class FragmentConversacion : Fragment() {

    private lateinit var binding: FragmentConversacionBinding
    private var listaMensajes: MutableList<Mensaje> = mutableListOf()
    private var listaAuxiliarPreguntas: MutableList<Mensaje> = mutableListOf()
    private var listaAuxiliarRespuestas: MutableList<String> = mutableListOf()
    private var listaDeBotones = mutableMapOf<Int, Button>()
    private var click = false
    private var clickEscritura = false
    private lateinit var etMensaje: EditText
    private lateinit var recycler: RecyclerView
    private lateinit var gridLayoutBotones: GridLayout
    private var cont = 0
    var contenidoMensaje = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConversacionBinding.inflate(inflater, container, false)
        val btnEnviar = binding.iBtnSend
        val btnDiccionario = binding.btnDiccionario
        etMensaje = binding.etMensaje
        val btnBotones = binding.btnBotones
        val btnEscritura = binding.btnEscritura

        gridLayoutBotones = binding.llNuevosBotones

        btnDiccionario.setOnClickListener {
            childFragmentManager.commit {
                add(R.id.contenedorDeFragments, FragmentDiccionario())
                setReorderingAllowed(true)
            }
        }

        establecerAdaptador()


        btnEnviar.setOnClickListener {
            contenidoMensaje = binding.etMensaje.text.toString()
            if (contenidoMensaje.isNotBlank()) {
                val mensaje = Mensaje(contenidoMensaje)
                listaMensajes.add(mensaje)
                recycler.adapter?.notifyItemInserted(listaMensajes.size - 1)
                recycler.scrollToPosition(listaMensajes.size - 1)
                binding.etMensaje.text.clear()
                binding.etMensaje.clearFocus() // Restablecer el enfoque en el EditText

                if (listaMensajes[cont].toString().lowercase()
                        .equals(listaAuxiliarRespuestas[cont], ignoreCase = true)
                ) {
                    doSomething {
                        recycler.postDelayed({
                            listaMensajes.add(listaAuxiliarPreguntas[++cont])
                            recycler.adapter?.notifyItemInserted(listaMensajes.size - 1)
                            recycler.scrollToPosition(listaMensajes.size - 1)
                        }, 1000)
                    }
                } else {
                    doSomethingError {
                        recycler.postDelayed({
                            listaMensajes.add(listaAuxiliarPreguntas[++cont])
                            recycler.adapter?.notifyItemInserted(listaMensajes.size - 1)
                            recycler.scrollToPosition(listaMensajes.size - 1)
                        }, 1000)
                    }
                }

            }
        }



        btnBotones.setOnClickListener {

            if (!click || clickEscritura) {
                gridLayoutBotones.visibility = View.VISIBLE
                onBtnBotonesClick()
                click = true
            } else if (click) {
                gridLayoutBotones.visibility = View.GONE
                click = false
            }


        }

        btnEscritura.setOnClickListener {
            gridLayoutBotones.visibility = View.GONE
            clickEscritura = true
        }

        //Texto de los botones al hacer click


        return binding.root
    }

    private fun establecerAdaptador() {
        recycler = binding.lista
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = RecyclerNombre(requireContext(), listaMensajes)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        listaAuxiliarPreguntas.add(Mensaje("Aski arumakïpan jilata"))
        listaAuxiliarRespuestas.add("Aski arumakipanay kullaka! Josewa")
        listaAuxiliarPreguntas.add(Mensaje("Kamisaki jilata"))
        listaAuxiliarRespuestas.add("Waliki Juman sutimax kunasa?")
        listaAuxiliarPreguntas.add(Mensaje("Nayan sutijax Joanawa. Jumansti?"))
        listaAuxiliarRespuestas.add("Nayan sutijax Josewa.")
        listaAuxiliarPreguntas.add(Mensaje("Waliki! Qharurkama jilata Jose!"))
        listaAuxiliarRespuestas.add("Qharurkamay kullaka Joana!")

        /* Cuando el contador sea par se debe recoger la respuesta introducida por el usuario y validar si lo que se recibió
        es igual o siquiera parecido a la respuesta que es correcta validando la oracion de la lista en la posicion cont.
         */

        if (cont == 0) listaMensajes.add(listaAuxiliarPreguntas[cont])

        val inputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val isKeyboardOpen = inputMethodManager.isActive
        val etMensaje = binding.etMensaje

        etMensaje.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                scrollToLastPosition()
            }
        }

        recycler.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            if (bottom < oldBottom) {
                scrollToLastPosition()
            }
        }
    }

    private fun scrollToLastPosition() {
        recycler.postDelayed({
            recycler.scrollToPosition(listaMensajes.size - 1)
        }, 100)
    }

    fun doSomething(callback: () -> Unit) {
        recycler.postDelayed({
            /*Utils().sonidoCorrecto(requireContext())
            Utils().showAlertDialogCorrect(requireContext())*/ {
            callback()
        }
        }, 1000)

    }

    fun doSomethingError(callback: () -> Unit) {
        recycler.postDelayed({
            /*Utils().sonidoIncorrecto(requireContext())
            Utils().showAlertDialogIncorrect(requireContext()) */{
            callback()
        }
        }, 1000)

    }

    fun onBtnBotonesClick() {

        // for para llenar la lista de botones con los 4 botones creados

        val palabras = listaAuxiliarRespuestas[cont].split(" ")
        val gridLayoutBotones = requireView().findViewById<GridLayout>(R.id.llNuevosBotones)

        // Eliminar los botones existentes del GridLayout
        gridLayoutBotones.removeAllViews()

        for (i in 0 until palabras.size) {
            val boton = Button(requireContext())

            boton.text = palabras[i]
            boton.setBackgroundResource(R.drawable.boton_con_sombra_rojo)
            boton.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorWhite))
            boton.setTextSize(20F)
            boton.setPadding(0, 5, 0, 5)
            boton.isAllCaps = false

            val fuente = ResourcesCompat.getFont(requireContext(), R.font.linotteregular)
            boton.typeface = fuente

            /* Definiendo el tamaño del boton para que entre en un espacio de una columna y fila
            en el GridLayout */
            val tamBoton = GridLayout.LayoutParams()
            tamBoton.rowSpec = GridLayout.spec(
                i / 2,
                1f
            ) // Ocurre 2 veces para 2 filas (0/2=0, 1/2=0, 2/2=1, 3/2=1)
            tamBoton.columnSpec = GridLayout.spec(
                i % 2,
                1f
            ) // Ocurre dos veces para 2 columnas (0%2=0, 1%2=1, 2%2=0, 3%2=1)
            tamBoton.setMargins(20, 20, 20, 20)
            tamBoton.width = 160
            tamBoton.height = 100

            boton.layoutParams = tamBoton
            boton.id = View.generateViewId()
            listaDeBotones[boton.id] = boton
            boton.setOnClickListener {
                hacerClickBoton(boton)
            }
        }

        // Llenar los botones en el linear layout
        for ((_, boton) in listaDeBotones) {
            gridLayoutBotones.addView(boton)
        }
        listaDeBotones.clear()
    }

    private fun hacerClickBoton(boton: Button) {
        etMensaje.append("${boton.text} ")
    }
}