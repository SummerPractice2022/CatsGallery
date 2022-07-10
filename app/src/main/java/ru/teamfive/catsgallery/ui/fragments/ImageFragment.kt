package ru.teamfive.catsgallery.ui.fragments

import android.app.WallpaperManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.FragmentImageBinding
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi
import ru.teamfive.catsgallery.data.api.models.Image
import ru.teamfive.catsgallery.data.api.utils.FavoritesUtils
import java.net.URL

class ImageFragment : Fragment(R.layout.fragment_image) {
    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    private lateinit var breedId: String
    private var images: List<Image>? = null
    private var index = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentImageBinding.bind(view)

        breedId = arguments?.getString("breedId") ?: return

        val context = requireContext()
        val imagesRepository = CatsApi(context).getImagesRepository()
        val favoritesRepository = CatsApi(context).getFavoritesRepository()

        binding.btnAddToFavorites.setOnClickListener {
            if (images == null || images?.size == 0)
                return@setOnClickListener

            lifecycleScope.launch {
                try {
                    favoritesRepository.saveFavorite(
                        FavoritesUtils.createSaveFavoriteBody(
                            images!![index].id
                        )
                    )

                    createToast(R.string.add_favorites_success)
                } catch (e: Exception) {
                    Log.e("Error", e.stackTraceToString())
                }
            }
        }

        binding.btnAnotherPicture.setOnClickListener {
            if (images == null || images?.size == 0)
                return@setOnClickListener

            if (index == images?.size!! - 1)
                index = 0
            else
                index++

            loadImage(images!![index].url)
        }

        binding.btnInstallOnWallpaper.setOnClickListener {
            if (images == null || images?.size == 0)
                return@setOnClickListener

            Thread {
                val wallpaperManager = WallpaperManager.getInstance(requireContext())
                wallpaperManager.setStream(
                    URL(images!![index].url).openConnection().getInputStream()
                )

                createToast(R.string.set_wp_success)
            }.start()
        }

        binding.btnAboutBreed.setOnClickListener {
            findNavController().navigate(
                R.id.action_imageFragment_to_breedFragment,
                bundleOf("breedId" to breedId)
            )
        }

        lifecycleScope.launch {
            try {
                images = imagesRepository.searchImages(
                    breedId
                )

                if (images == null || images?.size == 0)
                    return@launch

                loadImage(images!![index].url)
            } catch (e: Exception) {
                Log.e("Error", e.stackTraceToString())
            }

        }
    }

    private fun createToast(@StringRes stringId: Int) {
        val context = requireContext()

        requireActivity().runOnUiThread {
            Toast.makeText(
                context,
                context.getString(stringId),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun loadImage(imageUrl: String) =
        Glide.with(requireContext())
            .load(imageUrl)
            .into(binding.imageView)

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}