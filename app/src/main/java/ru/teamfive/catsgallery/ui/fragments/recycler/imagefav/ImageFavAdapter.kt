package ru.teamfive.catsgallery.ui.fragments.recycler.imagefav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teamfive.catsgallery.databinding.ItemFavoritesBinding
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi
import ru.teamfive.catsgallery.data.api.models.Favorite

class ImageFavAdapter(
    private val list: MutableList<Favorite>,
    private val activity: AppCompatActivity,
) : RecyclerView.Adapter<ImageFavHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ImageFavHolder = ImageFavHolder(
        ItemFavoritesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
    )

    override fun onBindViewHolder(holder: ImageFavHolder, position: Int) {
        val api = CatsApi(activity.applicationContext)
        val imagesRepository = api.getImagesRepository()
        val favoritesRepository = api.getFavoritesRepository()
        activity.lifecycleScope.launch {
            val image = imagesRepository.getImageById(list[position].imageId)
            Glide.with(activity.applicationContext).load(image.url).into(holder.imageFavorite)
        }
        holder.btnDeleteFavorite.setOnClickListener {
            activity.lifecycleScope.launch {
                val faves = favoritesRepository.deleteFavorite(list[position].id)
                list.remove(list[position])
                notifyItemRemoved(position)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}