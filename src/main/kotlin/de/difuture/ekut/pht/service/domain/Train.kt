package de.difuture.ekut.pht.service.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


/**
 * Represents the logical entity of a train with all train properties
 *
 */
@Entity
data class Train(
        @Id @GeneratedValue
        val id: Int = 0,
        val trainId : String,
        val departureId: String,
        val
)
