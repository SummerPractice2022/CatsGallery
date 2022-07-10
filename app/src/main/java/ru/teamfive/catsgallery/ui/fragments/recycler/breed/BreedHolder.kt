package ru.teamfive.catsgallery.ui.fragments.recycler.breed

import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemMainBinding

class BreedHolder(
    binding: ItemMainBinding
) : RecyclerView.ViewHolder(binding.root) {
    val root = binding.root
    val textBreed = binding.textBreed
}