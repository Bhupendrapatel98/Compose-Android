package com.app.firstcomposeapplication.ui

import retrofit2.http.GET

interface UserApi {

    @GET("todos")
    suspend fun getUserById(): List<UserDataItem>

}