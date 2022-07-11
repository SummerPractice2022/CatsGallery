package ru.teamfive.catsgallery.ui.recycler.breed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.ItemMainBinding
import ru.teamfive.catsgallery.data.api.models.Breed


class BreedAdapter(
    private val list: List<Breed>,
    private val navController: NavController
) : RecyclerView.Adapter<BreedHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BreedHolder = BreedHolder(
        ItemMainBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BreedHolder, position: Int) {
        holder.textBreed.text = list[position].name

        holder.root.setOnClickListener {
            navController.navigate(
                R.id.action_mainFragment_to_imageFragment,
                bundleOf("breedId" to list[position].id)
            )
        }
    }

    override fun getItemCount(): Int = list.size

}



