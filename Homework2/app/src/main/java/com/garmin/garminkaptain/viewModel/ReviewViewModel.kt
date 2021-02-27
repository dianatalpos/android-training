package com.garmin.garminkaptain.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.garmin.garminkaptain.data.Review
import com.garmin.garminkaptain.model.PoiRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ReviewViewModel(application: Application) : AndroidViewModel(application) {

    private val poiRepository: PoiRepository = PoiRepository(application)

    private val _reviewsLiveData: MutableLiveData<List<Review>> = MutableLiveData()
    private val _reviewLiveData: MutableLiveData<Review> = MutableLiveData()

    val reviewLiveData: LiveData<List<Review>>
        get() = _reviewsLiveData

    val aReviewLiveData: LiveData<Review>
        get() = _reviewLiveData

    fun getReviews(id: Long) = viewModelScope.launch {
        _reviewsLiveData.postValue(poiRepository.getReviews(getApplication(), id))
    }

    fun getReview(poiId: Long, reviewId: Long) = viewModelScope.launch {
        _reviewLiveData.postValue(
            poiRepository.getReviews(getApplication(), poiId).find { it.id == reviewId })
    }
}