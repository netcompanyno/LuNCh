package no.netcompany.apps.lunch.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import no.netcompany.apps.lunch.model.Person
import no.netcompany.apps.lunch.model.LunchLog
import no.netcompany.apps.lunch.service.RegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class Query(@Autowired private val registrationService: RegistrationService): GraphQLQueryResolver {
    fun getLunchLogs(): List<LunchLog> {
        return emptyList()
    }

    fun getPersons(): List<Person> {
        val personsFuture = registrationService.getPersons()
        return personsFuture.get(10, TimeUnit.SECONDS)
    }
}