package ru.teamfive.catsgallery.data.api.repositories

import okhttp3.RequestBody
import retrofit2.http.*
import ru.teamfive.catsgallery.data.api.models.Favorite
import ru.teamfive.catsgallery.data.api.responses.MessageIdResponse
import ru.teamfive.catsgallery.data.api.responses.MessageResponse

/**
 * Избранное
 */
interface FavoritesRepository {

    /**
     * Метод получает картинки добавленные в избранное
     */
    @GET("/v1/favourites")
    suspend fun getAllFavorites(): List<Favorite>

    /**
     * Метод получает картинку из избранного по id
     * @param favoriteId id картинки из избранного
     */
    @GET("/v1/favourites/{favourite_id}")
    suspend fun getSpecificFavorite(@Path("favourite_id") favoriteId: String): Favorite

    /**
     * Метод удаляет картинку из избранного по id
     * @param favoriteId id картинки из избранного
     * @return Возвращает SUCCESS в случае успеха
     */
    @DELETE("/v1/favourites/{favourite_id}")
    suspend fun deleteFavorite(@Path("favourite_id") favoriteId: String): MessageResponse

    /**
     * Метод добавляет картинку в избранное
     * @param body тело запроса, получается в методе FavoritesUtils.createSaveFavoriteBody
     * @return Возвращает SUCCESS и id в избранном в случае успеха
     */
    @POST("/v1/favourites")
    suspend fun saveFavorite(@Body body: RequestBody): MessageIdResponse

}