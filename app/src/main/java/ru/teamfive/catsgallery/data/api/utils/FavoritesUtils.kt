package ru.teamfive.catsgallery.data.api.utils

import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

class FavoritesUtils {

    companion object {
        /**
         * Метод возвращает тело запроса для saveFavorite
         * @param imageId - id картинки
         */
        fun createSaveFavoriteBody(imageId: String): RequestBody =
            RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                JSONObject("{\"image_id\": \"$imageId\"}").toString()
            )
    }
}