package ru.teamfive.catsgallery.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentBreedBinding
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi
import ru.teamfive.catsgallery.data.api.models.Breed


class BreedFragment : Fragment(R.layout.fragment_breed) {
    private var _binding: FragmentBreedBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBreedBinding.bind(view)

        val breedId = arguments?.getString("breedId", null) ?: return

        val api = CatsApi(requireContext())
        val breedsRepository = api.getBreedsRepository()
        lifecycleScope.launch {
            val breeds = breedsRepository.getAllBreeds()
            val breed = breeds.stream().filter { it.id.contentEquals(breedId) }.findFirst().get()
            setupViews(breed)
        }
    }

    private fun setupViews(breed: Breed) {
        binding.textBreedName.text = breed.name
        binding.buttonWikipedia.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(breed.wikipediaUrl))
            startActivity(intent)
        }

        if (breed.hairless == 1)
            binding.chipHairless.visibility = View.VISIBLE
        if (breed.rare == 1)
            binding.chipRare.visibility = View.VISIBLE
        if (breed.rex == 1)
            binding.chipRex.visibility = View.VISIBLE
        if (breed.suppressTail == 1)
            binding.chipSuppressedTail.visibility = View.VISIBLE
        if (breed.shortLegs == 1)
            binding.chipShortLegs.visibility = View.VISIBLE
        if (breed.hypoallergenic == 1)
            binding.chipHypoallergenic.visibility = View.VISIBLE

        binding.tvTemperament.text = breed.temperament
        binding.tvLifespan.text = breed.lifeSpan
        binding.tvAltNames.text = breed.altNames
        binding.tvOrigin.text = breed.origin
        binding.tvAdaptability.text = breed.adaptability.toString()
        binding.tvAffectionLevel.text = breed.affectionLevel.toString()
        binding.tvChildFriendly.text = breed.childFriendly.toString()
        binding.tvDogFriendly.text = breed.dogFriendly.toString()
        binding.tvEnergyLevel.text = breed.energyLevel.toString()
        binding.tvGrooming.text = breed.grooming.toString()
        binding.tvHealthIssues.text = breed.healthIssues.toString()
        binding.tvIntelligence.text = breed.intelligence.toString()
        binding.tvSheddingLevel.text = breed.sheddingLevel.toString()
        binding.tvSocialNeeds.text = breed.socialNeeds.toString()
        binding.tvStrangerFriendly.text = breed.strangerFriendly.toString()
        binding.tvVocalisation.text = breed.vocalisation.toString()

        binding.progressAboutBreed.visibility = View.GONE
        binding.scrollviewAboutBreed.visibility = View.VISIBLE
        binding.buttonWikipedia.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}