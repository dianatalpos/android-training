package com.garmin.garminkaptain.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.garmin.garminkaptain.R
import com.garmin.garminkaptain.data.PoiWithMapLocationAndReviewSummary
import com.garmin.garminkaptain.data.PointOfInterest
import com.garmin.garminkaptain.databinding.PoiListFragmentBinding
import com.garmin.garminkaptain.databinding.PoiListItemBinding
import com.garmin.garminkaptain.viewModel.PoiViewModel
import kotlin.math.roundToInt

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
                holder.bind(it.poi)
            }
        }

        override fun getItemCount(): Int = pointsOfInterest.size
    }

    private lateinit var binding: PoiListFragmentBinding

    private var pointsOfInterest = listOf<PoiWithMapLocationAndReviewSummary>()
    private var adapter = PoiListAdapter()
    private val viewModel: PoiViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = PoiListFragmentBinding.bind(view)

        val myHelper = ItemTouchHelper(deleteSwipeCallback)

        binding.poiList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = this@PoiListFragment.adapter
            myHelper.attachToRecyclerView(this)
        }

        val swipeRefreshLayout = binding.swipeToRefresh
        swipeRefreshLayout.setOnRefreshListener { viewModel.loadPoiList() }


        viewModel.getLoading()
            .observe(viewLifecycleOwner, Observer { swipeRefreshLayout.isRefreshing = it })

        viewModel.getPoiList().observe(viewLifecycleOwner, Observer {
            it?.let {
                pointsOfInterest = it
                adapter.notifyDataSetChanged()
            }
        })
    }

    val deleteSwipeCallback = object: ItemTouchHelper.SimpleCallback(0,
        ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = false

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder,
                              direction: Int) {

            val poiId = pointsOfInterest[viewHolder.adapterPosition].poi.id
            viewModel.deletePoi(poiId)
            adapter.notifyItemRemoved(viewHolder.adapterPosition)
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            val trashBinIcon = resources.getDrawable(
                R.drawable.ic_delete,
                null
            )

            c.clipRect(0f, viewHolder.itemView.top.toFloat(),
                dX, viewHolder.itemView.bottom.toFloat())

            c.drawColor(Color.RED)

            val textMargin = resources.getDimension(R.dimen.spacing_normal)
                .roundToInt()

            trashBinIcon.bounds = Rect(
                textMargin,
                viewHolder.itemView.top + textMargin,
                textMargin + trashBinIcon.intrinsicWidth,
                viewHolder.itemView.top + trashBinIcon.intrinsicHeight
                        + textMargin
            )
            trashBinIcon.draw(c)

            super.onChildDraw(
                c,
                recyclerView,
                viewHolder,
                dX,
                dY,
                actionState,
                isCurrentlyActive
            )
        }
    }
}