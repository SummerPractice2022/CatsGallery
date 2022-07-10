package ru.teamfive.catsgallery.ui.fragments.recycler.breed2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.databinding.ItemBreedBinding

class TemaAdapter(
    private val list:List<Tema>
) : RecyclerView.Adapter<TemaHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemaHolder= TemaHolder(
        ItemBreedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TemaHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int=list.size

}