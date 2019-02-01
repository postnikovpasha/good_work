package com.example.autapplication.works

import com.example.autapplication.model.response.Work

interface WorksView {
    fun showWorks(works: List<Work>)
    fun showMessage(message: String)
    fun showProgress()
    fun hideProgress()
}