package de.difuture.ekut.pht.entity

import de.difuture.ekut.pht.api.TrainIdentifier
import de.difuture.ekut.pht.entity.converter.TrainIdentifierConverter
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.typeconversion.Convert


@NodeEntity
class Train(

        @Convert(TrainIdentifierConverter::class)
        var identifier : TrainIdentifier? = null
) {

    @Id @GeneratedValue
    var id: Long? = null
}
