package com.example.mensfashion.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(){
   private val homeViewModel by viewModels<HomeViewModel> ()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)



}