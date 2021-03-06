package com.packtpub.alumni

import com.packtpub.alumni.controller.registerRedirections
import com.packtpub.alumni.controller.version1
import com.packtpub.alumni.controller.version2
import com.packtpub.alumni.module.dataSourceModule
import com.packtpub.alumni.module.handlerModule
import io.ebean.Database
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.util.KtorExperimentalAPI
import org.koin.Logger.slf4jLogger
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.get

@KtorExperimentalAPI
fun Application.alumniModule() {
    install(ContentNegotiation) {
        gson {
        }
    }


    install(Koin) {
        slf4jLogger()

        modules(dataSourceModule, handlerModule)
    }

    install(StatusPages) {
        registerRedirections()
    }

    routing {
        val database = get<Database>()
        get("/") {
            call.respondText("Hello World, Ebean Database Name = ${database.name}")
        }

        version1()

        version2()
    }

}


