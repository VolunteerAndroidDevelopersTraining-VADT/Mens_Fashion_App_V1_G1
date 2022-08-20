package com.example.mensfashion.ui.splash

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.mensfashion.R
import com.example.mensfashion.core.base.BaseFragment
import com.example.mensfashion.core.navigateTo
import com.example.mensfashion.databinding.FragmentSplashBinding
import com.example.mensfashion.utils.Constants
import timber.log.Timber

class SplashFragment : BaseFragment<FragmentSplashBinding>() {


    override fun setViewBinding() = FragmentSplashBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if (isLogin()) {
                navigateTo(action = R.id.action_splashFragment_to_homeFragment)
            } else {
                navigateTo(action = R.id.action_splashFragment_to_loginFragment2)
            }
        }
        hideSystemUI()


    }


    private fun isLogin(): Boolean {
        return pref.retrieve<Boolean>(Constants.IS_LOGIN) == true
    }

    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                /*
                * hide the states bar and this fun may cause null error in this fragment cause it's call before the activity fully init
                */
                requireActivity().window?.insetsController?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            } catch (e: Throwable) {
                Timber.e(e, "error while hideSystemUI ")
            }
        } else {
            try {
                Timber.e("start hideSystemUI ")
                WindowCompat.setDecorFitsSystemWindows(requireActivity().window, false)
                WindowInsetsControllerCompat(requireActivity().window, binding.root).let { controller ->
                    controller.hide(WindowInsetsCompat.Type.systemBars())
                    controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            } catch (e: Throwable) {
                Timber.e(e, "error while hideSystemUI ")
            }
        }
    }

    private fun showSystemUI() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                requireActivity().window?.insetsController?.apply {
                    show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                }
            } catch (e: Throwable) {
                Timber.e(e, "error while showSystemUI ")
            }
        } else {
            try {
                WindowCompat.setDecorFitsSystemWindows(requireActivity().window, true)
                WindowInsetsControllerCompat(requireActivity().window, binding.root).show(WindowInsetsCompat.Type.systemBars())
            } catch (e: Throwable) {
                Timber.e(e, "error while showSystemUI ")
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        showSystemUI()
    }

}