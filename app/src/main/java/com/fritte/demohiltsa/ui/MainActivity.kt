package com.fritte.demohiltsa.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fritte.demohiltsa.R
import com.fritte.demohiltsa.data.utils.Status
import com.fritte.demohiltsa.ui.main.adapter.WorkflowAdapter
import com.fritte.demohiltsa.ui.main.viewmodel.WorkflowViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val workflowViewModel: WorkflowViewModel by viewModels()
    private lateinit var workflowAdapter: WorkflowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workflowAdapter = WorkflowAdapter()

        workflowRV.apply {
            adapter = workflowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        workflowViewModel.getWorkflows().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    workflowAdapter.setWorflowList(it.data)
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
        })
    }
}