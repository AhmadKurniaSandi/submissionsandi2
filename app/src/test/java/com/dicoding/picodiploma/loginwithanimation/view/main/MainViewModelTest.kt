package com.dicoding.picodiploma.loginwithanimation.view.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.picodiploma.loginwithanimation.DataDummy
import com.dicoding.picodiploma.loginwithanimation.MainDispatcherRule
import com.dicoding.picodiploma.loginwithanimation.model.UserPreference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
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
class MainViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var mainViewModel: MainViewModel
    private val preference = Mockito.mock(UserPreference::class.java)

    @Before
    fun setUp() {
        mainViewModel = MainViewModel(preference)
    }

    @Test
    fun `when logout() is called should Success`() = runTest {
        mainViewModel.logout()
        Mockito.verify(preference).logout()
    }

    @Test
    fun `when Get User Should Not Null and Return Success`() {
        val expectedUser = flowOf(DataDummy.generateDummyUser())
        Mockito.`when`(preference.getUser()).thenReturn(expectedUser)

        mainViewModel.getUser().observeForever {
            assertNotNull(it.token)
            assertEquals(DataDummy.generateDummyUser().token, it.token)
        }

        Mockito.verify(preference).getUser()

    }

}