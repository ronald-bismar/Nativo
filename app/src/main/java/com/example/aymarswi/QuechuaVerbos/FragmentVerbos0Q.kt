package com.example.aymarswi.QuechuaVerbos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.QuechuaAnimales.FragmentAnimales1Q
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu11
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu12
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu13
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu14
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu15
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu16
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu17
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu18
import com.example.aymarswi.QuechuaNaturaleza.FragmentNatu19
import com.example.aymarswi.QuechuaNaturaleza.FragmentNaturaleza1Q
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentVerbos0Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_verbos0_q, container, false)
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
        val btn10 = rootView.findViewById<ImageButton>(R.id.imgBtn)
        val btn11 = rootView.findViewById<ImageButton>(R.id.imgBtn9)


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
                FragmentVerb11()
            )
        }

        btn2.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb12()
            )
        }
        btn3.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb13()
            )
        }
        btn4.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb14()
            )
        }
        btn5.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb15()
            )
        }
        btn6.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb16()
            )
        }
        btn7.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb17()
            )
        }

        btn8.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb18()
            )
        }
        btn9.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb19()
            )
        }
        btn10.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb20()
            )
        }
        btn11.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.fragmentContainerView3,
                FragmentVerb10()
            )
        }



        return rootView
    }
}