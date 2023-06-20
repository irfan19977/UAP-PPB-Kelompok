package com.irfan.crudapi

import com.google.gson.annotations.SerializedName

class DataItem : java.io.Serializable {
    @field:SerializedName("staff_name")
    val staffName: String? = null

    @field:SerializedName("staff_id")
    val staffId: String? = null

    @field:SerializedName("staff_hp")
    val staffPhone: String? = null

    @field:SerializedName("staff_alamat")
    val staffAlamat: String? = null

    @field:SerializedName("staff_namdos")
    val staffNamdos: String? = null
}