package com.example.aymarswi.Objetos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aymarswi.R
import com.example.aymarswi.Util.Utils

class FragmentObjetos10 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_objetos10, container, false)
        val btnWaraña = rootView.findViewById<Button>(R.id.btnWaraña)
        val btnKhunu = rootView.findViewById<Button>(R.id.btnKhunu)
        val btnJawira1 = rootView.findViewById<Button>(R.id.btnJawira1)
        val btnUmampi = rootView.findViewById<Button>(R.id.btnUmampi)
        val btnComprobar = rootView.findViewById<Button>(R.id.btnComprobar18)
        val txtORegar = rootView.findViewById<TextView>(R.id.txtORegar)
        //Acceder a los valores enviado desde el anterior fragment
        var puntaje = requireArguments().getInt("valorp")
        var contador = requireArguments().getInt("valorc")
        val args = Bundle()

        Log.d("Puntaje", "Puntaje recibido es: $puntaje")
        Log.d("Puntaje", "Contador recibido es: $contador")
        args.putInt("valorc", ++contador)

        Utils().formarOracionConTextoDelBotonPara4Botones(
            btnWaraña,
            btnKhunu,
            btnJawira1,
            btnUmampi,
            txtORegar,
            btnComprobar,1
        )
        btnComprobar.setOnClickListener{
            val cad = Utils().obtenerOracionFormada(txtORegar)
            Log.d("Oracion","OracionDevuelta: $cad")
            if (cad.trim().lowercase() == "raphi") {
                puntaje = puntaje+1
                if(contador == 10){
                    Utils().sonidoCorrecto(requireContext())
                    Utils().alertDialogCorrectDeterminaResultado(
                        requireContext(), puntaje,
                        requireActivity() as AppCompatActivity, R.id.contenedorDeFragments)
                }else {
                    Utils().sonidoCorrecto(requireContext())
                    Utils().alertDialogCorrectDeterminaResultado(
                        requireContext(), puntaje,
                        requireActivity() as AppCompatActivity, R.id.contenedorDeFragments)

                }
            } else {
                if(contador == 10){
                    Utils().sonidoIncorrecto(requireContext())
                    Utils().alertDialogIncorrectDeterminaResultado(
                        requireContext(), puntaje,
                        requireActivity() as AppCompatActivity, R.id.contenedorDeFragments)
                }else {
                    args.putInt("valorp", puntaje)
                    Utils().sonidoIncorrecto(requireContext())
                    Utils().alertDialogIncorrectDeterminaResultado(
                        requireContext(), puntaje,
                        requireActivity() as AppCompatActivity, R.id.contenedorDeFragments)
                }
            }
        }
        return rootView  }
}