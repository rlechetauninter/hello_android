package com.example.helloandroid.domain

import java.io.Serializable

data class Usuario (
    var nome: String,
    var email: String
) : Serializable
