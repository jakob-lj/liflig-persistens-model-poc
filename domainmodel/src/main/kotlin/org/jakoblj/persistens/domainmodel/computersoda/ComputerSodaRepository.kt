package org.jakoblj.persistens.domainmodel.computersoda


interface ComputerSodaRepository {
    suspend fun create(item: ComputerSoda): ComputerSoda
    suspend fun get(id: ComputerSodaId): ComputerSoda?
    suspend fun update(item: ComputerSoda): ComputerSoda
    suspend fun delete(id: ComputerSodaId)
}
