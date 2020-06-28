package com.fritte.demohiltsa.data.model

import java.util.*

data class User(
    val id : String,
    val createdAt : Date,
    val name : String,
    val avatar : String,
    val email : String,
    val phone : String,
    val country : String
)