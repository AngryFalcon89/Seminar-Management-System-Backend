package com.example.routing

import com.example.db.DatabaseConnection
import com.example.entities.BookEntity
import com.example.entities.UserEntity
import com.example.models.BookModel
import com.example.models.BookResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*

fun Application.booksRoutes() {
    val db = DatabaseConnection.database

    routing {
        get("/books") {
            val books = db.from(BookEntity).select()
                .map {
                    val id = it[BookEntity.id]
                    val Accession_Number = it[BookEntity.Accession_Number]
                    val Mal_Acc_no = it[BookEntity.Mal_Acc_No]
                    val Author = it[BookEntity.Author]
                    val Title = it[BookEntity.Title]
                    val Book_Status = it[BookEntity.Book_Status]
                    val Edition = it[BookEntity.Edition]
                    val Publisher = it[BookEntity.Publisher]
                    val Catagory_1 = it[BookEntity.Category1]
                    val Catagory_2 = it[BookEntity.Category2]
                    val Catagory_3 = it[BookEntity.Category3]
                    val Publishing_year = it[BookEntity.Publishing_Year]
                    val Author_1 = it[BookEntity.Author_1]
                    val Author_2 = it[BookEntity.Author_2]
                    val Author_3 = it[BookEntity.Author_3]
                    BookModel(
                        id ?: -1,
                        Accession_Number ?: "",
                        Mal_Acc_no ?: "",
                        Author ?: "",
                        Title ?: "",
                        Book_Status ?: "",
                        Edition ?: "",
                        Publisher ?: "",
                        Catagory_1 ?: "",
                        Catagory_2 ?: "",
                        Catagory_3 ?: "",
                        Publishing_year ?: "",
                        Author_1 ?: "",
                        Author_2 ?: "",
                        Author_3 ?: ""
                    )
                }
            call.respond(books)
        }

        post("/books") {
            val request = call.receive<BookModel>()
            val result = db.insert(BookEntity) {
                set(it.id, request.Id)
                set(it.Accession_Number, request.Accession_Number)
                set(it.Mal_Acc_No, request.Mal_Acc_no)
                set(it.Author, request.Author)
                set(it.Title, request.Title)
                set(it.Book_Status, request.Book_Status)
                set(it.Edition, request.Edition)
                set(it.Publisher, request.Publisher)
                set(it.Category1, request.Catagory_1)
                set(it.Category2, request.Catagory_2)
                set(it.Category3, request.Catagory_3)
                set(it.Publishing_Year, request.Publishing_year)
                set(it.Author_1, request.Author_1)
                set(it.Author_2, request.Author_2)
                set(it.Author_3, request.Author_3)
            }
            if (result == 1) {
                //Send successfully respond to the client
                call.respond(
                    HttpStatusCode.OK, BookResponse(
                        success = true,
                        data = "Value has been successfully inserted"
                    )
                )
            }
            else {
                //Send failure respond to the client
                call.respond(
                    HttpStatusCode.BadRequest, BookResponse(
                        success = false,
                        data = "Failed to insert values"
                    )
                )
            }
        }

        get("/books/{id}") {
            val id = call.parameters["id"]?.toInt() ?: -1
            val book = db.from(BookEntity)
                .select()
                .where { BookEntity.id eq id }
                .map {
                    val id = it[BookEntity.id]
                    val Accession_Number = it[BookEntity.Accession_Number]
                    val Mal_Acc_no = it[BookEntity.Mal_Acc_No]
                    val Author = it[BookEntity.Author]
                    val Title = it[BookEntity.Title]
                    val Book_Status = it[BookEntity.Book_Status]
                    val Edition = it[BookEntity.Edition]
                    val Publisher = it[BookEntity.Publisher]
                    val Catagory_1 = it[BookEntity.Category1]
                    val Catagory_2 = it[BookEntity.Category2]
                    val Catagory_3 = it[BookEntity.Category3]
                    val Publishing_year = it[BookEntity.Publishing_Year]
                    val Author_1 = it[BookEntity.Author_1]
                    val Author_2 = it[BookEntity.Author_2]
                    val Author_3 = it[BookEntity.Author_3]
                    BookModel(
                        id ?: -1,
                        Accession_Number ?: "",
                        Mal_Acc_no ?: "",
                        Author ?: "",
                        Title ?: "",
                        Book_Status ?: "",
                        Edition ?: "",
                        Publisher ?: "",
                        Catagory_1 ?: "",
                        Catagory_2 ?: "",
                        Catagory_3 ?: "",
                        Publishing_year ?: "",
                        Author_1 ?: "",
                        Author_2 ?: "",
                        Author_3 ?: ""
                    )
                }.firstOrNull()
            if (book == null) {
                call.respond(
                    HttpStatusCode.NotFound,
                    BookResponse(
                        success = false,
                        data = "Could not find note with id = $id"
                    )
                )
            }
            else {
                call.respond(
                    HttpStatusCode.OK,
                    BookResponse(
                        success = true,
                        data = book
                    )
                )
            }
        }

        put("/books/{id}"){
            val id =call.parameters["id"]?.toInt() ?: -1
            val updatedNote =call.receive<BookModel>()
            val rowsEffected = db.update(BookEntity){
                set(it.id, updatedNote.Id)
                set(it.Accession_Number, updatedNote.Accession_Number)
                set(it.Mal_Acc_No, updatedNote.Mal_Acc_no)
                set(it.Author, updatedNote.Author)
                set(it.Title, updatedNote.Title)
                set(it.Book_Status, updatedNote.Book_Status)
                set(it.Edition, updatedNote.Edition)
                set(it.Publisher, updatedNote.Publisher)
                set(it.Category1, updatedNote.Catagory_1)
                set(it.Category2, updatedNote.Catagory_2)
                set(it.Category3, updatedNote.Catagory_3)
                set(it.Publishing_Year, updatedNote.Publishing_year)
                set(it.Author_1, updatedNote.Author_1)
                set(it.Author_2, updatedNote.Author_2)
                set(it.Author_3, updatedNote.Author_3)
                where{
                    it.id eq id
                }
            }

            if(rowsEffected == 1) {
                call.respond(
                    HttpStatusCode.OK,
                    BookResponse(
                        success = true,
                        data = "Book has been updated"
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.BadRequest,
                    BookResponse(
                        success = false,
                        data = "Book failed to update"
                    )
                )
            }
        }

        delete("/books/{id}") {
            val id = call.parameters["id"]?.toInt() ?: -1
            val rowsEffected = db.delete(BookEntity) {
                it.id eq id
            }
            if (rowsEffected == 1) {
                call.respond(
                    HttpStatusCode.OK,
                    BookResponse(
                        success = true,
                        data = "Book has been delete"
                    )
                )
            }
            else {
                call.respond(
                    HttpStatusCode.BadRequest,
                    BookResponse(
                        success = false,
                        data = "Book failed to delete"
                    )
                )
            }
        }
    }
}