package com.example.taskbootcamp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskbootcamp.databinding.ItemUsersBinding
import com.example.taskbootcamp.model.UserModel

class UserAdapter(private val results: List<UserModel>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val viewHolder = UserViewHolder(ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return viewHolder
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(results[holder.adapterPosition])
    }

    override fun getItemCount(): Int = results.count()

    inner class UserViewHolder(private val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserModel) {
                binding.tvName.text = item.name.first
                binding.tvCell.text = item.cell
                Glide.with(binding.root).load(item.picture.medium).circleCrop().into(binding.ivPicture)
        }
    }
}


