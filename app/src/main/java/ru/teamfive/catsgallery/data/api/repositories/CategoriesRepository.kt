package ru.teamfive.catsgallery.data.api.repositories

import retrofit2.http.GET
import ru.teamfive.catsgallery.data.api.models.Category

/**
 * Категории
 */
interface CategoriesRepository {

    /**
     * Метод получает список всех категорий
     */
    @GET("/v1/categories")
    suspend fun getAllCategories(): List<Category>
}