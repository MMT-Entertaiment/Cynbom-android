package net.mmt_entertaiment.cynbom.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://cynbom-backend-production.up.railway.app"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val cynbomApi: CynbomApi by lazy {
        retrofit.create(CynbomApi::class.java)
    }
}
