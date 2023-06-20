package com.irfan.crudapi

import com.google.gson.annotations.SerializedName

class ResultStaff {
    @field:SerializedName("Pesan")
    val pesan: String? = null

    @field:SerializedName("staff")
    val staff: List<DataItem>? = null

    @field:SerializedName("status")
    val status: Int? = null
}