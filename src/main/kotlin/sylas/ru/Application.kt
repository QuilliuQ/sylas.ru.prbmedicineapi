package sylas.ru

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.contentnegotiation.*
import sylas.ru.plugins.*

fun main() {
    embeddedServer(CIO, port = 4914, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()

    install(ContentNegotiation){
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
}
