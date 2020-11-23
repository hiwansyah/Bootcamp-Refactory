package com.example.taskbootcamp.AdvanceRecyclerView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.taskbootcamp.AdvanceRecyclerView.model.User
import com.example.taskbootcamp.databinding.ItemUsersBinding
import com.example.taskbootcamp.AdvanceRecyclerView.model.UserModel
import com.example.taskbootcamp.AdvanceRecyclerView.model.Users
import com.example.taskbootcamp.AdvanceRecyclerView.view.UserView
import com.example.taskbootcamp.databinding.FragmentUserBinding
import com.example.taskbootcamp.databinding.ItemUsersCategoryBinding
import java.net.URL
import java.util.*
import java.util.ServiceLoader.load

class UserAdapter(private val results: List<UserModel>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
   /* private var userList = mutableListOf<Users>()

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_DATA = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                    ItemUsersCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
            )
            TYPE_DATA -> UserViewHolder(
                    ItemUsersBinding.inflate(LayoutInflater.from(context), parent, false)
            )
            else -> throw IllegalArgumentException("unsupport view")
        }
    }


    fun setData(item: MutableList<Users>){
        this.userList = item
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        this.userList.removeAt(position)
        notifyItemRemoved(position)
    }
    fun restoreItem(item: Users, position: Int) {
        val arrayList = ArrayList(userList)
        arrayList.add(position, item)
        userList = arrayList
        notifyItemInserted(position)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(userList[position]){
            is Users.Category -> TYPE_HEADER
            is Users.Data -> TYPE_DATA
        }

    }

    fun getData(position: Int): Users {
        return userList[position]
    }


    class UserViewHolder(val usersBinding: ItemUsersBinding) : RecyclerView.ViewHolder(usersBinding.root) {
        var binding: ItemUsersBinding? = null

        init {
            this.binding = usersBinding
        }

        companion object {
            @JvmStatic
            @BindingAdapter
            fun loadImage(view: ImageView, url: String) {
                Glide.with(view.context)
                        .load(url)
                        .into(view)

            }
        }

    }

    inner class HeaderViewHolder(private val binding: ItemUsersCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binData(category: String) {
            binding.run {
                tvCategory.text = category.toUpperCase(Locale.getDefault())
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[position]
        if (user is Users.Data && holder is UserViewHolder) {
            holder.usersBinding. = user.
        } else if (user is Users.Category && holder is HeaderViewHolder) {
            holder.binData(user.category)
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val viewHolder = UserViewHolder(ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return viewHolder
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount(): Int = results.size

    inner class UserViewHolder(private val binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserModel) {
                binding.tvName.text = item.name.first
                binding.tvPhone.text = item.phone
                binding.tvCell.text = item.cell
                Glide.with(binding.root).load(item.picture.medium).circleCrop().into(binding.ivPicture)
        }
    }
}


