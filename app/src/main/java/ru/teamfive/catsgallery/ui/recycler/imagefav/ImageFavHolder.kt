package ru.teamfive.catsgallery.ui.recycler.imagefav

import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemFavoritesBinding

class ImageFavHolder(
    binding: ItemFavoritesBinding
) : RecyclerView.ViewHolder(binding.root) {
    val imageFavorite = binding.imageViewFavorite
    val btnDeleteFavorite = binding.btnDeleteFav

}