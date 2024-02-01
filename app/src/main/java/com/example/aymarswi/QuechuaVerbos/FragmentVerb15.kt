package com.example.aymarswi.QuechuaVerbos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerb15 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_verb15, container, false)
        val btn = rootView.findViewById<Button>(R.id.btnConfirmar)
        btn.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentVerbos0Q()
            )
        }
        return rootView
    }
}