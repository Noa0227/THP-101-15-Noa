package com.example.loginsignup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.loginsignup.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: LogInViewModel by viewModels()
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewModel?.email?.observe(viewLifecycleOwner) {
                inputvalid()
            }
            viewModel?.password?.observe(viewLifecycleOwner) {
                inputvalid()
            }

            bLoginOk.setOnClickListener {
                if (!inputvalid()) {
                    return@setOnClickListener
                }
                val bundle = Bundle()
                val email = viewModel!!.email.value
                val password = viewModel!!.password.value
                val user = User(email, password)
                bundle.putString("email", email)
                bundle.putString("password", password)
                bundle.putSerializable("user", user)
                Navigation.findNavController(it).navigate(
                    R.id.action_logInFragment_to_frontFragment,
                    bundle
                )
            }

            bLoginFgpassword.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_logInFragment_to_FGPWFragment
                )
            }
        }
    }

    private fun inputvalid(): Boolean {
        var valid = true
        with(binding) {
            val email = viewModel?.email?.value?.trim()
            val password = viewModel?.password?.value?.trim()
            if (email == null || email.isEmpty()) {
                etLoginEmail.error = "帳號不可空白"
                valid = false
            }
            if (password == null || password.isEmpty()) {
                etLoginPassword.error = "密碼不可空白"
                valid = false
            }
        }
        return valid
    }
}