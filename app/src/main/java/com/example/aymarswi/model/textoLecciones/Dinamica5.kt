package com.example.aymarswi.model.textoLecciones

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.core.view.size
import androidx.fragment.app.Fragment
import com.example.aymarswi.ClaseFamilia.FragmentDinamica5
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.opcionMultipleDePalabras
import com.example.aymarswi.model.textoLecciones.LeccionesJSON.getUnaOracion

class Dinamica5(fragment: FragmentDinamica5) {
    private var fragment: Fragment
    private var contOracionIncompleta: LinearLayout
    private var contenedorBotonesDeOpciones: LinearLayout
    private var btnComprobar: Button
    private var posicionPalabraFaltante: Int = 0
    private lateinit var oracionIncompleta: String

    private lateinit var posicionesRandomicas: MutableList<Int>
    private lateinit var palabrasDivididas: List<String>

    init {
        this.fragment = fragment
        this.contOracionIncompleta = fragment.requireView().findViewById(R.id.llOracionIncompleta)
        this.contenedorBotonesDeOpciones = fragment.requireView().findViewById(R.id.llBotones)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar5)
    }

    fun configurar() {

        //Para remover todas las vistas de el contenedor linearlayout
        contOracionIncompleta.removeAllViews()

        this.oracionIncompleta = getUnaOracion().enAymara[0]

        palabrasDivididas = dividirOracionPrincipal()

        posicionPalabraFaltante = (palabrasDivididas.indices).random()

        agregarTextViewAlContenedor(palabrasDivididas, posicionPalabraFaltante)

        agregarBotonesDeRespuesta()
        colocarOpcionesEnLaVista()
        obtenerOpcionesComoLista()
        iniciarDinamica()

    }

    private fun agregarBotonesDeRespuesta() {
        posicionesRandomicas =
            PosicionesRandomicas(LeccionesJSON.palabras).getPosicionesRandomicasSinRepetir(
                contenedorBotonesDeOpciones.childCount,
                true
            )
    }

    private fun agregarTextViewAlContenedor(
        palabrasDivididas: List<String>,
        posicionPalabraFaltante: Int
    ) {
        for (i in palabrasDivididas.indices) {
            val texto = crearTextView(palabrasDivididas[i])
            if (i == posicionPalabraFaltante) {
                // Se deja vacío el campo de la palabra faltante para que el usuario lo llene con una opción
                contOracionIncompleta.addView(texto)
                val textView = contOracionIncompleta.getChildAt(i) as TextView
                textView.text = ""
                textView.setBackgroundResource(R.drawable.bordesrplomo)

                // Medir el ancho de la palabra faltante para que quepa en el campo y se muestre sin problemas
                val anchoTexto = textView.paint.measureText(palabrasDivididas[posicionPalabraFaltante])

                // Establecer el ancho con el valor de la palabra faltante
                val layoutParams = LinearLayout.LayoutParams(anchoTexto.toInt(), LinearLayout.LayoutParams.WRAP_CONTENT)
                textView.layoutParams = layoutParams
            } else {
                contOracionIncompleta.addView(texto)
            }
        }
    }


    private fun crearTextView(palabra: String): TextView {
        val texto = TextView(Actividad.instance?.context)
        texto.text = palabra
        texto.textSize = 25f
        texto.setPadding(10)
        return texto
    }

    private fun dividirOracionPrincipal(): List<String> {
        return oracionIncompleta.trim().split(" ")
    }

    private fun colocarOpcionesEnLaVista() {

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until contenedorBotonesDeOpciones.childCount) {

            val indexRandom = (posicionesRandomicas.indices).random()
            //Colocamos el texto de la opcion
            (contenedorBotonesDeOpciones.getChildAt(i) as TextView).text =
                if (i == posicionPalabraFaltante) palabrasDivididas[posicionPalabraFaltante] else LeccionesJSON.palabras[indexRandom].enAymara[0]

            posicionesRandomicas.removeAt(indexRandom)
        }
    }

    private fun iniciarDinamica() {

        opcionMultipleDePalabras().palabraVerdadera(
            obtenerOpcionesComoLista(),
            palabraCorrecta = palabrasDivididas[posicionPalabraFaltante],
            palabraElegida = contOracionIncompleta.getChildAt(posicionPalabraFaltante) as TextView,
            botonComprobar = btnComprobar,
        )
    }
    private fun obtenerOpcionesComoLista(): MutableList<Button> {
        val listaBotones = mutableListOf<Button>()
        for (i in 0 until contenedorBotonesDeOpciones.size) {
            listaBotones.add(contenedorBotonesDeOpciones.getChildAt(i) as Button)
        }
        return listaBotones
    }
}