package com.fritte.demohiltsa.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fritte.demohiltsa.data.repositories.WorkflowRepository
import com.fritte.demohiltsa.data.utils.Resource
import kotlinx.coroutines.Dispatchers

class WorkflowViewModel @ViewModelInject constructor(
    private val repository: WorkflowRepository
) : ViewModel() {

    /* get workflows */
    fun getWorkflows() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getWorkflows()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}