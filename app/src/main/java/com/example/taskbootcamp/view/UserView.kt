package com.example.taskbootcamp.view

import android.content.Context
import com.example.taskbootcamp.model.UserModel

interface UserView {
    fun onShowLoading()
    fun onHideLoading()
    fun onFailure(error: Throwable)
    fun onResponse(results: List<UserModel>)
}