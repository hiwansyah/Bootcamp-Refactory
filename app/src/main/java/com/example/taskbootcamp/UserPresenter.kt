package com.example.taskbootcamp

import com.example.taskbootcamp.model.User
import com.example.taskbootcamp.network.NetworkProvider
import com.example.taskbootcamp.network.UserSource
import com.example.taskbootcamp.view.UserView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserPresenter(private val view: UserView) {
    fun discoverUser(){
        view.onShowLoading()
        val datasource = NetworkProvider.providesHttpAdapter().create(UserSource::class.java)
        datasource.getAllUsers().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                view.onHideLoading()
                view.onResponse(response.body()?.results ?: emptyList())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                view.onShowLoading()
                view.onFailure(t)
            }
        })
    }
}


