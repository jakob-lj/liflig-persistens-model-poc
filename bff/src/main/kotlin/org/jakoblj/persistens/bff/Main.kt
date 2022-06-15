package org.jakoblj.persistens.bff

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.runBlocking
import no.liflig.documentstore.dao.CrudDaoJdbi
import org.http4k.contract.bindContract
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.then
import org.http4k.core.with
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.jakoblj.persistens.bff.types.ComputerSodaDto
import org.jakoblj.persistens.bff.types.CreateComputerSodaRequest
import org.jakoblj.persistens.bff.types.toDto
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSoda
import org.jakoblj.persistens.persistensmodel.computersoda.ComputerSodaRepositoryJdbi
import org.jakoblj.persistens.persistensmodel.computersoda.StoredComputerSoda
import org.jakoblj.persistens.persistensmodel.computersoda.StoredComputerSodaId
import org.jakoblj.persistens.persistensmodel.serialization.storedComputerSodaSerializationAdapter
import org.jdbi.v3.core.Jdbi
import java.util.*

fun main() {

    val config = HikariConfig()
    config.jdbcUrl = "jdbc:postgresql://localhost:10101/lifligpass"
    config.driverClassName = "org.postgresql.Driver"
    config.username = "liflig"
    config.password = "password"

    val jdbi = Jdbi.create(HikariDataSource(config))

    val computerSodaDao =
        CrudDaoJdbi(jdbi, "cs", storedComputerSodaSerializationAdapter)

    val computerSodaRepositoryJdbi = ComputerSodaRepositoryJdbi(computerSodaDao)

    val printingApp: HttpHandler = PrintRequest().then(routes(
        "/computer-soda" bind Method.POST to { req ->
            runBlocking {
                val body = CreateComputerSodaRequest.bodyLens(req)
                val computerSoda = computerSodaRepositoryJdbi.create(
                    ComputerSoda.create(
                        brand = body.brand,
                        flavor = body.flavor,
                        size = body.size,
                    )
                )
                Response(Status.OK).with(ComputerSodaDto.bodyLens of computerSoda.toDto())
            }
        }
    ))

    runBlocking {
        println(computerSodaDao.get(StoredComputerSodaId(UUID.fromString("a900ebd1-eea5-4542-ae54-dbbbb1c64c4e"))))
    }

    val server = printingApp.asServer(Jetty(9000)).start()

    println("Server started on " + server.port())
}
