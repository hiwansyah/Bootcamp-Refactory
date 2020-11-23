package com.example.taskbootcamp.AdvanceRecyclerView.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taskbootcamp.AdvanceRecyclerView.model.Pager

class MainPagerAdapter(
    private val list: List<Pager>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {
    override  fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position].fragment

}