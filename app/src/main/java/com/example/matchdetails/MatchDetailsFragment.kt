package com.example.matchdetails
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.matchdetails.databinding.FragmentMatchDetailsBinding
import com.example.matchdetails.model.ResponseMatchInfo
import com.example.matchdetails.viewModel.MatchViewModel


class MatchDetailsFragment : Fragment(), View.OnClickListener {
    private var _matchDetailsFragment: FragmentMatchDetailsBinding? = null
    private lateinit var matchDetailsViewModel:MatchViewModel
    private var matchListAdapter: MatchDetailsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


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
//        _matchDetailsFragment?.tvDetails?.setOnClickListener(this)


        matchDetailsViewModel=ViewModelProvider(requireActivity()).get(MatchViewModel::class.java)

        matchDetailsViewModel.getApiData()


        matchDetailsViewModel.matchDataList.observe(requireActivity()) {
          initAdapter(it)
        }


    }


    private fun initAdapter(data:ResponseMatchInfo){

        matchListAdapter= MatchDetailsAdapter(requireContext())
        _matchDetailsFragment?.rvMatchDetails?.adapter=matchListAdapter


    }

    override fun onClick(view: View?) {

        when(view?.id){
            /*R.id.tvDetails ->{
                findNavController().navigate(R.id.action_matchDetailsFragment_to_squadeDetailsFragment)
            }*/
        }
    }


}