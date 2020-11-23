package com.example.taskbootcamp.AdvanceRecyclerView.view

import com.example.taskbootcamp.AdvanceRecyclerView.model.UserModel

interface UserView {
    fun onShowLoading()
    fun onHideLoading()
    fun onFailure(error: Throwable)
    fun onResponse(results: List<UserModel>)
}