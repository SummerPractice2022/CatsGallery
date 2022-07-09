package ru.teamfive.catsgallery.ui.fragments.recycler.breed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemMainBinding
import ru.teamfive.catsgallery.data.api.models.Breed


class BreedAdapter(
    private val list: List<Breed>
): RecyclerView.Adapter<BreedHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): BreedHolder = BreedHolder(
        ItemMainBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )
    override fun onBindViewHolder(holder: BreedHolder, position: Int) {
        holder.onBind(list[position])


    }

    override fun getItemCount(): Int = list.size


}



