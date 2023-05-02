package com.example.loginsignup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.loginsignup.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: LogInViewModel by viewModels()
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            bLogin.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_mainFragment_to_logInFragment
                )
            }

            bSignup.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_mainFragment_to_signUpFragment
                )
            }
        }
    }
}