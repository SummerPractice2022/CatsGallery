package ru.teamfive.catsgallery.ui.fragments.recycler.breed2

import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemBreedBinding

class TemaHolder(
    private val binding: ItemBreedBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(tema:Tema){
        with(binding){
            tvName.text=tema.name
            tvDescription.text=tema.description

        }
    }
}