package com.example.taskbootcamp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.taskbootcamp.databinding.ActivityMainBinding
import com.example.taskbootcamp.model.UserModel
import com.example.taskbootcamp.view.UserView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),UserView {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val presenter = UserPresenter(this)
        presenter.discoverUser()



    }

    override fun onShowLoading() {
        pgBar.visibility = View.VISIBLE

    }

    override fun onHideLoading() {
        pgBar.visibility = View.GONE
        rvUser.visibility = View.VISIBLE
    }


    override fun onFailure(error: Throwable) {
        Log.e(MainActivity::class.java.simpleName, "${error.printStackTrace()}")
    }

    override fun onResponse(results: List<UserModel>) {
        rvUser.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        rvUser.adapter = UserAdapter(results)
    }
}