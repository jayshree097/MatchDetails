package com.example.matchdetails.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.matchdetails.databinding.PlayerNameLayoutBinding
import com.example.matchdetails.model.PlayerList

class PlayerListAdapter (
    val context: Context, var playerDetailsCallback: PalyerDetailsCallback,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var playerDeatis: MutableList<PlayerList>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return PlayerDetailsViewHolder(PlayerNameLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    private class PlayerDetailsViewHolder(inflate: PlayerNameLayoutBinding) : RecyclerView.ViewHolder(inflate.root) {
        val b: PlayerNameLayoutBinding = inflate
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PlayerDetailsViewHolder) {
            playerDeatis?.get(position).let { model ->

                holder.b.tvPlayer1.text=model?.nameFull
                holder.b.clPlayerName.setOnClickListener {
//                    playerDetailsCallback.onPlayername(model)
                }


            }
        }

    }
    fun addList(playerList: ArrayList<PlayerList>) {
        if (this.playerDeatis == null) {
            this.playerDeatis = playerList
        } else {
            this.playerDeatis?.addAll(playerList)
        }
        this.notifyDataSetChanged()

    }
    override fun getItemCount(): Int {
        return playerDeatis?.size ?:

        Log.d("MYTAGSIZE", "getItemCount: "+playerDeatis?.size)
    }


    interface PalyerDetailsCallback {
        fun onPlayername(model: PlayerList?)
    }
}