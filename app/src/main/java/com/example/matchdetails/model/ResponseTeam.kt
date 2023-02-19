package com.example.matchdetails.model
import com.google.gson.annotations.SerializedName

data class ResponseTeam (
    @field:SerializedName("Name_Short")
    val nameShort: String? = null,

    @field:SerializedName("Name_Full")
    var nameFull: String? = null,

    @field:SerializedName("Players")
    val teams: Map<String, PlayerList>
)



data class Batting(

    @field:SerializedName("Strikerate")
    val strikerate: String? = null,

    @field:SerializedName("Average")
    val average: String? = null,

    @field:SerializedName("Style")
    val style: String? = null,

    @field:SerializedName("Runs")
    val runs: String? = null
)

data class Bowling(

    @field:SerializedName("Economyrate")
    val economyrate: String? = null,

    @field:SerializedName("Average")
    val average: String? = null,

    @field:SerializedName("Style")
    val style: String? = null,

    @field:SerializedName("Wickets")
    val wickets: String? = null
)
