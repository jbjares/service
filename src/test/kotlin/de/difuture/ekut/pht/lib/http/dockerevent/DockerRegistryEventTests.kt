package de.difuture.ekut.pht.service.lib.core.dockerevent

import com.fasterxml.jackson.databind.ObjectMapper
import de.difuture.ekut.pht.functions.equalAfterSerialization
import de.difuture.ekut.pht.lib.http.event.DockerRegistryEvent
import io.github.benas.randombeans.api.EnhancedRandom
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DockerRegistryEventTests {

    private var events: List<DockerRegistryEvent>? = null

    @Before
    fun setUp() {

        this.events = EnhancedRandom.randomListOf(20, DockerRegistryEvent::class.java)
    }

    @Test
    fun testSerialization() {

        val mapper = ObjectMapper()
        this.events!!.forEach { equalAfterSerialization(it, mapper, DockerRegistryEvent::class.java) }
    }

    @After
    fun tearDown() {

        this.events = null
    }
}
