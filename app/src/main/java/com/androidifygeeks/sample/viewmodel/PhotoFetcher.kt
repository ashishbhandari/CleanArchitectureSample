package com.androidifygeeks.sample.viewmodel

import com.androidifygeeks.sample.repository.ContentRepository
import com.androidifygeeks.sample.viewmodel.data.Photo
import com.androidifygeeks.sample.viewmodel.data.UseCase
import javax.inject.Inject


/**
 * @author ashish on 11,December,2018
 */
class PhotoFetcher @Inject constructor(private val contentRepository: ContentRepository) :
    UseCase<List<Photo>, PhotoFetcher.Params>() {

    override suspend fun run(params: Params) = contentRepository.showPhotos(params.albumId)


    data class Params(val albumId: Int)

}