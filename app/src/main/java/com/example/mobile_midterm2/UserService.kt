package com.example.mobile_midterm2

import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers(): List<User>
}