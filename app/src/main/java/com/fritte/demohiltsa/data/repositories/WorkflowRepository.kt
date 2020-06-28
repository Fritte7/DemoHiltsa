package com.fritte.demohiltsa.data.repositories

import com.fritte.demohiltsa.data.model.Workflow
import com.fritte.demohiltsa.data.network.INetworkAPI
import javax.inject.Inject

class WorkflowRepository @Inject constructor(
    private val api : INetworkAPI
) {

    suspend fun getWorkflows() : List<Workflow> = api.getWorkflows()
}