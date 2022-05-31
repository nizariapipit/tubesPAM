package tugas.besar.tubespam.retrofit

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponsePexels(
    @field:SerializedName("total_results")
    val totalResult: Int,

    @field:SerializedName("photos")
    val photos: List<Photos>
): Parcelable

@Parcelize
data class Photos(
    @field:SerializedName("url")
    val ava: String,

    @field:SerializedName("photographer")
    val fotografer: String,

    @field:SerializedName("photographer_id")
    val id_fotografer: String,

    //@field:SerializedName("src")
    //val src: List<Src>,

    @field:SerializedName("alt")
    val alt: String
):Parcelable

@Parcelize
data class Src(
    @field:SerializedName("original")
    val original: String,

    @field:SerializedName("large2x")
    val large2x:String,

    @field:SerializedName("large")
    val large:String,

    @field:SerializedName("medium")
    val medium:String,

    @field:SerializedName("portrait")
    val portrait: String,

    @field:SerializedName("landscape")
    val landscape:String,

    @field:SerializedName("tiny")
    val tiny:String
): Parcelable

@Parcelize
data class Hasil(
    @field:SerializedName("url")
    val ava: String,

    @field:SerializedName("alt")
    val alt: String
):Parcelable

@Parcelize
data class Detail(
    @field:SerializedName("url")
    val ava: String,

    @field:SerializedName("photographer")
    val fotografer: String,

    @field:SerializedName("photographer_id")
    val id_fotografer: String,

   //@field:SerializedName("src")
    //val src: List<Src>,

    @field:SerializedName("alt")
    val alt: String
):Parcelable