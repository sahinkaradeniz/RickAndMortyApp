package com.example.rickandmorty.ui.splash

import android.os.CountDownTimer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.common.util.SplashSharedPreferencesManager
import com.example.rickandmorty.core.BaseFragment
import com.example.rickandmorty.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    private lateinit var splash: SplashSharedPreferencesManager
    override fun onCreateFinished() {
        splash = SplashSharedPreferencesManager(requireContext())
        binding.splashText.text = if (splash.firstLoginCheck()) "Hello!" else "Welcome!"
        splash.setLogin()

        lifecycleScope.launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            }
        }
    }
}