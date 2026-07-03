package net.mmt_entertaiment.cynbom.data.model

import com.google.gson.annotations.SerializedName

data class Serie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("titre")
    val titre: String,
    @SerializedName("studio")
    val studio: String?,
    @SerializedName("annee")
    val annee: Int?,
    @SerializedName("age")
    val age: String?,
    @SerializedName("genre")
    val genre: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("vedette")
    val vedette: Int = 0
)

data class Episode(
    @SerializedName("id")
    val id: Int,
    @SerializedName("serie_id")
    val serieId: Int,
    @SerializedName("saison")
    val saison: String,
    @SerializedName("numero")
    val numero: Int,
    @SerializedName("titre")
    val titre: String?,
    @SerializedName("video")
    val video: String?
)
