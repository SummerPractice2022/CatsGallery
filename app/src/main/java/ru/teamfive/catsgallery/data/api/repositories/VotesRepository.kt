package ru.teamfive.catsgallery.data.api.repositories

import okhttp3.RequestBody
import retrofit2.http.*
import ru.teamfive.catsgallery.data.api.models.Vote
import ru.teamfive.catsgallery.data.api.responses.MessageIdResponse
import ru.teamfive.catsgallery.data.api.responses.MessageResponse

/**
 * Лайки
 */
interface VotesRepository {

    /**
     * Метод получает лайки пользователя
     */
    @GET("/v1/votes")
    suspend fun getVotes(): List<Vote>

    /**
     * Метод получает лайки пользователя
     * @param body тело запроса, получается в методе VotesUtils.createCreateVoteBody
     * @return Возвращает SUCCESS и id лайка в случае успеха
     */
    @POST("/v1/votes")
    suspend fun createVote(@Body body: RequestBody): MessageIdResponse

    /**
     * Метод удаляет картинку из избранного по id
     * @param voteId id лайка
     * @return Возвращает SUCCESS в случае успеха
     */
    @DELETE("/v1/votes/{vote_id}")
    suspend fun deleteVote(@Path("vote_id") voteId: String): MessageResponse
}