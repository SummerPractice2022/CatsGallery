package ru.teamfive.catsgallery.ui.fragments.recycler.imagefav

import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemFavoritesBinding

class ImageFavHolders(
    private val binding: ItemFavoritesBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(imagefav: ImageFav) {
        binding.textFavorites.text = imagefav.numberFav
    }
}