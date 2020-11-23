package com.example.taskbootcamp.AdvanceRecyclerView.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.taskbootcamp.AdvanceRecyclerView.MainActivity
import com.example.taskbootcamp.R
import com.example.taskbootcamp.AdvanceRecyclerView.adapter.UserAdapter
import com.example.taskbootcamp.AdvanceRecyclerView.model.UserModel
import com.example.taskbootcamp.AdvanceRecyclerView.presenter.UserPresenter
import kotlinx.android.synthetic.main.fragment_user.*

class ProfileFragment : Fragment(), UserView {

    private val binding by lazy { layoutInflater }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
        rvUser.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rvUser.adapter = UserAdapter(results)
    }
}