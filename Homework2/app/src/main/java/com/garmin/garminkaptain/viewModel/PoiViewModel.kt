package com.garmin.garminkaptain.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.garmin.garminkaptain.data.PointOfInterest
import com.garmin.garminkaptain.model.PoiRepository
import com.garmin.garminkaptain.TAG
import com.garmin.garminkaptain.data.Review
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PoiViewModel : ViewModel() {
    init {
        Log.d(TAG, "init called")
    }

    private val poiListLiveData: MutableLiveData<List<PointOfInterest>> by lazy{
        MutableLiveData<List<PointOfInterest>>()
    }

    private val loadingLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    private val poiReviewsLiveData: MutableLiveData<List<Review>> by lazy {
        MutableLiveData<List<Review>>()
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

    fun getPoi(id: Long): LiveData<PointOfInterest?> = liveData {
        loadingLiveData.postValue(true)
        PoiRepository.getPoi(id).collect {
            emit(it)
            loadingLiveData.postValue(false)
        }
    }


    fun getLoading(): LiveData<Boolean> = loadingLiveData

    fun loadPoiList() {
        viewModelScope.launch {
            while(true) {
                loadingLiveData.postValue(true)
                Log.d(TAG, "Load data")
                PoiRepository.getPoiList().collect {
                    poiListLiveData.postValue(it)
                    loadingLiveData.postValue(false)
                }
                delay(5000)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")
    }
}