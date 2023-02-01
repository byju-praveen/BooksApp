package com.example.booksapp.model

import android.os.Parcelable
import com.example.booksapp.model.ImageLinks
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VolumeInfo (

  @SerializedName("title"               ) var title               : String?                        = null,
  @SerializedName("authors"             ) var authors             : ArrayList<String> ?            = arrayListOf(),
  @SerializedName("publisher"           ) var publisher           : String?                        = null,
  @SerializedName("publishedDate"       ) var publishedDate       : String?                        = null,
  @SerializedName("description"         ) var description         : String?                        = null,
  @SerializedName("pageCount"           ) var pageCount           : Int?                           = null,
  @SerializedName("printType"           ) var printType           : String?                        = null,
  @SerializedName("categories"          ) var categories          : ArrayList<String>              = arrayListOf(),
  @SerializedName("maturityRating"      ) var maturityRating      : String?                        = null,
  @SerializedName("allowAnonLogging"    ) var allowAnonLogging    : Boolean?                       = null,
  @SerializedName("contentVersion"      ) var contentVersion      : String?                        = null,
  @SerializedName("imageLinks"          ) var imageLinks          : ImageLinks?                    = ImageLinks(),
  @SerializedName("language"            ) var language            : String?                        = null,
  @SerializedName("previewLink"         ) var previewLink         : String?                        = null,
  @SerializedName("infoLink"            ) var infoLink            : String?                        = null,
  @SerializedName("canonicalVolumeLink" ) var canonicalVolumeLink : String?                        = null

) : Parcelable