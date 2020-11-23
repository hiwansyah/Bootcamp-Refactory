package com.example.taskbootcamp.AdvanceRecyclerView.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskbootcamp.AdvanceRecyclerView.model.User
import com.example.taskbootcamp.AdvanceRecyclerView.model.UserModel
import com.example.taskbootcamp.AdvanceRecyclerView.network.NetworkProvider
import com.example.taskbootcamp.AdvanceRecyclerView.network.UserSource
import com.example.taskbootcamp.AdvanceRecyclerView.view.UserView
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


