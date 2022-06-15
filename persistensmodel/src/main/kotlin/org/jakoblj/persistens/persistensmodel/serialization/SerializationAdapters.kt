package org.jakoblj.persistens.persistensmodel.serialization

import org.jakoblj.persistens.persistensmodel.KotlinXSerializationAdapter
import org.jakoblj.persistens.persistensmodel.computersoda.StoredComputerSoda

val storedComputerSodaSerializationAdapter by lazy { KotlinXSerializationAdapter(StoredComputerSoda.serializer()) }