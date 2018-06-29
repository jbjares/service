package de.difuture.ekut.pht.service

import de.difuture.ekut.pht.api.TrainIdentifier
import de.difuture.ekut.pht.entity.Train
import de.difuture.ekut.pht.repository.TrainRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TrainService
@Autowired constructor(private val trainRepository: TrainRepository) {

    fun findAll() : Iterable<Train> = trainRepository.findAll()

    fun ensureTrain(trainIdentifier: TrainIdentifier) : Train =

        trainRepository.findByIdentifier(trainIdentifier).orElseGet { trainRepository.save(Train(trainIdentifier)) }
}
