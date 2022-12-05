package com.dicoding.picodiploma.loginwithanimation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dicoding.picodiploma.loginwithanimation.data.RepositoryStory
import com.dicoding.picodiploma.loginwithanimation.di.Injection
import com.dicoding.picodiploma.loginwithanimation.view.login.LoginViewModel
import com.dicoding.picodiploma.loginwithanimation.view.main.MainViewModel

class PagingViewModel(repo: RepositoryStory): ViewModel() {
    val listStory: LiveData<PagingData<ListStories>> = repo.getStory().cachedIn(viewModelScope)
}

class ViewModelFactoryPaging (private val token: String): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PagingViewModel::class.java) -> {
                PagingViewModel(Injection.provideRepository(token)) as T
            }
            modelClass.isAssignableFrom(MapsViewModels::class.java) -> {
                MapsViewModels(Injection.provideRepository(token)) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}