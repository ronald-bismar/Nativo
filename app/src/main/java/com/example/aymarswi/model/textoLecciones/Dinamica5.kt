package com.example.aymarswi.model.textoLecciones

import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import com.example.aymarswi.R
import com.example.aymarswi.util.Actividad
import com.example.aymarswi.util.dinamicas.OpcionMultipleDePalabras
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
        this.oracionCompleta = oracionBase!!.enAymara[0]

        palabrasDivididas = dividirOracionPrincipal()

        posicionPalabraFaltante = (palabrasDivididas.indices).random()

        setTitle(oracionBase.enEspanol[0])
        imagen?.let { LoadImage.loadInto(imagen!!, oracionBase.imagen) }

        agregarTextViewAlContenedor(palabrasDivididas, posicionPalabraFaltante)
        colocarOpciones()
    }


    private fun agregarTextViewAlContenedor(
        palabrasDivididas: List<String>, posicionPalabraFaltante: Int
    ) {
        for ((i, palabra) in palabrasDivididas.withIndex()) {
            val texto = createTextView(palabra)
            if (i == posicionPalabraFaltante)
            // Se deja vacío el campo de la palabra faltante para que el usuario lo llene con una opción
                contOracionIncompleta.addView(missingWordStyle(texto))
            else contOracionIncompleta.addView(texto)
        }
    }

    private fun missingWordStyle(texto: TextView): TextView {
        texto.text = ""
        texto.setBackgroundResource(R.drawable.bordesrplomo)
        texto.gravity = Gravity.CENTER
        // Medir el ancho de la palabra faltante y agregar un espacio adicional para los márgenes, el padding, etc.
        val anchoTexto = texto.paint.measureText(searchTextLargeInAymara())
        val espacioAdicionalHorizontal = 30

        // Establecer el ancho con el valor de la palabra faltante más el espacio adicional
        val layoutParams = LinearLayout.LayoutParams(
            (anchoTexto + espacioAdicionalHorizontal).toInt(),
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        texto.layoutParams = layoutParams
        return texto
    }

    fun searchTextLargeInAymara(): String {
        var palabraMasLarga = palabrasDivididas[posicionPalabraFaltante]
        for (i in 1 until posicionesAleatorias.size) {
            if (palabraMasLarga.length < palabras[posicionesAleatorias[i]].enAymara[0].length) palabraMasLarga =
                palabras[posicionesAleatorias[i]].enAymara[0]
        }
        return palabraMasLarga
    }

    private fun createTextView(palabra: String): TextView {
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
        mezclarPosicionesAleatorias()/*Añadimos los datos a la vista de forma que no esten en el mismo orden cada vez (para eso se usan numeros randomicos)*/
        for (opcionIndex in 0 until contenedorOpciones.childCount) {
            //Colocamos el texto de la opcion
            (contenedorOpciones.getChildAt(opcionIndex) as TextView).text =
                if (opcionIndex == posicionPalabraFaltante) palabrasDivididas[posicionPalabraFaltante] else palabras[posicionesAleatorias[opcionIndex]].enAymara[0]
        }
    }

    override fun iniciarDinamica() {
        OpcionMultipleDePalabras().palabraVerdadera(
            getOptionsAsList(),
            palabraCorrecta = palabrasDivididas[posicionPalabraFaltante],
            palabraElegida = contOracionIncompleta.getChildAt(posicionPalabraFaltante) as TextView,
            botonComprobar = btnComprobar,
        )
    }
}