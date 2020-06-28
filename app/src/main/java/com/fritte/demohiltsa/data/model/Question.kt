package com.fritte.demohiltsa.data.model

data class Question(
    val id : String,
    val name : String,
    val desc : String,
    val type : Int,
    val answer : String
)