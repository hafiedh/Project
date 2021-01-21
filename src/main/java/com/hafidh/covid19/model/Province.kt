package com.hafidh.covid19.model

import com.google.gson.annotations.SerializedName

data class Province (
    @SerializedName("Kode_Provi")
    val Code: Int ,
    @SerializedName("Provinsi")
    val Province : String ,
    @SerializedName("Kasus_Posi")
    val Positive : Int ,
    @SerializedName("Kasus_Semb")
    val Recovery : Int ,
    @SerializedName("Kasus_Meni")
    val Death : Int ,

)
