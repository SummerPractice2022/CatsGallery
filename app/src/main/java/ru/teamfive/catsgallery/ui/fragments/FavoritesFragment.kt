package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentFavoritesBinding
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi
import ru.teamfive.catsgallery.ui.fragments.recycler.imagefav.ImageFavAdapter

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ImageFavAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoritesBinding.bind(view)

        val api = CatsApi(requireContext())
        val favoritesRepository = api.getFavoritesRepository()
        lifecycleScope.launch {
            val faves = favoritesRepository.getAllFavorites()

            adapter = ImageFavAdapter(faves.toMutableList(), requireActivity() as AppCompatActivity)
            binding.recyclerViewImageFav.adapter = adapter
        }
    }
}