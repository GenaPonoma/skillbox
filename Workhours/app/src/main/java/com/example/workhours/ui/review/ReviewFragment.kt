package com.example.workhours.ui.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workhours.adapter.MainAdapter
import com.example.workhours.databinding.FragmentReviewBinding

class ReviewFragment : Fragment() {

    private var _binding: FragmentReviewBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReviewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: List<String> = (0..100).map { it.toString() }
        val myAdapter = MainAdapter(data)
        binding.resyaver.adapter = myAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}