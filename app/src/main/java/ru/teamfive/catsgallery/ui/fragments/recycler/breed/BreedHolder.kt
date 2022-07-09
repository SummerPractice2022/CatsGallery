package ru.teamfive.catsgallery.ui.fragments.recycler.breed

import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemMainBinding
import ru.teamfive.catsgallery.data.api.models.Breed

class BreedHolder(
    private val binding: ItemMainBinding
):RecyclerView.ViewHolder(binding.root) {
    fun onBind(breed: Breed){
        binding.textBreed.text = breed.name

    }
}