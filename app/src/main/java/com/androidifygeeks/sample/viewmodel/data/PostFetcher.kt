package com.androidifygeeks.sample.viewmodel.data

import com.androidifygeeks.sample.repository.ContentRepository
import javax.inject.Inject


/**
 * @author ashish on 11,December,2018
 */
class PostFetcher @Inject constructor(private val contentRepository: ContentRepository) :
    UseCase<List<Post>, UseCase.None>() {


    override suspend fun run(params: None) = contentRepository.showPosts()


}