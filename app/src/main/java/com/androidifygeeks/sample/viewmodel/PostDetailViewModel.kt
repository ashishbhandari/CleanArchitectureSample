package com.androidifygeeks.sample.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.androidifygeeks.sample.viewmodel.data.*
import javax.inject.Inject

/**
 * @author ashish on 12,December,2018
 */
class PostDetailViewModel @Inject constructor(
    private val getDetailFetcher: UserDetailFetcher,
    private val commentFetcher: CommentsFetcher,
    private val albumFetcher: AlbumFetcher,
    private val photoFetcher: PhotoFetcher
) : BaseViewModel() {


    var userDetailView: MutableLiveData<UserDetailView> = MutableLiveData()

    var comments: MutableLiveData<List<CommentView>> = MutableLiveData()

    var albums: MutableLiveData<List<AlbumView>> = MutableLiveData()

    var photos: MutableLiveData<List<PhotoView>> = MutableLiveData()


    fun loadUserDetails(userId: Int) =
        getDetailFetcher(UserDetailFetcher.Params(userId)) { it.either(::handleFailure, ::handleUserDetails) }

    private fun handleUserDetails(user: User) {
        this.userDetailView.value = UserDetailView(user.id, user.name, user.username, user.email)
    }

    fun loadComments(postId: Int) =
        commentFetcher(CommentsFetcher.Params(postId)) { it.either(::handleFailure, ::handleComments) }

    private fun handleComments(comments: List<Comment>) {
        this.comments.value = comments.map { CommentView(it.postId, it.id, it.name, it.email, it.body) }
    }

    fun loadAlbums(userId: Int) =
        albumFetcher(AlbumFetcher.Params(userId)) { it.either(::handleFailure, ::handleAlbums) }

    private fun handleAlbums(albums: List<Album>) {
        this.albums.value = albums.map { AlbumView(it.userId, it.id, it.title) }
    }

    fun loadPhotos(albumId: Int) =
        photoFetcher(PhotoFetcher.Params(albumId)) { it.either(::handleFailure, ::handlePhotos) }

    private fun handlePhotos(photos: List<Photo>) {
        this.photos.value = photos.map { PhotoView(it.albumId, it.id, it.thumbnailUrl, it.url) }
    }


}