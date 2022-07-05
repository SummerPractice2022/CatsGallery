package ru.teamfive.catsgallery.data.api.models

import com.google.gson.annotations.SerializedName

/**
 * Порода
 * @param name Имя
 * @param temperament Темперамент
 * @param lifeSpan Срок жизни
 * @param wikipediaUrl Ссылка на википедию
 * @param altNames Другие названия
 * @param origin Страна происхождения
 * @param hairless Без шерсти
 * @param rare Редкая
 * @param rex Мутация Рекса
 * @param suppressTail Бесхвостная
 * @param shortLegs Короткие лапы
 * @param hypoallergenic Гипоаллергенная
 * @param adaptability Приспособляемость
 * @param affectionLevel Привязанность
 * @param childFriendly Дружелюбность к детям
 * @param dogFriendly Дружелюбность к собакам
 * @param energyLevel Энергичность
 * @param grooming Требует ухода
 * @param healthIssues Проблемы со здоровьем
 * @param intelligence Интеллект
 * @param sheddingLevel Уровень линьки
 * @param socialNeeds Социальные потребности
 * @param strangerFriendly Дружелюбность к незнакомцам
 * @param vocalisation Вокализация (мяукание)
 */
data class Breed(
    var id: String,
    var name: String,
    var temperament: String,
    @SerializedName("life_span")
    var lifeSpan: String,
    @SerializedName("wikipedia_url")
    var wikipediaUrl: String,
    @SerializedName("alt_names")
    var altNames: String,
    var origin: String,
    var hairless: Int,
    var rare: Int,
    var rex: Int,
    @SerializedName("suppress_tail")
    var suppressTail: Int,
    @SerializedName("short_legs")
    var shortLegs: Int,
    var hypoallergenic: Int,
    var adaptability: Int,
    @SerializedName("affection_level")
    var affectionLevel: Int,
    @SerializedName("child_friendly")
    var childFriendly: Int,
    @SerializedName("dog_friendly")
    var dogFriendly: Int,
    @SerializedName("energy_level")
    var energyLevel: Int,
    var grooming: Int,
    @SerializedName("health_issues")
    var healthIssues: Int,
    var intelligence: Int,
    @SerializedName("shedding_level")
    var sheddingLevel: Int,
    @SerializedName("social_needs")
    var socialNeeds: Int,
    @SerializedName("stranger_friendly")
    var strangerFriendly: Int,
    var vocalisation: Int
)