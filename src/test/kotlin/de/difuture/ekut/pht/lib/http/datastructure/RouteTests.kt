package de.difuture.ekut.pht.service.lib.core.datastructure

import com.fasterxml.jackson.databind.ObjectMapper
import de.difuture.ekut.pht.functions.equalAfterSerialization
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class RouteTests {

    private var linearRoutes: Array<Route>? = null
    private var treeRoutes: Array<Route>? = null     // only one parent for each node
    private var joinRoutes: Array<Route>? = null     // multiple parents for at least one node

    @Before
    fun setUp() {

        val emptyRoute = Route.Builder().build()
        val route1 = Route.Builder().edge(1L, 2L).build()

        val route2 = Route.Builder()
                .edge(1L, 2L)
                .edge(2L, 3L).build()

        val route3 = Route.Builder()
                .edge(5L, 3L)
                .edge(3L, 10L)
                .edge(10L, 4L).build()

        this.linearRoutes = arrayOf(emptyRoute, route1, route2, route3)

        val route4 = Route.Builder()
                .edge(1L, 2L)
                .edge(1L, 3L).build()

        this.treeRoutes = arrayOf(route4)


        val route5 = Route.Builder()
                .edge(1L, 2L)
                .edge(3L, 2L).build()

        this.joinRoutes = arrayOf(route5)
    }

    @After
    fun tearDown() {

        this.linearRoutes = null
        this.treeRoutes = null
        this.joinRoutes = null
    }


    @Test
    fun stationEqualAfterSerializationAndDeserialization() {

        val mapper = ObjectMapper()

        for (route in this.linearRoutes!!) {
            equalAfterSerialization(route, mapper, Route::class.java)
        }

        for (route in this.treeRoutes!!) {
            equalAfterSerialization(route, mapper, Route::class.java)
        }
    }



    // Test that the creation of circular routes is prevented

    @Test(expected = IllegalArgumentException::class)
    fun circularRootsAreNotAllowed1() {
        Route.Edge(1L, 1L)
    }

    @Test(expected = IllegalArgumentException::class)
    fun circularRootsAreNotAllowed2() {
        Route.Edge(6751L, 6751L)
    }

    @Test(expected = IllegalArgumentException::class)
    fun circularRootsAreNotAllowed3() {
        Route.Edge(0L, 0L)
    }

    @Test(expected = IllegalArgumentException::class)
    fun circularRootsAreNotAllowed4() {
        Route.Edge(-1L, -1L)
    }
}
