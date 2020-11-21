package com.example.taskbootcamp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class User(
	@field:SerializedName("results")
	val results: List<UserModel>
)