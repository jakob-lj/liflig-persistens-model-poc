package org.jakoblj.persistens.persistensmodel.computersoda

import kotlinx.serialization.Serializable
import no.liflig.documentstore.dao.CrudDaoJdbi
import no.liflig.documentstore.entity.AbstractEntityRoot
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSoda
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSodaId

typealias ComputerSodaDao = CrudDaoJdbi<ComputerSodaId, StoredComputerSoda>

@Serializable
class StoredComputerSoda(
    override val id: ComputerSodaId = ComputerSodaId(),
    val brand: String,
    val flavor: String,
    val size: Int,
) : AbstractEntityRoot<ComputerSodaId>() {

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
    id = id,
    brand = brand,
    flavor = flavor,
    size = size,
)

fun StoredComputerSoda.toComputerSoda() = ComputerSoda(
    id = id,
    brand = brand,
    flavor = flavor,
    size = size,
)