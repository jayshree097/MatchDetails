package com.example.matchdetails
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.matchdetails.databinding.FragmentMatchDetailsBinding
import com.example.matchdetails.viewModel.MatchViewModel


class MatchDetailsFragment : Fragment(), View.OnClickListener {
    private var _matchDetailsFragment: FragmentMatchDetailsBinding? = null
    private lateinit var matchDetailsViewModel:MatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _matchDetailsFragment= FragmentMatchDetailsBinding.inflate(inflater,container,false)
        initComponent()
        return _matchDetailsFragment?.root
    }

    private fun initComponent(){
        _matchDetailsFragment?.clSuadDetails?.setOnClickListener(this)
        matchDetailsViewModel=ViewModelProvider(requireActivity()).get(MatchViewModel::class.java)
        matchDetailsViewModel.getApiData()


        matchDetailsViewModel.matchDataList.observe(requireActivity()) {
             _matchDetailsFragment?.tvTeamName?.text=it.matchdetail?.series?.name
            _matchDetailsFragment?.tvDate1?.text=it.matchdetail?.match?.date
            _matchDetailsFragment?.tvTime1?.text=it.matchdetail?.match?.time
            _matchDetailsFragment?.tvAddress1?.text=it.matchdetail?.venue?.name
            Log.d("RESPONSE", "initComponent: "+it)
        }


    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.cl_suad_details ->{
                findNavController().navigate(R.id.action_matchDetailsFragment_to_squadeDetailsFragment)
            }
        }
    }


}