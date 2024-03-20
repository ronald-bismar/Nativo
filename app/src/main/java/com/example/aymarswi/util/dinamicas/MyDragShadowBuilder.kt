package com.example.aymarswi.util.dinamicas

import android.graphics.Point
import android.view.View

class MyDragShadowBuilder(v: View) : View.DragShadowBuilder(v) {
    override fun onProvideShadowMetrics(outShadowSize: Point?, outShadowTouchPoint: Point) {
        super.onProvideShadowMetrics(outShadowSize, outShadowTouchPoint)
        outShadowSize?.set(view.width, view.height)
        outShadowTouchPoint?.set(view.width / 2, view.height / 2)
    }
}