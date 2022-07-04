package ru.teamfive.catsgallery.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teamfive.catsgallery.databinding.FragmentImageBinding

class ImageFragment: BaseFragment<FragmentImageBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageBinding.inflate(inflater, container, false)

        // TODO: тут картинки
        // для получения вьюшек обращаться к binding
        // у вьюшки в xml обязательно должен быть id

        return binding.root
    }
}