package com.example.uas_valorant.ui.network

import java.io.Serializable

data class Agent(
    val data: List<DataItems>? = null,
    val status: Int? = null
)

data class DataItems(
    val abilities: List<AbilitiesItem?>? = null,
    val role: role? = null,
    val displayIcon: String? = null,
    val background: String? = null,
    val developerName: String? = null,
    val displayName: String? = null,
    val description: String? = null,
    val uuid: String? = null
) : Serializable {}

data class role(
    val assetPath: String? = null,
    val displayIcon: String? = null,
    val displayName: String? = null,
    val description: String? = null,
    val uuid: String? = null
)

data class AbilitiesItem(
    val slot: String? = null,
    val displayName: String? = null,
    val description: String? = null,
    val displayIcon: String? = null,
)