package com.example.uas_valorant.ui.network

import java.io.Serializable

data class Map(
	val data: List<dataItem>? = null,
	val status: Int? = null
)

data class Location(
	val X: Double? = null,
	val Y: Double? = null
)

data class CalloutsItem(
	val superRegionName: String? = null,
	val regionName: String? = null,
	val location: Location? = null
)

data class dataItem(
	val callouts: List<CalloutsItem?>? = null,
	val displayName: String? = null,
	val listViewIcon: String? = null,
	val coordinates: String? = null,
	val yScalarToAdd: Double? = null,
	val yMultiplier: Double? = null,
	val uuid: String? = null,
	val displayIcon: String? = null,
	val xMultiplier: Double? = null,
	val xScalarToAdd: Double? = null,
	val assetPath: String? = null,
	val mapUrl: String? = null,
	val splash: String? = null
) : Serializable

