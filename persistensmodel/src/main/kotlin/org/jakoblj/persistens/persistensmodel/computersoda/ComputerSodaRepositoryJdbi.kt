package org.jakoblj.persistens.persistensmodel.computersoda

import no.liflig.documentstore.entity.Version
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSoda
import org.jakoblj.persistens.domainmodel.computersoda.ComputerSodaId

class ComputerSodaRepositoryJdbi(val computerSodaDao: ComputerSodaDao) : ComputerSodaRepository {

    override suspend fun create(item: ComputerSoda): ComputerSoda {
        return computerSodaDao.create(
            item.toStoredComputerSoda()
        ).item.toComputerSoda()
    }

    override suspend fun get(id: ComputerSodaId): ComputerSoda? {
        return computerSodaDao.get(id)?.item?.toComputerSoda()
    }

    override suspend fun update(item: ComputerSoda): ComputerSoda {
        // TODO!!
        return computerSodaDao.update(item.toStoredComputerSoda(), Version.initial().next()).item.toComputerSoda()
    }

    override suspend fun delete(id: ComputerSodaId) {
        // TODO!!
        computerSodaDao.delete(id, Version.initial())
    }


}