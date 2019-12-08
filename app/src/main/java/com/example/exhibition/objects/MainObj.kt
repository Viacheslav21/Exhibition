package com.example.exhibition.objects


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainObj(
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("itemId")
    val itemId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("time")
    val time: Long
): Parcelable
