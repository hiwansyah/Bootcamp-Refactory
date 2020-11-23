package com.example.taskbootcamp.AdvanceRecyclerView.model

sealed class Users{
    data class Category(val category: String):Users()
    data class Data(val users: User): Users()
}