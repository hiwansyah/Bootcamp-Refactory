package com.example.taskbootcamp.AdvanceRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskbootcamp.databinding.ActivityMainBinding
import com.example.taskbootcamp.AdvanceRecyclerView.model.Pager
import com.example.taskbootcamp.AdvanceRecyclerView.view.MainPagerAdapter
import com.example.taskbootcamp.AdvanceRecyclerView.view.ProfileFragment
import com.example.taskbootcamp.AdvanceRecyclerView.view.UserFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val pagers = listOf(
            Pager("User", UserFragment()),
            Pager("Profile", ProfileFragment())
        )
        val pagerAdapter = MainPagerAdapter(pagers, supportFragmentManager, lifecycle)

        binding.run {
            vpPager.adapter = pagerAdapter

            TabLayoutMediator(tlTabs, vpPager) { tab, index ->
                tab.text = pagers[index].title
            }.attach()
        }
    }
}