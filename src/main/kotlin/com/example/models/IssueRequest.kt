package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class IssueRequest(
    val IssueId: Int,
    val StaffName: String,
    val email: String?,
    val remarks: String?
)
