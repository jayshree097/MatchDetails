package com.example.matchdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.matchdetails.Adapter.PlayerListAdapter
import com.example.matchdetails.databinding.FragmentSquadeDetailsBinding
import com.example.matchdetails.model.PlayerList

import com.example.matchdetails.model.TeamList
import com.example.matchdetails.viewModel.PlayerViewModel
import com.example.matchdetails.viewModel.TeamViewModel
import okhttp3.internal.notifyAll
import org.json.JSONObject


class SquadeDetailsFragment : Fragment(),PlayerListAdapter.PalyerDetailsCallback {

    private var _squadDetailsFragment: FragmentSquadeDetailsBinding? = null
    private lateinit var teamViewModel: TeamViewModel
    private lateinit var playerViewModel: PlayerViewModel
    private var playerListAdapter: PlayerListAdapter? = null

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


        playerViewModel= ViewModelProvider(requireActivity()).get(PlayerViewModel::class.java)
        playerViewModel.getPlayerApiData()

        playerViewModel.playerDataList.observe(requireActivity()) {
//            extractData(it)

            playerListAdapter?.addList(it as ArrayList<PlayerList>)

                playerListAdapter= PlayerListAdapter(requireContext(),this)
                _squadDetailsFragment?.recyclerView?.adapter=playerListAdapter



        }

    }

    private fun extractData(it: TeamList?) {
        var response = it?.teams
        val dates = response?.keys
        val codes = response?.values
        val rates= response?.values
//        _squadDetailsFragment?.tvCountry?.text= codes?.iterator()?.next()?.nameFull
        _squadDetailsFragment?.tvCountry?.text= it?.teams?.values?.first()?.nameFull
        _squadDetailsFragment?.tvCountry1?.text= it?.teams?.values?.last()?.nameFull

//        _squadDetailsFragment?.tvCountry1?.text= codes?.iterator()?.next()?.nameFull?.g

//        _squadDetailsFragment?.tvPlayer1?.text= codes?.iterator()?.next()?.teams?.values?.iterator()?.next()?.nameFull
      _squadDetailsFragment?.tvPlayer1?.text= codes?.first()?.teams?.values?.toString()

       /* playerListAdapter?.addList(it as ArrayList<ResponseTeam>)
         if (it?.teams?.values?.iterator()?.next()?.teams?.values?.isNotEmpty()==true){

             playerListAdapter= PlayerListAdapter(requireContext(),this)
             _squadDetailsFragment?.recyclerView?.adapter=playerListAdapter
         }
*/
        _squadDetailsFragment?.tvPlayer2?.text= codes?.last()?.teams?.values?.minus("[PlayerList(nameFull=").toString()

    }

    override fun onPlayername(model: PlayerList?) {
        Log.d("MYTAG6878", "onPlayername: "+model)
    }


}