package com.example.models

import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class UserCredentials(
    val username: String,
    val password: String
){
    //helper functions
    fun hashedPassword(): String {
        return BCrypt.hashpw(password,BCrypt.gensalt())
    }
    fun isValidCredential():Boolean{
        return username.length >=3 && password.length >=8
    }
}
