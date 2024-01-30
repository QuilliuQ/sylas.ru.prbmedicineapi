package sylas.ru.plugins

import QueueData
import Response
import Role
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun Application.configureRouting() {
    routing {
        get("/PersonLocations") {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            val resultList : ArrayList<QueueData> = arrayListOf()
            val listSize = (20..100).random()
            repeat(listSize){
                resultList.add(
                    QueueData(
                        (100000..1000000).random(),
                        Role.entries.random().text,
                        (0..22).random(),
                        EntryType.entries.random().text,
                        formatter.format(LocalDateTime.now().minusSeconds((0L..50L).random()))
                    )
                )
            }
            call.respond(HttpStatusCode.OK,Response(resultList))
        }
    }
}

