package com.garmin.garminkaptain.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.TAG
import androidx.navigation.fragment.navArgs
import com.garmin.garminkaptain.data.poiList
import com.garmin.garminkaptain.databinding.PoiDetailsFragment2Binding
import com.garmin.garminkaptain.viewModel.PoiViewModel

class PoiDetailsFragment : Fragment() {

    private val args: PoiDetailsFragmentArgs by navArgs()
    private lateinit var binding: PoiDetailsFragment2Binding
    private val viewModel: PoiViewModel by viewModels()

    private lateinit var progressBar: ProgressBar
    private lateinit var group: Group
    private lateinit var nameTextView: TextView
    private lateinit var typeTextView: TextView
    private lateinit var ratingTextView: RatingBar
    private lateinit var numReviewsTextView: TextView
    private lateinit var reviewsButton: Button

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

        view.apply {
            nameTextView =  binding.poiNameView
            typeTextView = binding.poiTypeView
            ratingTextView = binding.poiRatingView
            numReviewsTextView = binding.poiNumReviewsView
            reviewsButton = binding.poiViewReviewsButton
            progressBar = binding.poiProgress
            group = binding.poiDetailsGroup
        }

        Log.d(TAG, "onViewCreated: called")
        val poiId = args.poiId
        val poi = poiList.find { it.id == poiId }

        viewModel.getLoading().observe(
            viewLifecycleOwner,
            Observer {
                progressBar.visibility = if (it) VISIBLE else GONE
            })

        viewModel.getPoi(args.poiId).observe(viewLifecycleOwner, Observer { poi ->
            poi?.let {
                group.visibility = VISIBLE
                nameTextView.text = poi.name
                typeTextView.text = poi.poiType
                ratingTextView.rating =  poi.reviewSummary.averageRating.toFloat()
                numReviewsTextView.text =  getString(R.string.label_rating, poi.reviewSummary.averageRating)
                reviewsButton.isEnabled =poi.reviewSummary.numberOfReviews > 0
                reviewsButton.setOnClickListener {
                    findNavController().navigate(
                        PoiDetailsFragmentDirections.actionPoiDetailsFragmentToPoiReviewsFragment(poi.id)
                    )
                }
            }
        })
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