package com.example.aymarswi.Interpoladores

import android.animation.TimeInterpolator

class InterpoladorLento: TimeInterpolator{
    override fun getInterpolation(input: Float): Float {
        val factor = 0.5f
        return 1 - Math.pow((1-input).toDouble(), 1.0/(2.0 * factor)).toFloat()
    }
}