package com.example.myapplication3

import android.content.Context
import android.os.Bundle
import android.text.style.TtsSpan.ARG_TEXT
import android.view.View
import androidx.fragment.app.Fragment
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.ActivityMainBinding
import com.teamfive.catsgallery.databinding.FragmentBreedBinding
import ru.teamfive.catsgallery.ui.fragments.recycler.breed2.TemaAdapter
import ru.teamfive.catsgallery.ui.fragments.recycler.breed2.TemaRep

class BreedFragment:Fragment(R .layout.fragment_breed) {
    private var _binding: FragmentBreedBinding? = null
    private val binding get() = _binding!!

    private var adapter: TemaAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding =  FragmentBreedBinding.bind(view)

        val text = arguments?.getString(ARG_TEXT).orEmpty()

        adapter = TemaAdapter(TemaRep.breed)
        binding.rvBreed.adapter = adapter
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding=null
    }


}