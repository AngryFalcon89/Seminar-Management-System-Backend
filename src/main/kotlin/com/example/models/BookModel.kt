package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class BookModel(
    val Id: Int,
    val Accession_Number: String,
    val Mal_Acc_no: String,
    val Author: String,
    val Title: String,
    val Book_Status: String,
    val Edition: String,
    val Publisher: String,
    val Catagory_1: String,
    val Catagory_2: String,
    val Catagory_3: String,
    val Publishing_year: String,
    val Author_1: String,
    val Author_2: String,
    val Author_3: String,
)
