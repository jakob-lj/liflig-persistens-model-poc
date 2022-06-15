package org.jakoblj.persistens.persistensmodel.computersoda

import kotlinx.serialization.Serializable
import no.liflig.documentstore.dao.CrudDaoJdbi
import no.liflig.documentstore.entity.AbstractEntityRoot
import no.liflig.documentstore.entity.Version
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSoda
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSodaId

typealias ComputerSodaDao = CrudDaoJdbi<StoredComputerSodaId, StoredComputerSoda>

@Serializable
data class StoredComputerSoda(
    override val id: StoredComputerSodaId,
    val brand: String,
    val flavor: String,
    val size: Int,
) : AbstractEntityRoot<StoredComputerSodaId>() {

    fun update(
        brand: String = this.brand,
        flavor: String = this.flavor,
        size: Int = this.size
    ) = StoredComputerSoda(
        id = id,
        brand = brand,
        flavor = flavor,
        size = size,
    )
}

fun ComputerSoda.toStoredComputerSoda() = StoredComputerSoda(
    id = id.toStoredComputerSodaId(),
    brand = brand,
    flavor = flavor,
    size = size,
)

fun StoredComputerSoda.toComputerSoda(version: Version) = ComputerSoda(
    id = id.toComputerSodaId(),
    brand = brand,
    flavor = flavor,
    size = size,
    version = version,
)

fun ComputerSodaId.toStoredComputerSodaId() = StoredComputerSodaId(id)

fun StoredComputerSodaId.toComputerSodaId() = ComputerSodaId(id)