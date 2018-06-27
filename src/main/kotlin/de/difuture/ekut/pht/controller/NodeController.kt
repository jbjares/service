package de.difuture.ekut.pht.controller

import de.difuture.ekut.pht.api.TrainNode
import de.difuture.ekut.pht.service.NodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/node")
class NodeController
@Autowired constructor(
        private val nodeService: NodeService) {


    @GetMapping
    fun getAll() : Iterable<TrainNode>  =

        nodeService.findAll(2).map { TrainNode(it.train.id!!, it.id!!) }
}
