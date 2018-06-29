package de.difuture.ekut.pht.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;


@Configuration
@EnableTransactionManagement
class Neo4jConfig {

    @Bean
    fun configuration(): org.neo4j.ogm.config.Configuration {

        return org.neo4j.ogm.config.Configuration.Builder()
                .uri("bolt://neo4j:7687")
                .build()
    }

    @Bean
    fun sessionFactory(configuration: org.neo4j.ogm.config.Configuration): SessionFactory {

        return SessionFactory(
                configuration, "de.difuture.ekut.pht.repository", "de.difuture.ekut.pht.entity")
    }

    @Bean("transactionManager")
    fun neo4jTransactionManager(sessionFactory: SessionFactory): Neo4jTransactionManager {

        return Neo4jTransactionManager(sessionFactory)
    }
}
