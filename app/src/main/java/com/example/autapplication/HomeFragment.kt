package com.example.autapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autapplication.model.response.Work
import com.example.autapplication.works.HomePresenter
import com.example.autapplication.works.WorksAdapter
import com.example.autapplication.works.WorksView


import kotlinx.android.synthetic.main.fragment_home.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast


class HomeFragment : Fragment(), WorksView {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        return view

    }

    private val adapter = WorksAdapter()
    private val presener = HomePresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        worksRecyclerView.layoutManager = LinearLayoutManager(context)
        worksRecyclerView.adapter = adapter

        fab.setOnClickListener{
            val intent = Intent(context, AddActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = worksRecyclerView

    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()

    }
    override fun onStart() {
        super.onStart()
        presener.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presener.unbindView()
    }

    override fun showWorks(works: List<Work>) {
        adapter.setWorks(works)
    }



}
