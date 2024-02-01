package com.example.aymarswi.QuechuaFamilia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils


class FragmentFamilia0Q : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_familia0_q, container, false)
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


        val args = Bundle()

        btn.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                FragmentFamilia1Q()
            )
        }

        btn1.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam11()
            )
        }

        btn2.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam12()
            )
        }
        btn3.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam13()
            )
        }
        btn4.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam14()
            )
        }
        btn5.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam15()
            )
        }
        btn6.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam16()
            )
        }
        btn7.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam17()
            )
        }

        btn8.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam18()
            )
        }
        btn9.setOnClickListener {
            Utils().pasarDeFragment(
                requireActivity() as AppCompatActivity,
                R.id.contenedorDeFragments,
                Fragmentfam19()
            )
        }



        return rootView
    }
}