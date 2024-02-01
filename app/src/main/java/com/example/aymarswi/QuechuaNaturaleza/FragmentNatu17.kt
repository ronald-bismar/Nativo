package com.example.aymarswi.QuechuaNaturaleza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentNatu17 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_natu17, container, false)
        val btn = rootView.findViewById<Button>(R.id.btnConfirmar)
        btn.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentNaturaleza0Q()
            )
        }
        return rootView
    }
}