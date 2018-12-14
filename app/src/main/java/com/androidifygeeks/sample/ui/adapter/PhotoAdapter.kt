package com.androidifygeeks.sample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.androidifygeeks.sample.R
import com.androidifygeeks.sample.util.extension.inflate
import com.androidifygeeks.sample.util.extension.loadFromUrl
import com.androidifygeeks.sample.viewmodel.data.PhotoView
import kotlinx.android.synthetic.main.photo_list_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class PhotoAdapter
@Inject constructor() : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    internal var collection: List<PhotoView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.photo_list_item))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photoView: PhotoView) {
            itemView.item_img.loadFromUrl(photoView.thumbnailUrl)
        }
    }
}
