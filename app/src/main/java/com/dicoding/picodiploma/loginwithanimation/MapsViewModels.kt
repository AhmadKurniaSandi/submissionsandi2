package com.dicoding.picodiploma.loginwithanimation

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.loginwithanimation.data.RepositoryStory

class MapsViewModels(
    private val repo: RepositoryStory,
) : ViewModel() {

    fun getStoriesMaps() = repo.getMaps()
}