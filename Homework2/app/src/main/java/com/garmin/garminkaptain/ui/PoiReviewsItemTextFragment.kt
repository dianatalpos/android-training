package com.garmin.garminkaptain.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.data.poiList

class PoiReviewsItemTextFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val reviewId = args.reviewId
        val review = poiList.map { it.reviews }.flatten().find { it.id == reviewId }


        val builder = AlertDialog.Builder(activity)
            .setTitle(R.string.title_text_review)
            .setMessage(review?.text)
            .setNegativeButton(android.R.string.cancel, {d, i -> d.cancel()})

        return builder.create()
    }

    private val args: PoiReviewsItemTextFragmentArgs by navArgs()
}