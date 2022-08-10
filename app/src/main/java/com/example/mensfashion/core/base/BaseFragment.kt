package com.example.mensfashion.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.mensfashion.App

abstract class BaseFragment<bindingObj : ViewDataBinding> : Fragment() {
    // set view binding in the child class
    abstract fun setViewBinding(): bindingObj

    lateinit var navController: NavController

    private var _binding: bindingObj? = null
    val binding: bindingObj get() = _binding!!
    val pref = App.pref

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = setViewBinding()
        navController=findNavController()
        // can't understander what next 3 line do
        _binding?.let {
            it.executePendingBindings()
            it.lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null   // destroy the view binding
    }
}