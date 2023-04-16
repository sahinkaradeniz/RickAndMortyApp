package com.example.rickandmorty.ui.splash

import android.os.CountDownTimer
import androidx.navigation.fragment.findNavController
import com.example.common.core.BaseFragment
import com.example.common.util.SplashSharedPreferencesManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    private lateinit var splash: SplashSharedPreferencesManager
    override fun onCreateFinished() {
        splash = SplashSharedPreferencesManager(requireContext())
        binding.splashText.text = if (splash.firstLoginCheck()) "Hello!" else "Welcome!"
        splash.setLogin()
        closeSplash()
    }
    private fun closeSplash() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            }
        }.start()
    }
}