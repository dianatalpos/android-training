package com.garmin.garminkaptain.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.data.Review
import com.garmin.garminkaptain.viewModel.ReviewViewModel

class PoiReviewsItemTextFragment() : DialogFragment() {

    private val model: ReviewViewModel by viewModels()
    private var review : Review? = null

    //TODO Find a solution for this
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val reviewId = args.reviewId
        val poiId = args.poiId

        val builder = AlertDialog.Builder(activity)
            .setTitle(R.string.title_text_review)
           //.setMessage(review?.text)
            .setNegativeButton(android.R.string.cancel, { d, i -> d.cancel() })

        return builder.create()
    }

    private val args: PoiReviewsItemTextFragmentArgs by navArgs()
}