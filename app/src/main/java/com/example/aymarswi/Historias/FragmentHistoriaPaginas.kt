package com.example.aymarswi.Historias

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.example.aymarswi.R

class FragmentHistoriaPaginas : Fragment() {

    private lateinit var scrollView1: ScrollView
    private lateinit var scrollView2: ScrollView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lectura_traducida, container, false)
        scrollView1 = view.findViewById(R.id.ScrollView1)
        scrollView2 = view.findViewById(R.id.ScrollView2)
        return view
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val touchListener = ScrollTouchListener()

        scrollView1.setOnTouchListener { _, event -> touchListener.onTouch(scrollView1, scrollView2, event) }
        scrollView2.setOnTouchListener { _, event -> touchListener.onTouch(scrollView2, scrollView1, event) }
    }

    inner class ScrollTouchListener {

        fun onTouch(scrollView: ScrollView, otherScrollView: ScrollView, event: MotionEvent): Boolean {
            otherScrollView.onTouchEvent(event)
            return scrollView.onTouchEvent(event)
        }
    }
}