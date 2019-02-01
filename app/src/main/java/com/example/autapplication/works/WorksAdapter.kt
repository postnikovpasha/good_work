package com.example.autapplication.works

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.autapplication.LookActivity
import com.example.autapplication.R
import com.example.autapplication.model.response.Work
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.works_item.view.*

class WorksAdapter(private val onWorkClick: (Work) -> Unit) : RecyclerView.Adapter<WorkHolder>() {

    private val works: MutableList<Work> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): WorkHolder =
        WorkHolder(LayoutInflater.from(parent.context).inflate(R.layout.works_item, parent, false))

    override fun getItemCount(): Int = works.size

    override fun onBindViewHolder(holder: WorkHolder, position: Int) {
        val work = works[position]
        holder.itemView.setOnClickListener { onWorkClick(work) }
        holder.bind(work)
    }

    fun setWorks(works: List<Work>) {
        this.works.clear()
        this.works.addAll(works)
        notifyDataSetChanged()
    }
}

class WorkHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(work: Work) {
        itemView.works_name.text = work.problem_title
        itemView.works_description.text = work.problem_description
        itemView.works_coins.text = work.coins
    }
}