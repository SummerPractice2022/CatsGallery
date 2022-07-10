package ru.teamfive.catsgallery.ui.fragments.recycler.imagefav

import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemFavoritesBinding

class ImageFavHolders(
    binding: ItemFavoritesBinding
) : RecyclerView.ViewHolder(binding.root) {
    val imageFavorite = binding.imageViewFavorite
    val btnDeleteFavorite = binding.btnDeleteFav

}