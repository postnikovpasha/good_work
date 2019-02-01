package com.example.autapplication.Works

import com.example.autapplication.Model.Response.Work

interface WorksView {
    fun showWorks(works: List<Work>)
    fun showMessage(message: String)
    fun showProgress()
    fun hideProgress()
}