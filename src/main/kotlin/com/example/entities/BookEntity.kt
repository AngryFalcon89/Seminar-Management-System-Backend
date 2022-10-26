package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object BookEntity: Table<Nothing>("Books"){
    val id                   = int("id").primaryKey()
    val Accession_Number     = varchar("Accession_Number")
    val Mal_Acc_No           = varchar("Mal_Acc_no")
    val Author               = varchar("Author")
    val Title                = varchar("Title")
    val Book_Status          = varchar("Book_Status")
    val Edition              = varchar("Edition")
    val Publisher            = varchar("Publisher")
    val Category1            = varchar("Catagory_1")
    val Category2            = varchar("Catagory_2")
    val Category3            = varchar("Catagory_3")
    val Publishing_Year      = varchar("Publishing_Year")
    val Author_1             = varchar("Author_1")
    val Author_2             = varchar("Author_2")
    val Author_3             = varchar("Author_3")
}