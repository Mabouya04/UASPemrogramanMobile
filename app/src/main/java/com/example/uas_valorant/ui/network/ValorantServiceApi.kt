package com.example.uas_valorant

import com.example.uas_valorant.ui.network.Agent
import com.example.uas_valorant.ui.network.Map
import com.example.uas_valorant.ui.network.Weapon
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://valorant-api.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ValorantServiceApi{
    @GET("v1/weapons")
    fun getListWeapons(): Deferred<Weapon>
}

interface ValorantServicesApi{
    @GET("v1/agents")
    fun getListAgents(): Deferred<Agent>
}

interface ValorantServiceApi1{
    @GET("v1/maps")
    fun getListMaps(): Deferred<Map>
}

object ValorantApi{
    val retrofitValorantApi : ValorantServiceApi by lazy {
        retrofit.create(ValorantServiceApi::class.java)
    }
}

object ValorantsApi{
    val retrofitValorantsApi: ValorantServicesApi by lazy {
        retrofit.create(ValorantServicesApi::class.java)
    }
}

object ValorantApi1{
    val retrofitValorantApi1 : ValorantServiceApi1 by lazy {
        retrofit.create(ValorantServiceApi1::class.java)
    }
}