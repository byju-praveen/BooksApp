package com.example.booksapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Items (

  @SerializedName("kind"       ) var kind       : String?     = null,
  @SerializedName("id"         ) var id         : String?     = null,
  @SerializedName("etag"       ) var etag       : String?     = null,
  @SerializedName("selfLink"   ) var selfLink   : String?     = null,
  @SerializedName("volumeInfo" ) var volumeInfo : VolumeInfo? = VolumeInfo(),

) : Parcelable