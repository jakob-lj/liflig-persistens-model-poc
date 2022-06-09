package org.jakoblj.persistens.domainmodel.computersoda

import kotlinx.serialization.Serializable
import no.liflig.documentstore.entity.UuidEntityId
import org.jakoblj.persistens.persistensmodel.computersoda.UuidEntityIdSerializer
import java.util.*

@Serializable(with = ComputerSodaIdSerializer::class)
data class ComputerSodaId(
    override val id: UUID = UUID.randomUUID()
) : UuidEntityId {
    override fun toString(): String = id.toString()
}

object ComputerSodaIdSerializer : UuidEntityIdSerializer<ComputerSodaId>(::ComputerSodaId)
