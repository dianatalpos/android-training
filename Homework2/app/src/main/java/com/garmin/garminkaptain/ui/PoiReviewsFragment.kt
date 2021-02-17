package com.garmin.garminkaptain.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.convertToString
import com.garmin.garminkaptain.data.PointOfInterest
import com.garmin.garminkaptain.data.Review
import com.garmin.garminkaptain.data.poiList
import com.garmin.garminkaptain.databinding.PoiReviewsFragmentBinding
import com.garmin.garminkaptain.databinding.PoiReviewsItemBinding

class PoiReviewsFragment : Fragment(R.layout.poi_reviews_fragment) {

    inner class PoiReviewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var binding: PoiReviewsItemBinding


        fun bind(review: Review) {
            binding = PoiReviewsItemBinding.bind(itemView)

            binding.reviewsItemUserView.text = review.user
            binding.reviewsItemDateView.text = review.date.convertToString("dd/MM/yyyy")
            binding.reviewsItemTitleView.text = review.title
            binding.reviewsItemRatingView.rating = review.rating.toFloat()
            binding.reviewsItemTextView.text = review.text

            itemView.setOnClickListener{
                findNavController().navigate(PoiReviewsFragmentDirections.actionPoiReviewsFragmentToPoiReviewsItemTextFragment(review.id))
            }
        }
    }

    inner class PoiReviewsAdapter : RecyclerView.Adapter<PoiReviewsFragment.PoiReviewsItemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiReviewsFragment.PoiReviewsItemViewHolder {
            return PoiReviewsItemViewHolder(
                layoutInflater.inflate(R.layout.poi_reviews_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: PoiReviewsFragment.PoiReviewsItemViewHolder, position: Int) {
            reviews.getOrNull(position)?.let {
                holder.bind(it)
            }
        }

        override fun getItemCount(): Int = reviews.size
    }

    private val args: PoiReviewsFragmentArgs by navArgs()
    private lateinit var binding: PoiReviewsFragmentBinding
    private lateinit var reviews : List<Review>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = PoiReviewsFragmentBinding.bind(view)

        val poiId = args.poiId
        val poi = poiList.find { it.id == poiId }
        poi?.let {
            reviews = it.reviews
        }

        binding.reviewsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = PoiReviewsAdapter()
        }
    }
}