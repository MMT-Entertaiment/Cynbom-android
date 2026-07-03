package net.mmt_entertaiment.cynbom.data.repository

import com.mmt.cynbom.data.api.RetrofitClient
import com.mmt.cynbom.data.model.Episode
import com.mmt.cynbom.data.model.Serie

class SerieRepository {

    private val api = RetrofitClient.cynbomApi

    suspend fun getSeries(): List<Serie> {
        return api.getSeries()
    }

    suspend fun getEpisodes(titre: String): List<Episode> {
        return api.getEpisodes(titre)
    }
}
