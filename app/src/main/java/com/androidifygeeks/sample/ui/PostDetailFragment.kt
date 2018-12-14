package com.androidifygeeks.sample.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.androidifygeeks.sample.R
import com.androidifygeeks.sample.ui.adapter.PhotoAdapter
import com.androidifygeeks.sample.ui.util.CommonBaseFragment
import com.androidifygeeks.sample.util.exception.Failure
import com.androidifygeeks.sample.util.extension.*
import com.androidifygeeks.sample.viewmodel.PostDetailViewModel
import com.androidifygeeks.sample.viewmodel.data.*
import kotlinx.android.synthetic.main.fragment_post_detail_layout.*
import javax.inject.Inject

/**
 * @author ashish on 12,December,2018
 */
class PostDetailFragment : CommonBaseFragment() {


    @Inject
    lateinit var photoAdapter: PhotoAdapter

    companion object {
        private const val PARAM_POST = "param_post"

        fun forPost(post: PostView): PostDetailFragment {
            val postDetailFragment = PostDetailFragment()
            val arguments = Bundle()
            arguments.putParcelable(PARAM_POST, post)
            postDetailFragment.arguments = arguments

            return postDetailFragment
        }
    }

    private lateinit var postDetailViewModel: PostDetailViewModel

    override fun layoutId() = R.layout.fragment_post_detail_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        postDetailViewModel = viewModel(viewModelFactory) {
            observe(userDetailView, ::renderUserDetail)
            observe(comments, ::renderComments)
            observe(albums, ::renderAlbums)
            observe(photos, ::renderPhotos)
            failure(failure, ::handleFailure)
        }
    }

    private fun renderPhotos(photos: List<PhotoView>?) {
        // initialize an adapter for rendering the photos

        // setting 1st image on the banner
        image_banner.loadFromUrl(photos?.get(0)!!.url)
        //photos adapter
        photoAdapter.collection = photos.orEmpty()

    }

    /**
     * list of albums for retrieving the photos of an user
     */
    private fun renderAlbums(albums: List<AlbumView>?) {
        // picking up first album id for group of photos
        loadPhotos(albums?.get(0)!!.id)
    }

    private fun renderComments(comments: List<CommentView>?) {
        comment_text.text = comments?.get(0)!!.body
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadUserDetail()
        loadComments()
        loadAlbums()
    }

    private fun initializeView() {
        post_detail_image_list.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        post_detail_image_list.adapter = photoAdapter
    }

    private fun loadUserDetail() {
        postDetailViewModel.loadUserDetails((arguments?.get(PARAM_POST) as PostView).userId)
    }

    private fun loadComments() {
        postDetailViewModel.loadComments((arguments?.get(PARAM_POST) as PostView).id)
    }

    private fun loadAlbums() {
        postDetailViewModel.loadAlbums((arguments?.get(PARAM_POST) as PostView).userId)
    }

    private fun loadPhotos(albumId: Int) {
        postDetailViewModel.loadPhotos(albumId)
    }

    private fun renderUserDetail(userDetail: UserDetailView?) {
        user_title_text.text = userDetail!!.name
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> {
                notify(R.string.failure_network_connection); close()
            }
            is Failure.ServerError -> {
                notify(R.string.failure_server_error); close()
            }
        }
    }
}