package org.jakoblj.persistens.persistensmodel.computersoda

import org.jakoblj.persistens.domainmodel.computersoda.ComputerSoda
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSodaId

interface ComputerSodaRepository {
    suspend fun create(item: ComputerSoda): ComputerSoda
    suspend fun get(id: ComputerSodaId): ComputerSoda?
    suspend fun update(item: ComputerSoda): ComputerSoda
    suspend fun delete(id: ComputerSodaId)
}
