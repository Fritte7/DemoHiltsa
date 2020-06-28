package com.fritte.demohiltsa.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fritte.demohiltsa.R
import com.fritte.demohiltsa.data.model.Workflow
import kotlinx.android.synthetic.main.item_workflow.view.*

class WorkflowAdapter : RecyclerView.Adapter<WorkflowAdapter.WorkflowHolder>() {

    private var workflowList = emptyList<Workflow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WorkflowHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_workflow, parent, false)
    )

    override fun onBindViewHolder(holder: WorkflowHolder, position: Int) {
        val word = workflowList[position]
        holder.setData(word)
    }

    override fun getItemCount() = workflowList.size

    fun setWorflowList(wordList: List<Workflow>?) {
        this.workflowList = wordList!!
        notifyDataSetChanged()
    }

    class WorkflowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.textName
        private val questionSize: TextView = itemView.questionSize

        fun setData(workflow: Workflow) {
            name.text = workflow.name
            questionSize.text = "Question size: ${workflow.questions.size}"
        }
    }
}
