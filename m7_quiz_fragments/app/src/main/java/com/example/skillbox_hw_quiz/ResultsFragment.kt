package com.example.skillbox_hw_quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.skillbox_hw_quiz.databinding.FragmentResultsBinding


class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root


    }

//    private val callback = object : OnBackPressedCallback(true) {
//        override fun handleOnBackPressed() {
//             findNavController().navigate(R.id.action_resultsFragment_to_helloFragment)
//        }
//    }
   


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resultText.text = arguments?.getString(FEEDBACK_KEY)
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_surveyFragment)
        }
    }
    companion object{
        const val FEEDBACK_KEY = "feedback"
    }



}