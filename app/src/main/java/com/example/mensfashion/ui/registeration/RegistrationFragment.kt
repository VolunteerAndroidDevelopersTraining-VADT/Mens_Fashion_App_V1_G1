package com.example.mensfashion.ui.registeration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentRegisterationBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RegistrationFragment :BaseFragment<FragmentRegisterationBinding>(){
  private val registrationViewModel:RegisterationViewModel by viewModels()
  lateinit var registrationViewPagerAdapter:RegistrationViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPagerWithTabLayout()
        addTabLayoutMediator()
//        setUpFacebookButton()
//        setUpGoogleButton()
        setUpTabLayout()

    }


    private fun setUpViewPagerWithTabLayout() {
       registrationViewPagerAdapter=RegistrationViewPagerAdapter(this)
        binding.viewPager.apply {
            adapter=registrationViewPagerAdapter
            addTabLayoutMediator()
        }

    }

    private fun addTabLayoutMediator() {
        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab:TabLayout.Tab,position:Int ->
          tab.text =  when(position){
                0-> getString(R.string.login_tab_title)
                1-> getString(R.string.signUp_tab_title)
              else -> ""
          }

        }.attach()
    }
    private fun setUpTabLayout() {
        binding.tabLayout.apply {
            translationX= 300F
            alpha=0f
            animate().translationX(0f).alpha(1f).setDuration(1000).setStartDelay(400).start()
        }
    }

//     private  fun setUpFacebookButton(){
//         binding.fabFb.apply {
//             translationY= 300F
//             alpha=0f
//             animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(400).start()
//         }
//     }
//    private  fun setUpGoogleButton(){
//        binding.fabGoogle.apply {
//            translationY=300F
//            alpha=0f
//            animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(600).start()
//
//        }
    //}
    override fun setViewBinding(): FragmentRegisterationBinding = FragmentRegisterationBinding.inflate(layoutInflater)

}