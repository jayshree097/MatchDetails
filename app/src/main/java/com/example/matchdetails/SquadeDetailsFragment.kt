package com.example.matchdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.matchdetails.databinding.FragmentMatchDetailsBinding
import com.example.matchdetails.databinding.FragmentSquadeDetailsBinding
import com.example.matchdetails.viewModel.MatchViewModel
import com.example.matchdetails.viewModel.TeamViewModel

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
//            _squadDetailsFragment?.tvCountry?.text=it.teams?.

        }



    }


}