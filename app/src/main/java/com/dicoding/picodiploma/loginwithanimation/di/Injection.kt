package com.dicoding.picodiploma.loginwithanimation.di

import com.dicoding.picodiploma.loginwithanimation.ApiConfig
import com.dicoding.picodiploma.loginwithanimation.data.RepositoryStory

object Injection {
    fun provideRepository(token: String): RepositoryStory {
        val apiService = ApiConfig.getApiService()
        return RepositoryStory(apiService, token)
    }
}