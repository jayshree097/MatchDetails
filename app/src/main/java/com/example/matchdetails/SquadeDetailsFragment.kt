package com.example.matchdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.matchdetails.databinding.FragmentMatchDetailsBinding
import com.example.matchdetails.databinding.FragmentSquadeDetailsBinding

class SquadeDetailsFragment : Fragment() {

    private var _squadDetailsFragment: FragmentSquadeDetailsBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _squadDetailsFragment= FragmentSquadeDetailsBinding.inflate(inflater,container,false)
        return _squadDetailsFragment?.root
    }


}