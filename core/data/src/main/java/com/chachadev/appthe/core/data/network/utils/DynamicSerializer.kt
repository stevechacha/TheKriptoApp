package com.chachadev.appthe.core.data.network.utils

import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object DynamicSerializer : KSerializer<Any?> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Dynamic") {
        element<String>("string", isOptional = true)
        element<Int>("int", isOptional = true)
        element<List<*>>("list", isOptional = true)
        element<Map<*, *>>("map", isOptional = true)
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Any?) {
        when (value) {
            is String -> encoder.encodeString(value)
            is Int -> encoder.encodeInt(value)
            is List<*> -> {
                val listSerializer = ListSerializer(serializer<Any?>())
                encoder.encodeSerializableValue(listSerializer, value)
            }
            is Map<*, *> -> {
                val mapSerializer = MapSerializer(serializer<Any?>(), serializer<Any?>())
                encoder.encodeSerializableValue(mapSerializer, value as Map<Any?, Any?>)
            }
            null -> encoder.encodeNull()
            else -> throw SerializationException("Unsupported type: ${value::class}")
        }
    }

    override fun deserialize(decoder: Decoder): Any {
        // This implementation assumes you're dealing with JSON input.
        val input = decoder as? JsonDecoder
            ?: throw SerializationException("This serializer only works with JSON")
        
        val element = input.decodeJsonElement()
        return when {
            element.jsonPrimitive.isString -> element.jsonPrimitive.content
            element.jsonPrimitive.intOrNull != null -> element.jsonPrimitive.int
            true -> element.jsonArray.map { it.toString() }
            true -> element.jsonObject.mapKeys { it.key }
            else -> throw SerializationException("Unsupported JSON structure: $element")
        }
    }
}
