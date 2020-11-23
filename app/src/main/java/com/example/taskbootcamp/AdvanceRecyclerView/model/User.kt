package com.example.taskbootcamp.AdvanceRecyclerView.model

import com.google.gson.annotations.SerializedName


data class User(
	@field:SerializedName("results")
	val results: List<UserModel>
)