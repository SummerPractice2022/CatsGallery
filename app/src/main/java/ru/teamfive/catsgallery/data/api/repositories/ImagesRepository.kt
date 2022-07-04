package ru.teamfive.catsgallery.data.api.repositories

import retrofit2.http.GET
import retrofit2.http.Query
import ru.teamfive.catsgallery.data.api.models.Image

/**
 * Картинки
 */
interface ImagesRepository {

    /**
     * Метод ищет картинку по заданным параметрам
     * @param breedId id породы
     * @param limit сколько максимум картинок искать
     * @return Возвращает список из картинок
     */
    @GET("/v1/images/search")
    suspend fun searchImages(
        @Query("breed_id") breedId: String,
        @Query("category_ids") categoryIds: List<Int> = emptyList(),
        @Query("limit") limit: Int = 100,
        @Query("size") size: String = "full",
        @Query("order") order: String = "RANDOM"
    ): List<Image>
}