package com.example.aymarswi.model.textoLecciones

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.aymarswi.Util.Actividad

object LoadImage{
    fun loadInto(imageView: ImageView, directionImage: String) {
        Glide.with(Actividad.getInstanceActividad().context)
            .load(directionImage)
            .into(imageView)
    }
}