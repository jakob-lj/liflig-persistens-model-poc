package org.jakoblj.persistens.persistensmodel

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import no.liflig.documentstore.dao.SerializationAdapter
import no.liflig.documentstore.entity.AbstractEntityRoot


class KotlinXSerializationAdapter<E : AbstractEntityRoot<*>>
    (val serializer: KSerializer<E>) : SerializationAdapter<E> {

    val json: Json = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    override fun toJson(entity: E): String = json.encodeToString(serializer, entity)

    override fun fromJson(value: String): E = json.decodeFromString(serializer, value)
}
