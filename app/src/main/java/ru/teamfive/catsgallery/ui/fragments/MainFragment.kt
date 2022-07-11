package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentMainBinding
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi
import ru.teamfive.catsgallery.data.api.models.Breed
import ru.teamfive.catsgallery.ui.recycler.breed.BreedAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var breeds: List<Breed>

    private lateinit var adapter: BreedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        if (this::breeds.isInitialized) {
            setViews()
            return
        }

        val api = CatsApi(requireContext())
        val breedsRepository = api.getBreedsRepository()

        lifecycleScope.launch {
            try {
                breeds = breedsRepository.getAllBreeds()

                setViews()
            } catch (e: Exception) {
                Log.d("Error", e.stackTraceToString())
            }
        }
    }

    private fun setViews() {
        adapter = BreedAdapter(breeds, findNavController())
        binding.recyclerViewMain.adapter = adapter

        binding.buttonRandom.setOnClickListener {
            val randomIndex = (Math.random() * breeds.size).toInt()
            findNavController().navigate(
                R.id.action_mainFragment_to_imageFragment,
                bundleOf("breedId" to breeds[randomIndex].id)
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}