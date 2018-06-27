package de.difuture.ekut.pht.controller

import de.difuture.ekut.pht.api.TrainNode
import de.difuture.ekut.pht.entity.Train
import de.difuture.ekut.pht.service.NodeService
import de.difuture.ekut.pht.service.TrainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/train")
class TrainController
@Autowired constructor(
        private val trainService: TrainService,
        private val nodeService: NodeService) {

    @PostMapping
    fun create() : TrainNode {

        // Create Train entity, and a node entity with the initial image
        val train = this.trainService.createNewtrain()
        val node = this.nodeService.createNewNode(train)
        return TrainNode(train.id!!, node.id!!)
    }

    @GetMapping
    fun get() : Iterable<Train> = this.trainService.findAll()
}
