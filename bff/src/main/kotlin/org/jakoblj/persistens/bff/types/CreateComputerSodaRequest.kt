package org.jakoblj.persistens.bff.types

import kotlinx.serialization.Serializable
import org.jakoblj.persistens.bff.createBodyLens

@Serializable
data class CreateComputerSodaRequest(
    val brand: String,
    val flavor: String,
    val size: Int,
) {
    companion object{
        val bodyLens by lazy { createBodyLens(serializer()) }
    }
}
