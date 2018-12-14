package com.androidifygeeks.sample.viewmodel

import com.androidifygeeks.sample.repository.ContentRepository
import com.androidifygeeks.sample.viewmodel.data.Album
import com.androidifygeeks.sample.viewmodel.data.UseCase
import javax.inject.Inject


/**
 * @author ashish on 11,December,2018
 */
class AlbumFetcher @Inject constructor(private val contentRepository: ContentRepository) :
    UseCase<List<Album>, AlbumFetcher.Params>() {

    override suspend fun run(params: Params) = contentRepository.showAlbums(params.userId)


    data class Params(val userId: Int)

}