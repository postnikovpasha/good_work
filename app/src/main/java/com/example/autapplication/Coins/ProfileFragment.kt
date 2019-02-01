package com.example.autapplication.Coins

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.autapplication.R
import kotlinx.android.synthetic.main.fragment_profile.*
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


class ProfileFragment : Fragment(), CoinsView {

    private val presenter = ProfilePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(com.example.autapplication.R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)

        val customer = getArguments()?.getString("customer")
        if (customer != null) {
            presenter.onViewShown(customer)
        }


        btnChange.setOnClickListener{
            val scale = AnimationUtils.loadAnimation(requireContext(), com.example.autapplication.R.anim.scale)
            it.startAnimation(scale)
            Toast.makeText(requireContext(), "Oops..out of service", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance(): ProfileFragment =
            ProfileFragment()
    }

    override fun showCoins(coins: Int) {
        coinsSum?.text = coins.toString()
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showCustomer(login: String) {
        customerName?.text = login
    }
}
