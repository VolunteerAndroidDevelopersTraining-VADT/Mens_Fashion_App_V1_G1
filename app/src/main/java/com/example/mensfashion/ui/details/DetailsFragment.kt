package com.example.mensfashion.ui.details

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.onclick
import com.example.mensfashion.databinding.FragmentDetailsBinding


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewColor.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        }
    }


//    private fun addRadioButtons(number: Int) {
//        binding.groubColor.orientation = LinearLayout.HORIZONTAL
//
//        for (i in 1..number) {
//            val rdbtn = RadioButton(requireContext())
//            rdbtn.id=View.generateViewId()
//            rdbtn.text="Radio ${ rdbtn.id}"
//            rdbtn.backgroundTintMode=context.getColor(R.color.orangy)
//
//
//                binding.groubColor.addView(rdbtn)
//            }
//        }


//    private fun onColorSelect(v:Int) {
//       print("selected")
//    }


    override fun setViewBinding(): FragmentDetailsBinding = FragmentDetailsBinding.inflate(layoutInflater)
}