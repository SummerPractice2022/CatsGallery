package ru.teamfive.catsgallery.data.api.models

import com.google.gson.annotations.SerializedName

/**
 * Порода
 * @param name Имя
 * @param wikipediaUrl Ссылка на википедию
 * @param origin Страна происхождения
 */
data class Breed(
    var id: String,
    var name: String,
    @SerializedName("wikipedia_url")
    var wikipediaUrl: String,
    var origin: String
)