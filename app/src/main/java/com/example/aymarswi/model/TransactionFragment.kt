package com.example.aymarswi.model

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

object TransactionFragment {
    fun changeFragment(activity: AppCompatActivity, newFragment: Fragment, container: Int){
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}