package com.fritte.demohiltsa.data.model

import java.util.*

data class Workflow(
    val id : String,
    val createdAt : Date,
    val name : String,
    val questions : List<Question>
)