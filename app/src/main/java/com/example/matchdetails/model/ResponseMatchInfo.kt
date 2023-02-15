package com.example.matchdetails.model

import com.google.gson.annotations.SerializedName

data class ResponseMatchInfo(

	@field:SerializedName("Matchdetail")
	val matchdetail: Matchdetail? = null
)

data class Venue(

	@field:SerializedName("Id")
	val id: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)

data class Match(

	@field:SerializedName("League")
	val league: String? = null,

	@field:SerializedName("Type")
	val type: String? = null,

	@field:SerializedName("Number")
	val number: String? = null,

	@field:SerializedName("Livecoverage")
	val livecoverage: String? = null,

	@field:SerializedName("Time")
	val time: String? = null,

	@field:SerializedName("Daynight")
	val daynight: String? = null,

	@field:SerializedName("Id")
	val id: String? = null,

	@field:SerializedName("Code")
	val code: String? = null,

	@field:SerializedName("Date")
	val date: String? = null,

	@field:SerializedName("Offset")
	val offset: String? = null
)

data class Matchdetail(

	@field:SerializedName("Status")
	val status: String? = null,

	@field:SerializedName("Venue")
	val venue: Venue? = null,

	@field:SerializedName("Team_Home")
	val teamHome: String? = null,

	@field:SerializedName("Status_Id")
	val statusId: String? = null,

	@field:SerializedName("Player_Match")
	val playerMatch: String? = null,

	@field:SerializedName("Equation")
	val equation: String? = null,

	@field:SerializedName("Officials")
	val officials: Officials? = null,

	@field:SerializedName("Winningteam")
	val winningteam: String? = null,

	@field:SerializedName("Match")
	val match: Match? = null,

	@field:SerializedName("Result")
	val result: String? = null,

	@field:SerializedName("Weather")
	val weather: String? = null,

	@field:SerializedName("Team_Away")
	val teamAway: String? = null,

	@field:SerializedName("Series")
	val series: Series? = null,

	@field:SerializedName("Tosswonby")
	val tosswonby: String? = null,

	@field:SerializedName("Winmargin")
	val winmargin: String? = null
)

data class Officials(

	@field:SerializedName("Umpires")
	val umpires: String? = null,

	@field:SerializedName("Referee")
	val referee: String? = null
)

data class Series(

	@field:SerializedName("Status")
	val status: String? = null,

	@field:SerializedName("Tour_Name")
	val tourName: String? = null,

	@field:SerializedName("Id")
	val id: String? = null,

	@field:SerializedName("Name")
	val name: String? = null,

	@field:SerializedName("Tour")
	val tour: String? = null
)
