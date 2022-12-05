package com.dicoding.picodiploma.loginwithanimation.view.map

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dicoding.picodiploma.loginwithanimation.*
import com.dicoding.picodiploma.loginwithanimation.data.RepositoryStory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MapsViewModelsTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var mapsViewModels: MapsViewModels
    private val repo = Mockito.mock(RepositoryStory::class.java)

    @Before
    fun setUp() {
        mapsViewModels = MapsViewModels(repo)
    }

    @Test
    fun `when getStoriesMaps() is Called Should Not Null and Return Success`() {
        val expectedMaps = MutableLiveData<Result<StoryResponse>>()
        expectedMaps.value = Result.Success(DataDummy.generateDummyMaps())
        Mockito.`when`(repo.getMaps()).thenReturn(expectedMaps)

        val actualMaps = mapsViewModels.getStoriesMaps().getOrAwaitValue()
        assertNotNull(actualMaps)
        assertTrue(actualMaps is Result.Success<*>)
        assertEquals(DataDummy.generateDummyMaps().story.size,
            (actualMaps as Result.Success).data.story.size)
    }


}