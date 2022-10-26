package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import com.example.utils.TokenManager
import com.typesafe.config.ConfigFactory
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 9090, host = "0.0.0.0") {
        val config = HoconApplicationConfig(ConfigFactory.load())
        val tokenManager = TokenManager(config)
        install(Authentication){
            jwt {
                verifier(tokenManager.verifyJWTToken())
                realm = config.property("realm").getString()
                validate {jwtCredential->
                    if(jwtCredential.payload.getClaim("username").asString().isNotEmpty()){
                        JWTPrincipal(jwtCredential.payload)
                    }else{
                        null
                    }
                }
            }
        }
        install(ContentNegotiation) {
            json()
        }
        configureRouting()
    }.start(wait = true)
}