package de.difuture.ekut.pht.api


import de.difuture.ekut.pht.functions.allEqualAfterSerialization
import io.github.benas.randombeans.api.EnhancedRandom
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner




@RunWith(SpringRunner::class)
@SpringBootTest
class NodeTests {

    private var trainNodes: List<TrainNode>? = null

    @Before
    fun setUp() {

        this.trainNodes = EnhancedRandom.randomListOf(20, TrainNode::class.java)
    }

    @After
    fun tearDown() {

        this.trainNodes = null
    }

    @Test
    fun serializeDeserialize() {

        allEqualAfterSerialization(this.trainNodes!!, TrainNode::class.java)
    }
}
