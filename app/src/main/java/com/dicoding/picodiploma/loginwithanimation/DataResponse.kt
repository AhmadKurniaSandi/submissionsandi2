package com.dicoding.picodiploma.loginwithanimation

import com.google.gson.annotations.SerializedName


data class StoryResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("loginResult")
    val result: LoginResult,

    @field:SerializedName("listStory")
    val story: List<ListStories>,

    )

data class LoginResult(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("userId")
    val userId: String,

    @field:SerializedName("token")
    val token: String
)


data class ListStories(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("photoUrl")
    val photoUrl: String,

    @field:SerializedName("description")
    val description: String ?= null ,

    @field:SerializedName("id")
    val id:String ?= null,

    @field:SerializedName("lat")
    val lat: Double? = null,

    @field:SerializedName("lon")
    val lon: Double? = null
)



