package com.example.autapplication.OtherActivityAndFragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autapplication.Model.Response.Work
import com.example.autapplication.Works.HomePresenter
import com.example.autapplication.Works.WorksAdapter
import com.example.autapplication.Works.WorksView


import kotlinx.android.synthetic.main.fragment_home.*
import android.widget.Toast
import com.example.autapplication.R


class HomeFragment : Fragment(), WorksView {

    var cust: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        return view

    }

    private var View.isVisible: Boolean
        get() = visibility == View.VISIBLE
        set(value) {
            visibility = if (value) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

    val adapter = WorksAdapter {
        showLookScreen(it)
    }

    private val presenter = HomePresenter()

    private fun showLookScreen(work: Work) {
        val intent = Intent(requireContext(), LookActivity::class.java)
            .putExtra("title", work.problem_title)
            .putExtra("description", work.problem_description)
            .putExtra("coins", work.coins)
            .putExtra("customer",cust)


        startActivity(intent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customer = getArguments()?.getString("customer")
        cust = customer.toString()


        worksRecyclerView.layoutManager = LinearLayoutManager(context)
        worksRecyclerView.adapter = adapter

        fab.setOnClickListener {
            val intent = Intent(context, AddActivity::class.java)
               .putExtra("customer",customer)
            startActivity(intent)
        }

        val recyclerView = worksRecyclerView

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 || dy < 0 && fab.isShown) {
                    fab.hide()
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fab.show()
                }

                super.onScrollStateChanged(recyclerView, newState)
            }
        })

    }

    companion object {
        fun newInstance(): HomeFragment =
            HomeFragment()

    }

    override fun onStart() {
        super.onStart()
        presenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbindView()
    }

    override fun showWorks(works: List<Work>) {
        adapter.setWorks(works)
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
//        worksRecyclerView.isVisible = false
        worksRecyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        worksRecyclerView.isVisible = true
//        worksRecyclerView.visibility = View.GONE
        progressBar.visibility = View.GONE
    }
}
