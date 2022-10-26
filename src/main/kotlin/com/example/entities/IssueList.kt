package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object IssueList: Table<Nothing>("IssueList") {
    val IssueId     = int("IssueId").primaryKey()
    val id          = int("id")
    val title       = varchar("title")
    val IssueDate   = varchar("IssueDate")
    val ReturnDate  = varchar("ReturnDate")
    val Remark      = varchar("Remark")
}