package com.androidifygeeks.sample.viewmodel

import com.androidifygeeks.sample.repository.ContentRepository
import com.androidifygeeks.sample.viewmodel.data.Comment
import com.androidifygeeks.sample.viewmodel.data.UseCase
import javax.inject.Inject


/**
 * @author ashish on 11,December,2018
 */
class CommentsFetcher @Inject constructor(private val contentRepository: ContentRepository) :
    UseCase<List<Comment>, CommentsFetcher.Params>() {

    override suspend fun run(params: Params) = contentRepository.showComments(params.postId)


    data class Params(val postId: Int)

}