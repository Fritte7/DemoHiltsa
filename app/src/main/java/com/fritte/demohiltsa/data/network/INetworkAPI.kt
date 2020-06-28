package com.fritte.demohiltsa.data.network

import com.fritte.demohiltsa.data.model.User
import com.fritte.demohiltsa.data.model.Workflow
import retrofit2.http.GET

interface INetworkAPI {
    @GET("user")
    suspend fun getUsers() : List<User>

    @GET("workflows")
    suspend fun getWorkflows() : List<Workflow>
}