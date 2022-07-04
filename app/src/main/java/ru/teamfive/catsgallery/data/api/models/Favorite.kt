package ru.teamfive.catsgallery.data.api.models

import com.google.gson.annotations.SerializedName

/**
 * Картинка в избранных
 * @param imageId Id картринки
 * @param createdAt Когда добавили в избранное
 */
data class Favorite (
    var id: String,
    @SerializedName("image_id")
    var imageId: String,
    @SerializedName("created_at")
    var createdAt: String
)