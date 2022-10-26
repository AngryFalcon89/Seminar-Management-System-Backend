package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object StaffList: Table<Nothing>("StaffList"){
    val id              = int("id").primaryKey()
    val name            = varchar("name")
    val department      = varchar("department")
    val email           = varchar("email")
    val contactNumber   = varchar("contactNumber")
    val IssueId         = int("IssueId")
}