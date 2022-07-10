package ru.teamfive.catsgallery.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.teamfive.catsgallery.R
import com.teamfive.catsgallery.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import ru.teamfive.catsgallery.data.api.CatsApi

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomView.setupWithNavController(controller)

        // пример работы с API
        // всё что ниже можно убрать или закомментить если что
        val api = CatsApi(applicationContext) // тут создаём API
        val breedsRepository = api.getBreedsRepository() // репозиторий с породами
        val categoriesRepository = api.getCategoriesRepository() // репозиторий с категориями
        val favoritesRepository = api.getFavoritesRepository() // репозиторий с избранным
        val imagesRepository = api.getImagesRepository() // репозиторий с картинками
        val votesRepository = api.getVotesRepository() // репозиторий с лайками


        lifecycleScope.launch {
            try {
                val faves = favoritesRepository.getAllFavorites()
                Log.d("Faves", faves.toString())
            } catch (e: Exception) {
                Log.e("Error", e.stackTraceToString())
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(applicationContext)
        val theme = sharedPreferences.getString("theme", "") ?: return
        setTheme(theme)
    }

    companion object { // Штука для смены темы
        fun setTheme(theme: String) {
            when (theme) {
                "light" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                "dark" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                else -> AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                )
            }
        }
    }
}