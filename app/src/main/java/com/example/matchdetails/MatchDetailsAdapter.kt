package com.example.matchdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matchdetails.databinding.MatchDetailsLayoutBinding
import com.example.matchdetails.model.ResponseMatchInfo
import com.google.android.material.textview.MaterialTextView

class MatchDetailsAdapter (var context:Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
         var mList:List<ResponseMatchInfo>?=null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(MatchDetailsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    private class ViewHolder(inflate: MatchDetailsLayoutBinding) : RecyclerView.ViewHolder(inflate.root) {
        val b: MatchDetailsLayoutBinding = inflate
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {

            mList?.get(position).let { model ->

                holder.b.tvTeamA.text=model?.matchdetail?.series?.tourName
            }
        }
    }



    override fun getItemCount(): Int {
        return mList?.size?:0
    }


}