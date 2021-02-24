package com.garmin.garminkaptain.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.data.PointOfInterest
import com.garmin.garminkaptain.databinding.PoiListFragmentBinding
import com.garmin.garminkaptain.databinding.PoiListItemBinding
import com.garmin.garminkaptain.viewModel.PoiViewModel

class PoiListFragment : Fragment(R.layout.poi_list_fragment) {

    inner class PoiListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding: PoiListItemBinding = PoiListItemBinding.bind(itemView)

        fun bind(poi: PointOfInterest) {
            binding.poiItemNameView.text = poi.name
            binding.poiItemTypeView.text = poi.poiType
            itemView.setOnClickListener {
                findNavController().navigate(
                    PoiListFragmentDirections.actionPoiListFragmentToPoiDetailsFragment(poi.id)
                )
            }
        }
    }

    inner class PoiListAdapter : RecyclerView.Adapter<PoiListItemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiListItemViewHolder {
            return PoiListItemViewHolder(
                layoutInflater.inflate(R.layout.poi_list_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: PoiListItemViewHolder, position: Int) {
            pointsOfInterest.getOrNull(position)?.let {
                holder.bind(it)
            }
        }

        override fun getItemCount(): Int = pointsOfInterest.size
    }

    private lateinit var binding: PoiListFragmentBinding

    private var pointsOfInterest = listOf<PointOfInterest>()
    private var adapter = PoiListAdapter()
    private val viewModel: PoiViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = PoiListFragmentBinding.bind(view)

        binding.poiList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = this@PoiListFragment.adapter
        }

        viewModel.getPoiList().observe(viewLifecycleOwner, Observer {
            it?.let {
                pointsOfInterest = it
                adapter.notifyDataSetChanged()
            }
        })
    }

}