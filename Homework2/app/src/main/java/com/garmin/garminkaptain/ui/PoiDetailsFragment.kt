package com.garmin.garminkaptain.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.TAG
import androidx.navigation.fragment.navArgs
import com.garmin.garminkaptain.data.poiList
import com.garmin.garminkaptain.databinding.PoiDetailsFragment2Binding
import com.garmin.garminkaptain.databinding.PoiReviewsFragmentBinding

class PoiDetailsFragment : Fragment() {

    private val args: PoiDetailsFragmentArgs by navArgs()
    private lateinit var binding: PoiDetailsFragment2Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: called")
        return inflater.inflate(R.layout.poi_details_fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = PoiDetailsFragment2Binding.bind(view)

        Log.d(TAG, "onViewCreated: called")
        val poiId = args.poiId
        val poi = poiList.find { it.id == poiId }
        poi?.let {
            view.apply {
                binding.poiNameView.text = poi.name
                binding.poiTypeView.text = poi.poiType
                binding.poiRatingView.rating =
                    poi.reviewSummary.averageRating.toFloat()
                binding.poiNumReviewsView.text =
                    getString(R.string.label_num_reviews, poi.reviewSummary.numberOfReviews)
                binding.poiViewReviewsButton.isEnabled =
                    poi.reviewSummary.numberOfReviews > 0

                binding.poiViewReviewsButton.setOnClickListener {
                    findNavController().navigate(
                        PoiDetailsFragmentDirections.actionPoiDetailsFragmentToPoiReviewsFragment(poi.id)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach() called")
    }
}