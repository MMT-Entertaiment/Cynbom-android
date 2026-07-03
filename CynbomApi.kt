package net.mmt_entertaiment.cynbom.data.api

import com.mmt.cynbom.data.model.Episode
import com.mmt.cynbom.data.model.Serie
import retrofit2.http.GET
import retrofit2.http.Path

interface CynbomApi {

    @GET("/series")
    suspend fun getSeries(): List<Serie>

    @GET("/series/{titre}/episodes")
    suspend fun getEpisodes(@Path("titre") titre: String): List<Episode>
}
