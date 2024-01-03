package com.example.aymarswi.QuechuaNaturaleza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.QuechuaFamilia.FragmentFamilia1Q
import com.example.aymarswi.QuechuaFamilia.Fragmentfam11
import com.example.aymarswi.QuechuaFamilia.Fragmentfam12
import com.example.aymarswi.QuechuaFamilia.Fragmentfam13
import com.example.aymarswi.QuechuaFamilia.Fragmentfam14
import com.example.aymarswi.QuechuaFamilia.Fragmentfam15
import com.example.aymarswi.QuechuaFamilia.Fragmentfam16
import com.example.aymarswi.QuechuaFamilia.Fragmentfam17
import com.example.aymarswi.QuechuaFamilia.Fragmentfam18
import com.example.aymarswi.QuechuaFamilia.Fragmentfam19
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils
import com.example.aymarswi.databinding.FragmentNatu13Binding

class FragmentNaturaleza0Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_naturaleza0_q, container, false)
        val btn = rootView.findViewById<Button>(R.id.btnCont)

        val btn1 = rootView.findViewById<ImageButton>(R.id.imgBtn1)
        val btn2 = rootView.findViewById<ImageButton>(R.id.imgBtn2)
        val btn3 = rootView.findViewById<ImageButton>(R.id.imgBtn10)
        val btn4 = rootView.findViewById<ImageButton>(R.id.imgBtn3)
        val btn5 = rootView.findViewById<ImageButton>(R.id.imgBtn7)
        val btn6 = rootView.findViewById<ImageButton>(R.id.imgBtn4)
        val btn7 = rootView.findViewById<ImageButton>(R.id.imgBtn5)
        val btn8 = rootView.findViewById<ImageButton>(R.id.imgBtn6)
        val btn9 = rootView.findViewById<ImageButton>(R.id.imgBtn8)


        btn.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNaturaleza1Q()
            )
        }

        btn1.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu11()
            )
        }

        btn2.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu12()
            )
        }
        btn3.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu13()
            )
        }
        btn4.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu14()
            )
        }
        btn5.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu15()
            )
        }
        btn6.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu16()
            )
        }
        btn7.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu17()
            )
        }

        btn8.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu18()
            )
        }
        btn9.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentNatu19()
            )
        }



        return rootView
    }
}