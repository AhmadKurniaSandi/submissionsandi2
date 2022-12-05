package com.dicoding.picodiploma.loginwithanimation.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.dicoding.picodiploma.loginwithanimation.ApiService
import com.dicoding.picodiploma.loginwithanimation.ListStories
import com.dicoding.picodiploma.loginwithanimation.Result
import com.dicoding.picodiploma.loginwithanimation.StoryResponse


class RepositoryStory (
    private val apiService: ApiService,
    private val token: String
    ) {
    fun getStory(): LiveData<PagingData<ListStories>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                initialLoadSize = 5
            ),
            pagingSourceFactory = {
                StoryPagingSource(apiService, token)
            }
        ).liveData
    }

    fun getMaps(): LiveData<Result<StoryResponse>> = liveData {
        emit(Result.Loading)
        try {
            val result = apiService.getStories("Bearer $token", location = 1)
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e.message.toString()))
        }
    }
}