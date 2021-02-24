package com.garmin.garminkaptain.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.convertToString
import com.garmin.garminkaptain.data.PointOfInterest
import com.garmin.garminkaptain.data.Review
import com.garmin.garminkaptain.databinding.PoiReviewsFragmentBinding
import com.garmin.garminkaptain.databinding.PoiReviewsItemBinding
import com.garmin.garminkaptain.viewModel.PoiViewModel

class PoiReviewsFragment : Fragment(R.layout.poi_reviews_fragment) {

    inner class PoiReviewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding: PoiReviewsItemBinding = PoiReviewsItemBinding.bind(itemView)


        fun bind(review: Review) {
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

    private var reviews = listOf<Review>()
    private var adapter = PoiReviewsAdapter()
    private val viewModel: PoiViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = PoiReviewsFragmentBinding.bind(view)

        val poiId = args.poiId

        binding.reviewsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = this@PoiReviewsFragment.adapter
        }

        viewModel.getReviewsList(poiId).observe(viewLifecycleOwner, Observer {
            it?.let {
                reviews = it
                adapter.notifyDataSetChanged()
            }
        })
    }
}