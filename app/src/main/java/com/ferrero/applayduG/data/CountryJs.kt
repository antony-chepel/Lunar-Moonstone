package com.ferrero.applayduG.data
import kotlinx.serialization.SerialName



@kotlinx.serialization.Serializable
data class CountryJs(
    @SerialName("city")
    val city: String,
    @SerialName("country")
    val country: String,
    @SerialName("countryCode")
    val countryCode: String,
)
