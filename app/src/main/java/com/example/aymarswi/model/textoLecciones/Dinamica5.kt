package com.example.aymarswi.model.textoLecciones

import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aymarswi.ClaseFamilia.FragmentDinamica5
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.example.aymarswi.Util.dinamicas.OpcionMultipleDePalabras
import com.example.aymarswi.model.textoLecciones.LeccionesJSON.getUnaOracion
import com.example.aymarswi.model.textoLecciones.LeccionesJSON.palabras

class Dinamica5(fragment: Fragment) : BaseDinamica(fragment) {

    private var contOracionIncompleta: LinearLayout
    private var posicionPalabraFaltante: Int = 0
    private lateinit var oracionCompleta: String
    private lateinit var palabrasDivididas: List<String>

    init {
        this.fragment = fragment
        this.title = fragment.requireView().findViewById(R.id.txtTitleD5)
        this.imagen = fragment.requireView().findViewById(R.id.imagenD5)
        this.contOracionIncompleta = fragment.requireView().findViewById(R.id.llOracionIncompleta)
        this.contenedorOpciones = fragment.requireView().findViewById(R.id.contenedorOpcionesD5)
        this.btnComprobar = fragment.requireView().findViewById(R.id.btnComprobar5)

        configurar(sinOraciones = true)
    }

    override fun colocarDatosEnLaVista() {

        //Para remover todas las vistas de el contenedor linearlayout
        contOracionIncompleta.removeAllViews()
        val oracionBase = getUnaOracion()
        this.oracionCompleta = oracionBase.enAymara[0]

        palabrasDivididas = dividirOracionPrincipal()

        posicionPalabraFaltante = (palabrasDivididas.indices).random()

        title?.text = oracionBase.enEspanol[0]

        if(imagen != null){
            Glide.with(Actividad.getInstanceActividad().context)
                .load(oracionBase.imagen)
                .into(imagen!!)
        }


        agregarTextViewAlContenedor(palabrasDivididas, posicionPalabraFaltante)
        colocarOpciones()
    }


    private fun agregarTextViewAlContenedor(
        palabrasDivididas: List<String>, posicionPalabraFaltante: Int
    ) {
        for (i in palabrasDivididas.indices) {
            val texto = crearTextView(palabrasDivididas[i])
            if (i == posicionPalabraFaltante) {
                // Se deja vacío el campo de la palabra faltante para que el usuario lo llene con una opción
                contOracionIncompleta.addView(texto)
                val textView = contOracionIncompleta.getChildAt(i) as TextView
                textView.text = ""
                textView.setBackgroundResource(R.drawable.bordesrplomo)
                textView.gravity = Gravity.CENTER
                // Medir el ancho de la palabra faltante y agregar un espacio adicional para los márgenes, el padding, etc.
                val anchoTexto =
                    textView.paint.measureText(searchTextLargeInAymara())
                val espacioAdicional = 30

                // Establecer el ancho con el valor de la palabra faltante más el espacio adicional
                val layoutParams = LinearLayout.LayoutParams(
                    (anchoTexto + espacioAdicional).toInt(), LinearLayout.LayoutParams.WRAP_CONTENT
                )
                textView.layoutParams = layoutParams
            } else {
                contOracionIncompleta.addView(texto)
            }
        }
    }

    fun searchTextLargeInAymara(): String {
        var palabraMasLarga = palabrasDivididas[posicionPalabraFaltante]
        for (i in 1 until posicionesAleatorias.size) {
            if (palabraMasLarga.length < palabras[posicionesAleatorias[i]].enAymara[0].length)
                palabraMasLarga = palabras[posicionesAleatorias[i]].enAymara[0]
        }
        return palabraMasLarga
    }

    private fun crearTextView(palabra: String): TextView {
        val texto = TextView(Actividad.instance?.context)
        texto.text = palabra
        texto.textSize = 25f
        texto.setPadding(10)
        return texto
    }

    private fun dividirOracionPrincipal(): List<String> {
        return oracionCompleta.trim().split(" ")
    }

    private fun colocarOpciones() {

        /*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (i in 0 until contenedorOpciones.childCount) {
            val indexRandom = (0 until posicionesAleatorias.size).random()
            //Colocamos el texto de la opcion
            (contenedorOpciones.getChildAt(i) as TextView).text =
                if (i == posicionPalabraFaltante) palabrasDivididas[posicionPalabraFaltante] else LeccionesJSON.palabras[posicionesAleatorias[indexRandom]].enAymara[0]

            posicionesAleatorias.removeAt(indexRandom)
        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            obtenerOpcionesComoLista(),
            palabraCorrecta = palabrasDivididas[posicionPalabraFaltante],
            palabraElegida = contOracionIncompleta.getChildAt(posicionPalabraFaltante) as TextView,
            botonComprobar = btnComprobar,
        )
    }
}