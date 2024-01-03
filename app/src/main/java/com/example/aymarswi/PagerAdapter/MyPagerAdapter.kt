package com.example.aymarswi.PagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.aymarswi.Avatars.FragmentA1
import com.example.aymarswi.Avatars.FragmentA10
import com.example.aymarswi.Avatars.FragmentA11
import com.example.aymarswi.Avatars.FragmentA2
import com.example.aymarswi.Avatars.FragmentA3
import com.example.aymarswi.Avatars.FragmentA4
import com.example.aymarswi.Avatars.FragmentA5
import com.example.aymarswi.Avatars.FragmentA6
import com.example.aymarswi.Avatars.FragmentA7
import com.example.aymarswi.Avatars.FragmentA8
import com.example.aymarswi.Avatars.FragmentA9
import java.lang.IllegalArgumentException

class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 11
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
                0 -> FragmentA1()

                1 -> FragmentA2()

                2 -> FragmentA3()

                3 -> FragmentA4()

                4 -> FragmentA5()

                5 -> FragmentA6()

                6 -> FragmentA7()

                7 -> FragmentA8()

                8 -> FragmentA9()

                9 -> FragmentA10()

                10 -> FragmentA11()

                else -> throw IllegalArgumentException("PosicionInvalida")
            }
        }
    }