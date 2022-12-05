package com.dicoding.picodiploma.loginwithanimation

import com.dicoding.picodiploma.loginwithanimation.model.UserModel

object DataDummy {

    private fun generateDummyLogin(): LoginResult {
        return LoginResult(
            "Kabasaran Sandi",
            "A04",
            "askjdjkabkwdwa"
        )
    }

    fun generateDummyMaps(): StoryResponse{
        val storyList = arrayListOf<ListStories>()
        for (i in 0 .. 10) {
            val postStory = ListStories(
                "ahmad sandi",
                "photo_link",
                "ajksndkajdb",
                "story $i",
                5.27125,
                87.683845
            )

            storyList.add(postStory)
        }
        return StoryResponse(false, "Stories fetched successfully", generateDummyLogin(), storyList)
    }

    fun generateDummyUser(): UserModel {
        return UserModel(
            token = "userToken",
            isLogin = true
        )
    }

}