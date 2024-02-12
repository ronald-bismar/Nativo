package com.example.aymarswi.model.textoLecciones

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.aymarswi.R
import com.example.aymarswi.Util.Actividad
import com.google.android.flexbox.FlexboxLayout

class CrearBoton{


    fun crearButtonTexto(palabra: String): TextView {

        val buttonTexto = TextView(Actividad.instance!!.context)
        buttonTexto.text = palabra

        buttonStyle(buttonTexto)

        buttonTexto.layoutParams = FlexboxLayout.LayoutParams(
            FlexboxLayout.LayoutParams.WRAP_CONTENT,
            FlexboxLayout.LayoutParams.WRAP_CONTENT
        )

        return buttonTexto
    }


    private fun buttonStyle(buttonTexto: TextView) {

        buttonTexto.setTextColor(ContextCompat.getColor(Actividad.instance!!.context, R.color.colorWhite))
        buttonTexto.textSize = 30F
        buttonTexto.typeface = ResourcesCompat.getFont(Actividad.instance!!.context, R.font.linotteregular)
        buttonTexto.isClickable = true
        buttonTexto.setBackgroundResource(R.color.colorPurple)
        buttonTexto.setPadding(20, 10, 20, 10)
    }
}