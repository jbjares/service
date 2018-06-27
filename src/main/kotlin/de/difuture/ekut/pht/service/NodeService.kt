package de.difuture.ekut.pht.service

import de.difuture.ekut.pht.entity.Node
import de.difuture.ekut.pht.entity.Train
import de.difuture.ekut.pht.repository.NodeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class NodeService
@Autowired constructor(private val nodeRepository: NodeRepository) {

    fun createNewNode(train : Train) : Node = this.nodeRepository.save(Node(train))

    fun findAll(depth : Int) : Iterable<Node> = this.nodeRepository.findAll(depth)
}
