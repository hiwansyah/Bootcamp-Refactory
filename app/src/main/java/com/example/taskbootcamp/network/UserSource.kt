package com.example.taskbootcamp.network

import com.example.taskbootcamp.model.User
import com.example.taskbootcamp.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserSource{
    @GET("api/")
    fun getAllUsers(
        @Query("results") results: Int = 50,
        @Query("inc") inc: String = "name,phone,cell,picture"
    ): Call<User>
}