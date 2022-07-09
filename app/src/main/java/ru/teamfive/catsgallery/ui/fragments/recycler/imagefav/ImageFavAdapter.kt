package ru.teamfive.catsgallery.ui.fragments.recycler.imagefav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemFavoritesBinding

class ImageFavAdapter(
    private val list: List<ImageFav>
): RecyclerView.Adapter<ImageFavHolders>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ImageFavHolders = ImageFavHolders(
        ItemFavoritesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
    )

    override fun onBindViewHolder(holder: ImageFavHolders, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}