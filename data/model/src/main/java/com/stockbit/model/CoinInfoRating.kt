package com.stockbit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jessica Setyani on 19/02/22.
 */
data class CoinInfoRating(
    @SerializedName("Weiss")
    var weiss: WeissRating? = null
)

