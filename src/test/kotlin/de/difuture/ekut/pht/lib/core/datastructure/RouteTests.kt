package de.difuture.ekut.pht.lib.core.datastructure

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.After
import org.junit.Assert
import java.io.IOException
import org.junit.Before
import org.junit.Test


class RouteTest {

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

    @Throws(IOException::class)
    private fun sameRouteSerializatin(
            route: Route, mapper: ObjectMapper) {

        // Write train to String
        val serialized = mapper.writeValueAsString(route)
        // Get the train back from the string
        val route2 = mapper.readValue(serialized, Route::class.java)

        Assert.assertEquals(route, route2)
    }

    @Test
    @Throws(IOException::class)
    fun stationEqualAfterSerializationAndDeserialization() {

        val mapper = ObjectMapper()

        for (route in this.linearRoutes!!) {
            sameRouteSerializatin(route, mapper)
        }

        for (route in this.treeRoutes!!) {
            sameRouteSerializatin(route, mapper)
        }
    }
}
