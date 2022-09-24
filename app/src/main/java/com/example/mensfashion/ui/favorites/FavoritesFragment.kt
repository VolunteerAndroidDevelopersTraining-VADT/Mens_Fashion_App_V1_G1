package com.example.mensfashion.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mensfashion.ui.favorites.view_model.FavoritesViewModel

class FavoritesFragment : Fragment() {

    val viewModel by viewModels<FavoritesViewModel>()
    val sizeAdapter = ColorAdapter().apply {
        onItemClick={colorItem,pos,_->




        }
    }

    val colorAdapter = ColorAdapter().apply {
        onItemClick={colorItem,pos,_->
            /*
            * if color item has size list with value
            * */

            if (colorItem==""){

            }


        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}