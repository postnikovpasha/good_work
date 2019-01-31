package com.example.autapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.autapplication.model.response.Work
import com.example.autapplication.works.WorksView
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() , WorksView{
    override fun showWorks(works: List<Work>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnChange.setOnClickListener{
            Toast.makeText(requireContext(), "Oops..out of service", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }

    override fun showCoins(coins: String) {
        coinsSum.text = coins
    }
}
