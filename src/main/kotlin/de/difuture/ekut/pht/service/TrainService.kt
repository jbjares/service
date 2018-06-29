package de.difuture.ekut.pht.service

import de.difuture.ekut.pht.api.TrainIdentifier
import de.difuture.ekut.pht.entity.Train
import de.difuture.ekut.pht.repository.TrainRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional


@Service
class TrainService
@Autowired constructor(private val trainRepository: TrainRepository) {

    fun findAll() : Iterable<Train> = trainRepository.findAll()

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun ensureTrain(trainIdentifier: TrainIdentifier) : Train {

        val trains = trainRepository.findByIdentifier(trainIdentifier)

        if (trains.isEmpty()) {

            return this.trainRepository.save(Train(trainIdentifier))
        }
        return trains[0]
    }
}
