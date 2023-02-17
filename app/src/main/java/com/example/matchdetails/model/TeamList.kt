package com.example.matchdetails.model

import com.google.gson.annotations.SerializedName

data class TeamList(
    @SerializedName("Teams")
    var teams:  Map<String, ResponseTeam>
)
