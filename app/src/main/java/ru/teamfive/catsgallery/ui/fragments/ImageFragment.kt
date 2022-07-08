package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentFavoritesBinding
import com.teamfive.catsgallery.databinding.FragmentImageBinding
import ru.teamfive.catsgallery.ui.fragments.recycler.imagefav.ImageFavAdapter
import ru.teamfive.catsgallery.ui.fragments.recycler.imagefav.ImageFavRepository

class ImageFragment: Fragment(R.layout.fragment_image) {
    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentImageBinding.bind(view)

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}