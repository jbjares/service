package de.difuture.ekut.pht.functions

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert

fun <T> equalAfterSerialization(
        item: T, mapper: ObjectMapper, clazz : Class<T>) {

    // Write train to String
    val serialized = mapper.writeValueAsString(item)
    // Get the train back from the string
    val item2 = mapper.readValue(serialized, clazz)

    Assert.assertEquals(item, item2)
}
