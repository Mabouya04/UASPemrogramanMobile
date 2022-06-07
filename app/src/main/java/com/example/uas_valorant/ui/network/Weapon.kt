package com.example.uas_valorant.ui.network

import java.io.Serializable

data class Weapon(
    val data: List<DataItem>? = null,
    val status: Int? = null
)

data class shopData(
    val canBeTrashed: Boolean? = null,
    val image: Any? = null,
    val cost: Int? = null,
    val newImage: String? = null,
    val newImage2: Any? = null,
    val assetPath: String? = null,
    val gridPosition: GridPosition? = null,
    val category: String? = null,
    val categoryText: String? = null
)

data class GridPosition(
    val column: Int? = null,
    val row: Int? = null
)

data class DataItem(
    val skins: List<SkinsItem?>? = null,
    val displayIcon: String? = null,
    val killStreamIcon: String? = null,
    val shopData: shopData? = null,
    val defaultSkinUuid: String? = null,
    val displayName: String? = null,
    val assetPath: String? = null,
    val category: String? = null,
    val uuid: String? = null
) : Serializable {}



data class AltShotgunStats(
    val shotgunPelletCount: Int? = null,
    val burstRate: Double? = null
)



data class SkinsItem(
    val displayIcon: String? = null,
    val contentTierUuid: String? = null,
    val wallpaper: Any? = null,
    val displayName: String? = null,
    val assetPath: String? = null,
    val chromas: List<ChromasItem?>? = null,
    val uuid: String? = null,
    val themeUuid: String? = null,
    val levels: List<LevelsItem?>? = null
)

data class ChromasItem(
    val displayIcon: String? = null,
    val swatch: String? = null,
    val displayName: String? = null,
    val assetPath: String? = null,
    val fullRender: String? = null,
    val uuid: String? = null,
    val streamedVideo: Any? = null
)

data class AirBurstStats(
    val shotgunPelletCount: Int? = null,
    val burstDistance: Double? = null
)

data class AdsStats(
    val fireRate: Double? = null,
    val burstCount: Int? = null,
    val runSpeedMultiplier: Double? = null,
    val zoomMultiplier: Double? = null,
    val firstBulletAccuracy: Double? = null
)

data class LevelsItem(
    val displayIcon: String? = null,
    val levelItem: Any? = null,
    val displayName: String? = null,
    val assetPath: String? = null,
    val uuid: String? = null,
    val streamedVideo: String? = null
)

