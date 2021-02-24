package com.garmin.garminkaptain.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.garmin.garminkaptain.data.PointOfInterest
import com.garmin.garminkaptain.model.PoiRepository
import com.garmin.garminkaptain.TAG
import com.garmin.garminkaptain.data.Review

class PoiViewModel : ViewModel() {
    init {
        Log.d(TAG, "init called")
    }

    private val poiListLiveData: MutableLiveData<List<PointOfInterest>> by lazy{
        MutableLiveData<List<PointOfInterest>>()
    }

    private val poiLiveData: MutableLiveData<PointOfInterest> by lazy {
        MutableLiveData<PointOfInterest>()
    }

    private val poiReviewsLiveData: MutableLiveData<List<Review>> by lazy {
        MutableLiveData<List<Review>>()
    }

    fun getPoi(id: Long): LiveData<PointOfInterest> {
        loadPoi(id)
        return poiLiveData
    }

    fun getPoiList(): LiveData<List<PointOfInterest>> {
        loadPoiList()
        return poiListLiveData
    }

    fun getReviewsList(poiId: Long): LiveData<List<Review>> {
        loadPoiReviews(poiId)
        return poiReviewsLiveData
    }

    private fun loadPoiReviews(poiId: Long) {
        poiReviewsLiveData.postValue(PoiRepository.getPoiReviews(poiId))
    }

    private fun loadPoiList() {
        poiListLiveData.postValue(PoiRepository.getPoiList())
    }

    private fun loadPoi(id: Long) {
        poiLiveData.postValue(PoiRepository.getPoi(id))
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")
    }
}