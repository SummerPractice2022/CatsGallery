package ru.teamfive.catsgallery.data.api.models

import com.google.gson.annotations.SerializedName

/**
 * Голос (когда получаем все голоса пользователя)
 * @param value 1 - лайк, 0 - дизлайк
 * @param imageId Id картинки
 * @param createdAt Когда добавили в избранное
 */
data class Vote (
    var value: Int,
    @SerializedName("image_id")
    var imageId: String,
    @SerializedName("created_at")
    var createdAt: String
)