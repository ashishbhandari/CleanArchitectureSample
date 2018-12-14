package com.androidifygeeks.sample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.androidifygeeks.sample.R
import com.androidifygeeks.sample.util.extension.inflate
import com.androidifygeeks.sample.viewmodel.data.PostView
import kotlinx.android.synthetic.main.post_list_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * @author ashish on 12,December,2018
 */
class PostAdapter @Inject constructor() : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    var collection: List<PostView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    var clickListener: (PostView) -> Unit = { _ -> }


    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(collection[position], clickListener)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PostViewHolder(parent.inflate(R.layout.post_list_item, false))

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postView: PostView, clickListener: (PostView) -> Unit) {
            itemView.titleText.text = postView.title
            itemView.setOnClickListener {
                clickListener(postView)
            }
        }
    }

}