package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class BookResponse<T>(
    val data: T,
    val success: Boolean
)
