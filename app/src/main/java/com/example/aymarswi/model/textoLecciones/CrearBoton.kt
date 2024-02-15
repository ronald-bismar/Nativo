package com.example.aymarswi.model.textoLecciones

import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.google.android.flexbox.FlexboxLayout

class CrearBoton{


    fun crearButtonTexto(palabra: String): TextView {

        val buttonTexto = TextView(Actividad.instance!!.context)
        buttonTexto.text = palabra

        buttonStyle(buttonTexto)

        return buttonTexto
    }


    private fun buttonStyle(buttonTexto: TextView) {
        buttonTexto.setTextColor(ContextCompat.getColor(Actividad.instance!!.context, R.color.colorWhite))
        buttonTexto.textSize = 25F
        buttonTexto.typeface = ResourcesCompat.getFont(Actividad.instance!!.context, R.font.linotteregular)
        buttonTexto.isClickable = true
        buttonTexto.setBackgroundResource(R.color.colorPurple)

        // Crear los parámetros de diseño
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(10) // Establecer márgenes
        buttonTexto.layoutParams = layoutParams

        buttonTexto.setPadding(10)
    }
}