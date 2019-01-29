package com.example.autapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)



        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener{
            val intent = Intent(context, AddActivity::class.java)
            startActivity(intent)
        }
    }


    companion object {
        fun newInstance(): HomeFragment = HomeFragment()

    }



}
