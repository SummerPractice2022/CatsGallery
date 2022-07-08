package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentFavoritesBinding
import com.teamfive.catsgallery.databinding.FragmentMainBinding
import ru.teamfive.catsgallery.ui.fragments.recycler.breed.BreedAdapter
import ru.teamfive.catsgallery.ui.fragments.recycler.breed.BreedRepository

class MainFragment: Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var adapter: BreedAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        adapter = BreedAdapter(BreedRepository.breed_name)

        binding.recyclerViewMain.adapter=adapter


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}