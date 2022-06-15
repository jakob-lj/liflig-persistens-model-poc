package org.jakoblj.persistens.domainmodel.computersoda

import java.util.UUID

data class ComputerSodaId(
    val id: UUID = UUID.randomUUID()
)