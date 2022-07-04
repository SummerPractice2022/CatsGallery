package ru.teamfive.catsgallery.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.teamfive.catsgallery.R
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = CatsApi() // тут создаём API
        val breedsRepository = api.getBreedsRepository() // репозиторий с породами
        val categoriesRepository = api.getCategoriesRepository() // репозиторий с категориями
        val favoritesRepository = api.getFavoritesRepository() // репозиторий с избранным
        val imagesRepository = api.getImagesRepository() // репозиторий с картинками

        lifecycleScope.launch {
            val favs = favoritesRepository.getAllFavorites()
            Log.d("Faves", favs.toString())
        }
    }
}