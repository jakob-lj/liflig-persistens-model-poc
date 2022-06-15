package org.jakoblj.persistens.persistensmodel.computersoda

import no.liflig.documentstore.entity.UuidEntityId
import java.util.UUID

@kotlinx.serialization.Serializable(with = StoredComputerSodaIdSerializer::class)
data class StoredComputerSodaId(override val id: UUID = UUID.randomUUID()) : UuidEntityId {
    override fun toString() = id.toString()
}

object StoredComputerSodaIdSerializer : UuidEntityIdSerializer<StoredComputerSodaId>(::StoredComputerSodaId)