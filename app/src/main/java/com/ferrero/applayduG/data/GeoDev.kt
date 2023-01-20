package com.ferrero.applayduG.data
import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class GeoDev(
    @SerialName("geo")
    val geo: String,
    @SerialName("view")
    val view: String,
    @SerialName("appsChecker")
    val appsChecker: String,
)
