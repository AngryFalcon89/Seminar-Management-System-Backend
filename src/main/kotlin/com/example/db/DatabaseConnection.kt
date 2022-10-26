package com.example.db

import org.ktorm.database.Database

/**
 * have to change url and driver when hosted with the database url and driver that is actually on the server
 */
object DatabaseConnection{
    val database = Database.connect(
        url = "jdbc:mysql://localhost:3306/Seminar_Managment_System",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "S7f8a#z3h4a"
    )
}