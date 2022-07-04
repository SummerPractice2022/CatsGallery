package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamfive.catsgallery.databinding.FragmentFavoritesBinding

class FavoritesFragment: BaseFragment<FragmentFavoritesBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        // TODO: тут избранное
        // для получения вьюшек обращаться к binding
        // у вьюшки в xml обязательно должен быть id

        return binding.root
    }
}