package com.example.autapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.autapplication.model.response.Work
import com.example.autapplication.works.CoinsView
import com.example.autapplication.works.ProfilePresenter
import com.example.autapplication.works.WorksView
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.works_item.*


class ProfileFragment : Fragment(), CoinsView{

    private val presenter = ProfilePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)
        presenter.onViewShown()

        btnChange.setOnClickListener{
            Toast.makeText(requireContext(), "Oops..out of service", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }

    override fun showCoins(coins: Int) {
        coinsSum.text = coins.toString()
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}
