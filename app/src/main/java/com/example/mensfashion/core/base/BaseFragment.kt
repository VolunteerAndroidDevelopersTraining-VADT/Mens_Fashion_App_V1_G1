package com.example.mensfashion.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<bindingObj : ViewDataBinding,vm:ViewModel> : Fragment() {
    // set view binding in the child class
    abstract fun setViewBinding(): bindingObj
    // set viewModel in child
    abstract fun initializeViewModel():vm

    private var _binding: bindingObj? = null
    val binding: bindingObj = _binding!!
    lateinit var viewModel: vm
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = setViewBinding()
        viewModel = initializeViewModel()
        // can't understander what next 3 line do
        _binding?.let {
            it.executePendingBindings()
            it.lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null   // destroy the view binding
    }
}