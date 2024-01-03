package com.example.aymarswi.QuechuaObejetos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.QuechuaSaludos.FragmentSaludo1Q
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentObjetos0Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_objetos0_q, container, false)
        val btn = rootView.findViewById<Button>(R.id.btnCont)
        btn.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentObjetos1Q()
            )
        }

        return rootView
    }
}