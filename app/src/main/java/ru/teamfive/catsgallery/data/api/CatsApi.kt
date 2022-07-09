package ru.teamfive.catsgallery.data.api

import android.content.Context
import androidx.preference.PreferenceManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.teamfive.catsgallery.data.api.repositories.*

const val DEFAULT_API_KEY = "7e07d997-e3c0-4de3-8520-08c1ec669d7f"

class CatsApi(context: Context) {

    private val apiKey: String =
        PreferenceManager
            .getDefaultSharedPreferences(context)
            .getString("api-key", DEFAULT_API_KEY) ?: DEFAULT_API_KEY

    fun getBreedsRepository(): BreedsRepository =
        retrofit.create(BreedsRepository::class.java)

    fun getCategoriesRepository(): CategoriesRepository =
        retrofit.create(CategoriesRepository::class.java)

    fun getFavoritesRepository(): FavoritesRepository =
        retrofit.create(FavoritesRepository::class.java)

    fun getImagesRepository(): ImagesRepository =
        retrofit.create(ImagesRepository::class.java)

    fun getVotesRepository(): VotesRepository =
        retrofit.create(VotesRepository::class.java)

    private val retrofit = Retrofit.Builder()
        .client(
            OkHttpClient.Builder()
                .addInterceptor {
                    it.proceed(
                        it.request().newBuilder()
                            .addHeader("x-api-key", apiKey)
                            .build()
                    )
                }
                .build()
        )
        .baseUrl("https://api.thecatapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}