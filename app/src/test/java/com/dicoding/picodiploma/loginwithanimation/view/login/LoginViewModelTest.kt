package com.dicoding.picodiploma.loginwithanimation.view.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.picodiploma.loginwithanimation.DataDummy
import com.dicoding.picodiploma.loginwithanimation.MainDispatcherRule
import com.dicoding.picodiploma.loginwithanimation.model.UserPreference
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val preference = Mockito.mock(UserPreference::class.java)
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        loginViewModel = LoginViewModel(preference)
    }

    @Test
    fun `when user saved`() = runTest {
        loginViewModel.saveUser(DataDummy.generateDummyUser())
        Mockito.verify(preference)
            .saveUser(DataDummy.generateDummyUser())
    }

}