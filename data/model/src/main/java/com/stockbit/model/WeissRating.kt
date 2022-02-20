package com.stockbit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jessica Setyani on 19/02/22.
 */
data class WeissRating(
    @SerializedName("Rating")
    var rating: String? = null,
    @SerializedName("TechnologyAdoptionRating")
    var technologyAdoptionRating: String? = null,
    @SerializedName("MarketPerformanceRating")
    var marketPerformanceRating: String? = null
)

