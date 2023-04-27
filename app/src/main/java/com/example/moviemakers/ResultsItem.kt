package com.example.moviemakers

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class ResultsItem(@Json(name = "overview")
                       val overview: String = "",
                       @Json(name = "original_language")
                       val originalLanguage: String = "",
                       @Json(name = "original_title")
                       val originalTitle: String = "",
                       @Json(name = "video")
                       val video: Boolean = false,
                       @Json(name = "title")
                       val title: String = "",
                       @Json(name = "genre_ids")
                       val genreIds: List<Int>?,
                       @Json(name = "poster_path")
                       val posterPath: String = "",
                       @Json(name = "backdrop_path")
                       val backdropPath: String = "",
                       @Json(name = "release_date")
                       val releaseDate: String = "",
                       @Json(name = "popularity")
                       val popularity: Double = 0.0,
                       @Json(name = "vote_average")
                       val voteAverage: Double = 0.0,
                       @Json(name = "id")
                       val id: Int = 0,
                       @Json(name = "adult")
                       val adult: Boolean = false,
                       @Json(name = "vote_count")
                       val voteCount: Int = 0) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: "",
        parcel.createIntArray()?.toList(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(overview)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeString(title)
        parcel.writeIntArray(genreIds?.toIntArray())
        parcel.writeString(posterPath)
        parcel.writeString(backdropPath)
        parcel.writeString(releaseDate)
        parcel.writeDouble(popularity)
        parcel.writeDouble(voteAverage)
        parcel.writeInt(id)
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeInt(voteCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultsItem> {
        override fun createFromParcel(parcel: Parcel): ResultsItem {
            return ResultsItem(parcel)
        }

        override fun newArray(size: Int): Array<ResultsItem?> {
            return arrayOfNulls(size)
        }
    }
}






