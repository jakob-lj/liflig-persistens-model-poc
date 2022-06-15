package org.jakoblj.persistens.persistensmodel.computersoda

import no.liflig.documentstore.entity.Version
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSoda
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSodaId
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSodaRepository

class ComputerSodaRepositoryJdbi(val computerSodaDao: ComputerSodaDao) : ComputerSodaRepository {

    override suspend fun create(item: ComputerSoda): ComputerSoda {
        val computerSoda = computerSodaDao.create(
            item.toStoredComputerSoda()
        )

        return computerSoda.item.toComputerSoda(computerSoda.version)
    }

    override suspend fun get(id: ComputerSodaId): ComputerSoda? {
        val computerSoda = computerSodaDao.get(id.toStoredComputerSodaId())

        return computerSoda?.item?.toComputerSoda(computerSoda.version)
    }

    override suspend fun update(item: ComputerSoda): ComputerSoda {
        val computerSoda = computerSodaDao.update(item.toStoredComputerSoda(), item.version)

        return computerSoda.item.toComputerSoda(computerSoda.version)
    }

    override suspend fun delete(id: ComputerSodaId) {
        // TODO!!
        computerSodaDao.delete(id.toStoredComputerSodaId(), Version.initial())
    }
}