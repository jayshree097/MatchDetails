package com.example.matchdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.matchdetails.databinding.FragmentSquadeDetailsBinding
import com.example.matchdetails.model.TeamList
import com.example.matchdetails.viewModel.TeamViewModel
import org.json.JSONArray
import org.json.JSONObject


class SquadeDetailsFragment : Fragment() {

    private var _squadDetailsFragment: FragmentSquadeDetailsBinding? = null
    private lateinit var teamViewModel: TeamViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _squadDetailsFragment= FragmentSquadeDetailsBinding.inflate(inflater,container,false)
        initComponent()
        return _squadDetailsFragment?.root
    }



    fun initComponent(){

        teamViewModel= ViewModelProvider(requireActivity()).get(TeamViewModel::class.java)
        teamViewModel.getApiData()

        teamViewModel.matchDataList.observe(requireActivity()) {
           extractData(it)

        }



    }

    private fun extractData(it: TeamList?) {
        var response = it?.teams
        val dates = response?.keys
        val codes = response?.values
        val rates= response?.values

        _squadDetailsFragment?.tvsqudDetails?.text= codes.toString()
    }

}