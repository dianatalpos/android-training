package com.garmin.garminkaptain.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.garmin.garminkaptain.data.PointOfInterest
import com.garmin.garminkaptain.model.PoiRepository
import com.garmin.garminkaptain.TAG
import com.garmin.garminkaptain.data.Review
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class PoiViewModel(application: Application) : AndroidViewModel(application) {

    init{
        val scope = CoroutineScope(Job() + Dispatchers.Default)

        scope.launch {
            while (true) {
                delay(5000)
                Log.d(TAG, "Load data")
                loadPoiList()
            }
        }
    }
    private val poiListLiveData: MutableLiveData<List<PointOfInterest>> by lazy {
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

    fun getPoi(id: Long): LiveData<PointOfInterest?> = liveData {
        loadingLiveData.postValue(true)
        PoiRepository.getPoi(getApplication(), id).collect {
            emit(it)
            loadingLiveData.postValue(false)
        }

    }

    fun getLoading(): LiveData<Boolean> = loadingLiveData

    fun loadPoiList() {
        loadingLiveData.postValue(true)
        viewModelScope.launch {
            PoiRepository.getPoiList(getApplication()).collect {
                poiListLiveData.postValue(it)
                loadingLiveData.postValue(false)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared() called")
    }
}