package com.example.loginsignup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.loginsignup.databinding.FragmentFrontBinding

class FrontFragment : Fragment() {
    private lateinit var binding: FragmentFrontBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: FrontViewModel by viewModels()
        binding = FragmentFrontBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            arguments?.let {
                viewModel?.user?.value = it.getSerializable("user") as User?
            }

            bSignout.setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }
        }
    }

}