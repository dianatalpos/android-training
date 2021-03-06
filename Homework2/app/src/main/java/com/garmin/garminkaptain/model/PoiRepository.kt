package com.garmin.garminkaptain.model

import android.app.Application
import com.garmin.garminkaptain.KaptainApplication
import com.garmin.garminkaptain.data.PoiDao
import com.garmin.garminkaptain.data.PoiDatabase
import com.garmin.garminkaptain.data.PoiWithMapLocationAndReviewSummary
import kotlinx.coroutines.flow.Flow

class PoiRepository(application: Application) {

    val dao : PoiDao

    init{
        dao = PoiDatabase.getInstance(application).getPoiDao()
    }

    fun getPoiList(application: KaptainApplication): Flow<List<PoiWithMapLocationAndReviewSummary>> =
        dao.getAllPoiWithReviewSummaryAndMapLocation()


    fun getPoi(application: KaptainApplication, id: Long): Flow<PoiWithMapLocationAndReviewSummary> =
        dao.getPoiWithReviewSummaryAndMapLocation(id)

    suspend fun getReviews(application: KaptainApplication, id: Long) =
        dao.getPoiWithReviews(id).reviews

    suspend fun deletePoi(id:Long) {
        dao.deletePoiById(id)
    }
}