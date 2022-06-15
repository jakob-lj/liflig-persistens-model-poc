package org.jakoblj.persistens.bff.types

import kotlinx.serialization.Serializable
import org.jakoblj.persistens.bff.createBodyLens
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSoda
import org.jakoblj.persistens.persistensmodel.computersoda.StoredComputerSodaId
import org.jakoblj.persistens.persistensmodel.computersoda.toStoredComputerSodaId

@Serializable
data class ComputerSodaDto(val id: StoredComputerSodaId, val brand: String, val flavor: String, val size: Int) {
    companion object {
        val bodyLens by lazy { createBodyLens(serializer()) }
    }
}

fun ComputerSoda.toDto() = ComputerSodaDto(
    brand = brand,
    flavor = flavor,
    size = size,
    id = id.toStoredComputerSodaId(),
)