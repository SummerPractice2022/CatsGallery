package ru.teamfive.catsgallery.data.api.utils

import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

class VotesUtils {

    companion object {
        /**
         * Метод возвращает тело запроса для createVote
         * @param imageId - id картинки
         */
        fun createCreateVoteBody(imageId: String): RequestBody =
            RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                JSONObject("{\"image_id\": \"$imageId\", \"value\": 1}").toString()
            )
    }
}