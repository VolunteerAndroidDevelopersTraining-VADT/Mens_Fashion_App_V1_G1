package com.example.mensfashion.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mensfashion.R
import com.example.mensfashion.databinding.FragmentSplashBinding
import com.example.mensfashion.ui.MainActivity
import com.example.mensfashion.utils.ShardPref

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       ShardPref.creatPrefObj(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShopeNow.setOnClickListener {
            if (ShardPref.isLoggedIn()) {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }  else{
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }
        }
    }
}