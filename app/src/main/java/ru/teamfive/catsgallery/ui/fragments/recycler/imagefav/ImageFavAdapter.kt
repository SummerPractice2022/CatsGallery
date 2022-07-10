package ru.teamfive.catsgallery.ui.fragments.recycler.imagefav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemFavoritesBinding
import ru.teamfive.catsgallery.data.api.models.Favorite

class ImageFavAdapter(
    private val list: List<Favorite>,
) : RecyclerView.Adapter<ImageFavHolders>() {
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


    }

    override fun getItemCount(): Int = list.size
}