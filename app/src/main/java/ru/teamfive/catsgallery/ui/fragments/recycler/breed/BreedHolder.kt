package ru.teamfive.catsgallery.ui.fragments.recycler.breed

import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemMainBinding

class BreedHolder(
    private val binding: ItemMainBinding
):RecyclerView.ViewHolder(binding.root) {
    fun onBind(breedrec: Breedrec){
        binding.textBreed.text = breedrec.name
    }
}