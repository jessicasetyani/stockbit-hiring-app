package com.stockbit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Jessica Setyani on 19/02/22.
 */

data class CoinInfo(
    @SerializedName("Id")
    var id: String? = null,
    @SerializedName("Name")
    var name: String? = null,
    @SerializedName("FullName")
    var fullName: String? = null,
    @SerializedName("ImageUrl")
    var imageUrl: String? = null,
    @SerializedName("Rating")
    var coinInfoRating: CoinInfoRating? = null
)

