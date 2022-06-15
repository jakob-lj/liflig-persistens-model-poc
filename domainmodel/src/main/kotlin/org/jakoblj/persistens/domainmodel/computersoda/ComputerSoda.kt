package org.jakoblj.persistens.domainmodel.computersoda

import no.liflig.documentstore.entity.Version

class ComputerSoda(
    val id: ComputerSodaId = ComputerSodaId(),
    val brand: String,
    val flavor: String,
    val size: Int,
    val version: Version,
) {
    companion object {
        fun create(
            brand: String,
            flavor: String,
            size: Int
        ) = ComputerSoda(
            brand = brand,
            flavor = flavor,
            size = size,
            version = Version.initial(),
        )
    }

    fun update(
        brand: String = this.brand,
        flavor: String = this.flavor,
        size: Int = this.size
    ) = ComputerSoda(
        id = this.id,
        brand = brand,
        flavor = flavor,
        size = size,
        version = version,
    )
}