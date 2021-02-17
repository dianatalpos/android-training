package com.garmin.garminkaptain.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.TAG
import com.garmin.garminkaptain.data.poiList
import com.garmin.garminkaptain.databinding.PoiReviewsItemTextFragmentBinding

class PoiReviewsItemTextFragment :  DialogFragment() {
    private val args: PoiReviewsItemTextFragmentArgs  by navArgs()
    private lateinit var binding : PoiReviewsItemTextFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: called")
        return inflater.inflate(R.layout.poi_reviews_item_text_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = PoiReviewsItemTextFragmentBinding.bind(view)
        val reviewId = args.reviewId
        val review = poiList.map { it.reviews}.flatten().find { it.id==reviewId }

        review?.let{
            binding.reviewItemFullText.text = review?.text
            binding.reviewItemTextClose.setOnClickListener{
                findNavController().navigateUp()
            }
        }
    }
}