package com.example.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.homework.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.fetchData(requireContext(), binding.appCompatImageView)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.updateButton.setOnClickListener {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    launch {
                            viewModel.fetchData(requireContext(), binding.appCompatImageView)
                    }
                }

            }
        }


    }

}
