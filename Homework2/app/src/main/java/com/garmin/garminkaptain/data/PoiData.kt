package com.garmin.garminkaptain.data

import androidx.room.*
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poi_table")
data class PointOfInterest(
    @PrimaryKey val id: Long,
    @Embedded val mapLocation: MapLocation,
    val name: String,
    val poiType: String,
    @Embedded val reviewSummary: ReviewSummary,
)

data class MapLocation(
    val latitude: Double,
    val longitude: Double
)

data class ReviewSummary(
    val averageRating: Double,
    val numberOfReviews: Int
)

@Entity
data class Review(
    @PrimaryKey val id: Long,
    val poiId: Long,
    val rating: Double,
    val title: String,
    val text: String,
    val user: String,
    val date: String
)

data class PoiWithReviews(
    @Embedded val poi :PointOfInterest,
    @Relation(parentColumn = "id",
        entityColumn = "poiId"
    )
    val reviews: List<Review>
)