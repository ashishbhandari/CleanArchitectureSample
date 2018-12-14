package com.androidifygeeks.sample.viewmodel

import com.androidifygeeks.sample.repository.ContentRepository
import com.androidifygeeks.sample.viewmodel.data.UseCase
import com.androidifygeeks.sample.viewmodel.data.User
import javax.inject.Inject


/**
 * @author ashish on 11,December,2018
 */
class UserDetailFetcher @Inject constructor(private val contentRepository: ContentRepository) :
    UseCase<User, UserDetailFetcher.Params>() {

    override suspend fun run(params: Params) = contentRepository.showUser(params.userId)


    data class Params(val userId: Int)

}