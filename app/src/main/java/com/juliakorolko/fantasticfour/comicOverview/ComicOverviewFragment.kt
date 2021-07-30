package com.juliakorolko.fantasticfour.comicOverview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.juliakorolko.fantasticfour.databinding.FragmentComicOverviewBinding

class ComicOverviewFragment : Fragment() {
    private val viewModel: ComicOverviewViewModel by lazy {
        ViewModelProvider(this).get(ComicOverviewViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentComicOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}