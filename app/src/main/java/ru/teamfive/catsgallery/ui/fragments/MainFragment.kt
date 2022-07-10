package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentMainBinding
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi
import ru.teamfive.catsgallery.ui.fragments.recycler.breed.BreedAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BreedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        val api = CatsApi(requireContext())

        val breedsRepository = api.getBreedsRepository()
        lifecycleScope.launch {
            try {
                val breeds = breedsRepository.getAllBreeds()

                adapter = BreedAdapter(breeds, findNavController())

                binding.recyclerViewMain.adapter = adapter
            } catch (e: Exception) {
                Log.d("Error", e.stackTraceToString())
            }

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}