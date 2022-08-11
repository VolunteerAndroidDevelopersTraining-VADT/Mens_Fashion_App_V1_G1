package com.example.mensfashion.ui.registeration

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mensfashion.ui.login.LoginFragment
import com.example.mensfashion.ui.register.RegisterFragment

class RegistrationViewPagerAdapter (fragment: Fragment): FragmentStateAdapter(fragment){
    override fun getItemCount(): Int=2
    override fun createFragment(position: Int): Fragment {

   when(position){
       0 ->return LoginFragment()
       1-> return RegisterFragment()

   }
       return LoginFragment()
    }
}