package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentFavoritesBinding
import ru.teamfive.catsgallery.ui.fragments.recycler.imagefav.ImageFavAdapter
import ru.teamfive.catsgallery.ui.fragments.recycler.imagefav.ImageFavRepository

class FavoritesFragment: Fragment(R.layout.fragment_favorites) {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private var adapter: ImageFavAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavoritesBinding.bind(view)

        adapter = ImageFavAdapter(ImageFavRepository.numFav)

        binding.recyclerViewImageFav.adapter = adapter
    }
}