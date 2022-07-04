package ru.teamfive.catsgallery.data.api.repositories

import retrofit2.http.GET
import ru.teamfive.catsgallery.data.api.models.Breed

/**
 * Породы
 */
interface BreedsRepository {

    /**
     * Метод получает список всех пород
     */
    @GET("/v1/breeds")
    suspend fun getAllBreeds(): List<Breed>
}