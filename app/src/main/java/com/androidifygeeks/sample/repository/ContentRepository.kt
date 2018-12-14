package com.androidifygeeks.sample.repository


import com.androidifygeeks.sample.util.NetworkHandler
import com.androidifygeeks.sample.util.exception.Failure
import com.androidifygeeks.sample.util.functional.Either
import com.androidifygeeks.sample.viewmodel.data.*
import retrofit2.Call
import javax.inject.Inject

/**
 * @author ashish on 10,December,2018
 */
interface ContentRepository {

    fun showPosts(): Either<Failure, List<Post>>

    fun showUser(userId: Int): Either<Failure, User>

    fun showComments(postId: Int): Either<Failure, List<Comment>>

    fun showAlbums(userId: Int): Either<Failure, List<Album>>

    fun showPhotos(albumId: Int): Either<Failure, List<Photo>>


    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: ContentService
    ) : ContentRepository {

        override fun showUser(userId: Int): Either<Failure, User> {
            return when (networkHandler.isConnected) {
                true -> request(service.user(userId), { it.toUser() }, User.empty())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        override fun showComments(postId: Int): Either<Failure, List<Comment>> {
            return when (networkHandler.isConnected) {
                true -> request(service.comments(postId), { it.map { it.toComment() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        override fun showAlbums(userId: Int): Either<Failure, List<Album>> {
            return when (networkHandler.isConnected) {
                true -> request(service.albums(userId), { it.map { it.toAlbum() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }

        override fun showPhotos(albumId: Int): Either<Failure, List<Photo>> {
            return when (networkHandler.isConnected) {
                true -> request(service.photos(albumId), { it.map { it.toPhoto() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }


        override fun showPosts(): Either<Failure, List<Post>> {
            return when (networkHandler.isConnected) {
                true -> request(service.posts(), { it.map { it.toPost() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection())
            }
        }


        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError())
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError())
            }
        }
    }
}